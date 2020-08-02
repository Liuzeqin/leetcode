import java.util.HashMap;

public class leetcode_13 {

    /**
     * 题目：罗马数字转整数
     */

    //目前这种方法算是比较好的
    public static int romanToInt(String s) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('M', 1000);
        hashMap.put('D', 500);
        hashMap.put('C', 100);
        hashMap.put('L', 50);
        hashMap.put('X', 10);
        hashMap.put('V', 5);
        hashMap.put('I', 1);
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (hashMap.get(s.charAt(i)) < hashMap.get(s.charAt(i + 1))) {
                res -= hashMap.get(s.charAt(i));
            } else {
                res += hashMap.get(s.charAt(i));
            }
        }
        res += hashMap.get(s.charAt(s.length() - 1));

        return res;
    }

    public static void main(String[] args) {
        String s = "III";
        System.out.println(romanToInt(s));
    }

}
