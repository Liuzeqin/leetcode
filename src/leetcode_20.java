import java.util.HashMap;
import java.util.Stack;

public class leetcode_20 {
    /**
     * 题目：求闭合括号对
     */

    public static boolean isValid(String s) {
       if (s == "") return true;
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');
        Integer len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (stack.empty()) {
                    return false;
                }
                Character c = stack.pop();
                if (c != hashMap.get(s.charAt(i))) {
                    return false;
                }
            }
        }
        if (stack.empty()) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }
}
