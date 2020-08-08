import java.util.LinkedList;
import java.util.Queue;

public class leetcode_104 {
    /**
     * 题目：求二叉树最大深度
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //递归太恶心，感觉没什么思想可言
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    //来个层次遍历吧
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //每次遍历会把下一层的所有节点放进去
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return count;
    }
}
