public class leetcode_58 {
    /**
     * 题目：最后一个单词长度
     */
    public int lengthOfLastWord1(String s) {
        s = s.replaceAll("\\s+", " ");
        if (s.equals(" ") || s == "") return 0;
        String[] array = s.split(" ");
        return array[array.length - 1].length();
    }

    //推荐一种效率比较高的算法
    public int lengthOfLastWord2(String s) {
        int end = s.length() - 1;
        //去除最后一个单词后面的空格，找到单词尾部
        while (end >= 0 && s.charAt(end) == ' ') --end;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') --start;
        return end - start;
    }

}
