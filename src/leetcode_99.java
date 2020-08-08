import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class leetcode_99 {
    /**
     * 题目：恢复二叉搜索树
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //方法：二叉搜索树的特性是中序遍历为递增数组，根据这个特性找出数组中不符合升序要求的两个数即可，注意这两个数是否相邻要分两种情况考虑
    //找出调换位置的两个数后，在遍历二叉树进行恢复
    public void recoverTree(TreeNode root) {
        List<Integer> orders = new ArrayList<>();
        inorders(root, orders);
        int[] swap = findTwoNumSwap(orders);
        recovery(root, 2, swap[0], swap[1]);
    }

    public void inorders (TreeNode root, List<Integer> orders){
        if (root == null) return;
        inorders(root.left, orders);
        orders.add(root.val);
        inorders(root.right, orders);
    }

    public int[] findTwoNumSwap(List<Integer> orders) {
        int x = -1, y = -1;
        int size = orders.size();
        for (int i = 0; i < size - 1; i++) {
            if (orders.get(i + 1) < orders.get(i)) {
                y = orders.get(i + 1);
                if (x == -1) {
                    x = orders.get(i);
                }else {
                    break;
                }
            }
        }
        return new int[]{x,y};
    }

    public void recovery(TreeNode root, int count, int x, int y) {
        if (root != null){
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recovery(root.left, count, x, y);
            recovery(root.right, count, x, y);
        }
    }
}
