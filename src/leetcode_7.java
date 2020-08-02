public class leetcode_7 {

    /**
     * 题目：整数反转
     */

    //和int转string有类似之处，即求出每一位数字，这里反转即为把得出的每一位乘以10的幂
    public int reverse(int x) {
        long num = 0;
        while (x != 0) {
            //从个位开始求
            num = num * 10 + x % 10;
            x = x / 10;
        }
        //题目给的其实就是int的取值范围
        return (int)num == num ? (int)num : 0;
    }
}
