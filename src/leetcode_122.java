public class leetcode_122 {
    /**
     * 题目：多次买卖股票的最大利润
     */

    //通过图解可知相邻的每段峰谷差之和即为最大利润
    public int maxProfit(int[] prices) {
        int maxProfile = 0;
        int valley = 0;
        int peak = 0;
        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxProfile += peak - valley;
        }
        return maxProfile;
    }
}
