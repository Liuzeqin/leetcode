public class leetcode_53 {
    /**
     * 题目：最大(连续）子序和
     */

    //d动态规划的思想，看代码理解吧，不赘述
    public int maxSubArray(int[] nums) {
        int size = nums.length;
        //当前最大子序和
        int curMaxSum = nums[0];
        //最大子序和
        int maxSum = nums[0];
        for (int i = 0; i < size; i++) {
            curMaxSum = Math.max(nums[i], curMaxSum + nums[0]);
            maxSum = Math.max(maxSum, curMaxSum);
        }
        return maxSum;
    }
}
