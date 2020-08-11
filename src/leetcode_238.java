public class leetcode_238 {
    /**
     * 题目：除自身以外数组的乘积
     */
    //思路：不能使用除法，而且时间复杂度有要求，所以不能暴力解决，这里借鉴官网的做法，使用左边乘积与右边乘积相乘，得到当前的乘积
    //提前做两次遍历，保存两个乘积数组，查询时为O(1)复杂度,注意边界条件的判断
    //优化空间复杂度的方法为在原有left数组上做反序遍历，用一个变量依次保存右边乘积的值，与对应位置的左边乘积相乘后直接得出结果
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] ans = new int[len];
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[len - 1] = 1;
        for (int j = len - 2; j >= 0; j--) {
            right[j] = right[j + 1] * nums[j + 1];
        }
        for (int k = 0; k < len; k++) {
            ans[k] = left[k] * right[k];
        }
        return ans;
    }
}
