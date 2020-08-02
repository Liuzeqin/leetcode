import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode_1 {
    /**
     * 题目：两数之和等于给定和
     * 解析：如果获取这两个值并优化查找的方法
     */

    //方法1：直接用暴力循环
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;

                }
            }
        }
        return result;
    }

    //方法2: 官方解法，使用k-v的方式来优化
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        int size = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < size; i++) {
            if (hashMap.containsKey(nums[i])){
                result[0] = i;
                result[1] = hashMap.get(nums[i]);
            }
            hashMap.put(target - nums[i], i);
        }
        return  result;
    }


}
