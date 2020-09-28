public class leetcode_125 {
    /**
     * 题目：验证回文串,只考虑数字和字母
     */
    public boolean isPalindrome(String s) {
        if (s == null) return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }else {
                    left++;
                    right--;
                }
            }
        }
        return true;
    }
}