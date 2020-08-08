public class leetcoode_67 {
    /**
     * 题目：二进制求和
     */

    public static String addBinary(String a, String b) {
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        while(lenA >= 0 || lenB >= 0) {
            int tmpA = lenA >= 0 ? a.charAt(lenA) - '0' : 0;
            int tmpB = lenB >= 0 ? b.charAt(lenB) - '0' : 0;
            int tmp = tmpA + tmpB + flag;
            if (tmp >= 2) {
                flag = 1;
                sb.append(tmp - 2);
            }else {
                flag = 0;
                sb.append(tmp);
            }
            lenA--;
            lenB--;
        }
        if (flag == 1) sb.append(flag);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "11";
        String str2 = "1";
        System.out.println(addBinary(str1,str2));
    }
}
