import java.util.LinkedList;
import java.util.Queue;

public class leetcode_101 {
    /**
     * 题目：对称二叉树
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && check(left.right, right.left) && check(left.left,right.right);
    }

    //其实和判断二叉树相等的原理类似，将根节点去掉，左右子树进行比较，判断是否对称即可，即两树根节点相同且树1的左子树应对应树2的右子树
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        return check(root.left,root.right);
    }

    //使用迭代来解决，同样借助两个队列,不看根节点，将左右子树的遍历顺序搞成相对的(左对右，右对左),其实就是两树相等的问题
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        queue1.offer(root.left);
        queue2.offer(root.right);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) return false;
            TreeNode left1 = node1.left, right1 = node1.right, left2 = node2.left, right2 = node2.right;
            if (left1 == null ^ right2 == null) return false;
            if (left2 == null ^ right1 == null) return false;
            if (left1 != null) queue1.offer(left1);
            if (right2 != null) queue2.offer(right2);
            if (left2 != null) queue2.offer(left2);
            if (right1 != null) queue1.offer(right1);
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
