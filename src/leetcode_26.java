public class leetcode_26 {
    /**
     * 题目：删除排序数组的重复元素
     */

    //实现的方法大同小异，用官方的双指针法吧,解题的思路是如何只保留第一个重复元素，对下标进行调整
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int tmp = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]){
                tmp++;
                nums[tmp] = nums[i];
            }
        }
        return tmp + 1;
    }
}
