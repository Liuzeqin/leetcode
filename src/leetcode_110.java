public class leetcode_110 {
    /**
     * 题目：平衡二叉树
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //使用自底向上的方法进行递归
    public class TreeInfo {
        boolean isBalanced;
        int height;

        public TreeInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public TreeInfo helper(TreeNode root) {
        if (root == null) return new TreeInfo(true,-1);
        TreeInfo left = helper(root.left);
        if (!left.isBalanced) return new TreeInfo(false, -1);
        TreeInfo right = helper(root.right);
        if (!right.isBalanced) return new TreeInfo(false, -1);

        if (Math.abs(left.height - right.height) < 2) {
            return new TreeInfo(true, Math.max(left.height, right.height) + 1);
        }else {
            return new TreeInfo(false, -1);
        }

    }

    public boolean isBalanced(TreeNode root) {
        TreeInfo info = helper(root);
        return info.isBalanced;
    }
}
