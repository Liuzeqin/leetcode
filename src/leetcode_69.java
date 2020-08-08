public class leetcode_69 {
    /**
     * 题目：求平方根
     */
    //使用二分查找，快速找出平方小于等于给定值的最大数
    public int mySqrt(int x) {
        int l = 0, r = x, ans = 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((long)mid * mid <= x){
                ans = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return ans;
    }
}
