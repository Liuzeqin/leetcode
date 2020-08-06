public class leetcode_66 {
    /**
     * 题目：加一
     */

    //主要考虑的是进位的问题,即所在位为9的情况
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[len + 1];//说明遇到了99、999之类的特殊情况
        digits[0] = 1;
        return digits;
    }
}
