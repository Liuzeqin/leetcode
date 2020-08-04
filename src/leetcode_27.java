public class leetcode_27 {
    /**
     * 题目：移除元素
     */

    public static int removeElement(int[] nums, int val) {
        int size = nums.length;
        if (size == 0) return 0;
        int pre = 0;
        for (int i = 0; i < size; ++i) {
            if (nums[i] != val) {
                nums[pre] = nums[i];
                ++pre;
            }
        }
        return pre;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums,2));
    }
}
