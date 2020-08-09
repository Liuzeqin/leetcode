import java.util.*;

public class leetcode_107 {
    /**
     * 题目：层次遍历
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //简单题，直接看代码吧
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> tree = new ArrayList<>();
        if (root == null) return tree;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //每次遍历会把下一层的所有节点放进去
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            //使用前插则可以直接得到答案
            tree.add(0, tmp);
        }
        return tree;

    }
}
