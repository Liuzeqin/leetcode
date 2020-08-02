public class leetcode_14 {
    /**
     * 题目：最长公共前缀
     * 解析：使用分治算法应该是比较好的
     */

    //参考官网做法，分治法
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefix(String[] strs, Integer left, Integer right) {
        if (left == right) {
            return strs[left];
        }
        Integer mid = (left + right)/2;
        String commonPrefixLeft = longestCommonPrefix(strs, left, mid);
        String commonPrefixRight = longestCommonPrefix(strs, mid + 1, right);
        return commonPrefix(commonPrefixLeft, commonPrefixRight);
    }

    public String commonPrefix(String str1, String str2) {
        Integer len = Math.min(str1.length(), str2.length());
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }
        return str1.substring(0, len);
    }

}
