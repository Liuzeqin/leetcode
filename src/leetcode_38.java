import java.util.ArrayList;
import java.util.List;

public class leetcode_38 {
    /**
     * 题目：外观数列
     */

    public String countAndSay1(int n) {
        if (n < 1 || n > 30) return "";
        String ans = "1";
        while (--n > 0) {
            List<String> num = new ArrayList<>();
            List<Integer> count = new ArrayList<>();
            Integer cur = 0;//用来表示重复字符的起点
            for (int i = 1; i < ans.length() + 1; i++) {
                if (i == ans.length()) {
                    num.add(String.valueOf(ans.charAt(cur)));
                    count.add(i - cur);
                }else if (ans.charAt(i) != ans.charAt(cur)) {
                    num.add(String.valueOf(ans.charAt(cur)));
                    count.add(i - cur);
                    cur = i;
                }
            }
            ans = "";
            for (int j = 0; j < num.size(); j++) {
                ans += String.valueOf(count.get(j)) + num.get(j);
            }
        }
        return ans;
    }
    //方法的思想基本一致，要点在于对重复元素的起点做标记,不过下面这种效率更高，stringbuilder是个好东西
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuffer res = new StringBuffer();
        String str = countAndSay(n - 1);
        int length = str.length();
        int a = 0;
        for (int i = 1; i < length + 1; i++) {
            if (i == length) {
                return res.append(i - a).append(str.charAt(a)).toString();
            } else if (str.charAt(i) != str.charAt(a) ) {
                res.append(i - a).append(str.charAt(a));
                a = i;
            }
        }
        return res.toString();
    }

}

