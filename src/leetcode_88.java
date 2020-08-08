public class leetcode_88 {
    /**
     * 题目：合并两个有序数组
     */

    //使用效率最高且不需要额外空间的解法,从后往前遍历
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while(p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        //假如上面循环的退出条件是p1<0的话，通过下面的语句把nums2剩下的元素复制到nums1
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

    }
}
