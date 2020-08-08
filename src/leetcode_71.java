import java.util.Deque;
import java.util.LinkedList;

public class leetcode_71 {
    /**
     * 题目：简化路径
     */

    //借助双向队列来存放真实目录的目录名
    public static String simplifyPath(String path) {
        String[] dirName = path.split("/");
        Deque<String> dirs = new LinkedList<>();
        for (String dir : dirName) {
            if (dir.equals( "..")) {
                if (!dirs.isEmpty()){
                    dirs.pop();
                }
            }else if (!dir.equals("") && !dir.equals(".")) {
                dirs.push(dir);
            }
        }
        if (dirs.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!dirs.isEmpty()) {
            sb.append("/" + dirs.pollLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "/a/./b/../../c/";
        System.out.println(simplifyPath(s));
    }
}
