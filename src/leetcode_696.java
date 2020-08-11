public class leetcode_696 {
    /**
     * 题目：计算二进制子串
     */

    //每对相邻的0和1，数量较小的值即为这对0,1可以组成的子字符串数量
    public static int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int sum = 0, last = 0, count = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                count++;
                continue;
            }
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            }else {
                if (last != 0) {
                    sum += Math.min(last,count);
                }
                last = count;
                count = 1;
            }
            if (len - 1 == i && last != 0){
                sum += Math.min(last,count);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110"));

    }
}
