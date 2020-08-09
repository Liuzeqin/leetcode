import java.util.ArrayList;
import java.util.List;

public class leetcode_118 {
    /**
     * 题目：构建杨辉三角
     */

    //直接根据规律进行构建
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> nums = new ArrayList<>();
        if (numRows <= 0) return nums;
        nums.add(new ArrayList<>());
        nums.get(0).add(1);//杨辉三角第一行
        for (int num = 1; num < numRows; num++) {
            List<Integer> row = new ArrayList();
            List<Integer> lastRow = nums.get(num - 1);
            row.add(1);
            for (int i = 1; i < num; i++) {
                row.add(lastRow.get(i - 1) + lastRow.get(i));
            }
            row.add(1);
            nums.add(row);
        }
        return nums;
    }
}
