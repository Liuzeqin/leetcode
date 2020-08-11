import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class leetcode_49 {
    /**
     * 题目：字母异位词分组
     */
    //个人觉得这是比较好的解法，即异位词的排序字符串相同
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        if (len == 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            //转换为排序字符串
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);

        }
        return new ArrayList<>(map.values());
    }
}
