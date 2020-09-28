import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class leetcode_94 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !nodeStack.isEmpty()) {
            while (tmp != null) {
                //遍历到最左边的节点
                nodeStack.push(tmp);
                tmp = tmp.left;
            }
            TreeNode top = nodeStack.pop();
            ans.add(top.val);
            tmp = top.right;
        }
        return ans;
    }
}
