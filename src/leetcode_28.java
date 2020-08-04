public class leetcode_28 {
    /**
     * 题目：实现strStr();
     */

    //使用kmp算法，没什么可解析的，经典题目，这里要注意的是部分匹配时应当回退到原匹配起点的下一个字符重新比较，因为已比较的部分可能有重复字符
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int size_h = haystack.length();
        int size_n = needle.length();
        int n_ptr = 0;
        for (int i = 0; i < size_h;) {
            if (haystack.charAt(i) == needle.charAt(n_ptr)) {
                if (n_ptr == size_n - 1 && n_ptr <= i) {
                    return i - n_ptr;
                }else {
                    ++i;
                    ++n_ptr;
                }
            }else{
                i = i - n_ptr + 1;
                n_ptr = 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String h = "mississippi";
        String n = "issip";
        System.out.println(strStr(h, n));
    }
}
