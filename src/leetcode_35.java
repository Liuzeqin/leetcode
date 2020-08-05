public class leetcode_35 {
    /**
     * 题目：搜索插入位置
     */

    //这个题目主要是查找的优化吧
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right + left) >> 1);
            if (target <= nums[mid]) {
                ans = mid;
                //数字可能不存在与数组中，所以每次比较后要排除掉mid，避免造成死循环
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums,5));
        System.out.println(searchInsert(nums,2));
    }
}
