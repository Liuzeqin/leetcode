public class leetcode_121 {
    /**
     * 题目：买卖股票的最佳时机
     */

    //每天记录今天之前买入的最低价格，与当天股票价格求差，动态调整最大利润
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 0) return 0;
        int minPrice = prices[0];
        int maxPrice = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }else if (prices[i] - minPrice > maxPrice) {
                maxPrice = prices[i] - minPrice;
            }
        }
        return maxPrice;
    }
}
