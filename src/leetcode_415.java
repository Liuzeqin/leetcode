
public class leetcode_415 {
    /**
     * 题目: 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     */

    public String addStrings(String num1, String num2) {
        Integer size1 = num1.length();
        Integer size2 = num2.length();
        Integer size = Math.min(size1, size2);
        Byte flag = 0;
        String res = "";
        for (int i =1; i <= size; i++){
            Integer n1 = num1.charAt(size1 - i) - '0';
            Integer n2 = num2.charAt(size2 - i) - '0';
            if (n1 + n2 + flag >= 10){
                Integer tmp = n1 + n2 + flag - 10;
                res += tmp.toString();
                flag = 1;
            }else {
                Integer tmp = n1 + n2 + flag;
                res += tmp.toString();
                flag = 0;
            }
        }
        String tmpNum = "";
        if (size1 > size2) {
            tmpNum = num1.substring(0, size1 - size2);
        }else if (size1 < size2) {
            tmpNum = num2.substring(0, size2 - size1);
        }
        Integer tmpSize = tmpNum.length();
        for (int i = 0; i < tmpSize; i++){
            if (tmpNum.charAt(tmpSize - i - 1) - '0' + flag >= 10) {
                Integer num = tmpNum.charAt(tmpSize - i - 1) - '0' + flag - 10;
                res += num.toString();
                flag = 1;
            }else {
                Integer num = tmpNum.charAt(tmpSize - i - 1) - '0' + flag;
                res += num.toString();
                flag = 0;
            }
        }
        if (flag == 1) {
            res += flag.toString();
        }
        return new StringBuffer(res).reverse().toString();
    }

    //官网解法，相当于对以上解法进行优化，用两个指针分别指向两个数字末尾，然后递减(从个位开始加起)，约定下标小于零时返回0，设置进位标志，记得这里有最高位进位的特殊情况。
    public String addStrings2(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }

}
