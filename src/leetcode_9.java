import java.util.ArrayList;
import java.util.List;

public class leetcode_9 {

    /**
     * 题目：回文数
     */

    //方法1：保存每位数字到数组中，然后用双向指针比较
    public boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> num = new ArrayList<>();
        int[] res = new int[32];
        while (x > 0) {
            num.add(x % 10);
            x = x / 10;
        }
        int left = 0;
        int right = num.size() - 1;
        while (left < right) {
            if (num.get(left) != num.get(right)) {
                return false;
            }
            right--;
            left++;
        }
        return true;
    }

    //方法2：在翻转数字的基础上进行等值判断
    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int num = 0;
        int tmp = x;
        while (x > 0) {
            //从个位开始求
            num = num * 10 + x % 10;
            x = x / 10;
        }
        return num == tmp;
    }

    //方法3：官方解法，多了个位为0的特殊情况，以及翻转一般然后进行比较
    public boolean isPalindrome3(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;

    }

}
