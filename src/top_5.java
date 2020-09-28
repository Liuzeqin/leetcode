public class top_5 {
    /**
     * 题目：最长回文子串
     */
    public String longestPalindrome(String s) {
        int size = s.length();
        int[][] dp = new int[size][size];
        String ans = "";
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j + i < size; ++j) {
                int k = i + j;
                if (i == 0) {
                    dp[j][k] = 1;
                }else if (i == 1) {
                    dp[j][k] = s.charAt(j) == s.charAt(k) ? 1 : 0;
                }else {
                    dp[j][k] = (s.charAt(j) == s.charAt(k) && dp[j + 1][k - 1] == 1) ? 1 : 0;
                }
                if (dp[j][k] == 1 && i + 1 > ans.length()) {
                    ans = s.substring(j, k + 1);
                }
            }
        }

        return ans;
    }
}
