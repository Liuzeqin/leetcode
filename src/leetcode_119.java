import java.util.ArrayList;
import java.util.List;

public class leetcode_119 {
    /**
     * 题目：返回杨辉三角第k行
     */

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);//第0行
        if (rowIndex == 0) return nums;
        for (int num = 1; num <= rowIndex; num++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int i = 1; i < num; i++) {
                row.add(nums.get(i - 1) + nums.get(i));
            }
            row.add(1);
            nums = row;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));

    }
}
