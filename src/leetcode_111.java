import java.util.LinkedList;
import java.util.Queue;

public class leetcode_111 {
    /**
     * 题目：二叉树最小深度
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    使用层次遍历的方法，找到第一个叶子结点，返回层数
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> tree = new LinkedList<>();
        tree.offer(root);
        int depth = 0;
        boolean flag = false;
        while (!tree.isEmpty() && !flag) {
            depth++;
            int size = tree.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = tree.poll();
                if (node.left == null && node.right == null) {
                    flag = true;
                    break;
                }
                if (node.left != null) {
                    tree.offer(node.left);
                }
                if (node.right != null) {
                    tree.offer(node.right);
                }
            }
        }
        return depth;
    }

}
