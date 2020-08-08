public class leetcode_70 {
    /**
     * 题目：爬楼梯
     */

    //用递归的话可以解答，但是会超时，这里推荐官方的斐波那契数列解法
    public int climbStairs(int n) {
        int Fn1 = 1;
        int Fn2 = 2;
        if (n == 1) return Fn1;
        if (n == 2) return Fn2;
        int result = 0;
        for (int i = 3; i <= n; i++){
            result = Fn1 + Fn2;
            Fn1 = Fn2;
            Fn2 = result;
        }
        return result;
    }
}
