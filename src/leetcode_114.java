import sun.reflect.generics.tree.Tree;

import java.util.*;

public class leetcode_114 {
    /**
     * 题目: 二叉树展开为单链表
     * 解析: 目的其实就是二叉树的遍历方式，根据题干，记得要将所有左子树置为null
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

    //方法1：使用递归,先左后右，后序遍历
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten1(root.left);
        flatten1(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            //找到原左子树的最后一个子节点，然后再接上右子树
            root = root.right;
        }
        root.right = tmp;
        return;
    }

    //方法2：使用循环，借助栈结构，先处理左子树，再处理右子树，自下而上
    public void flatten2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (!stack.empty()) {
                TreeNode node = stack.pop();
                TreeNode tmp = node.right;
                node.right = node.left;
                node.left = null;
                while (node.right != null) {
                    node = node.right;
                }
                node.right = tmp;
                root = tmp;
            }
        }
        return;
    }

    //方法3：官方给出的解法，使用先序遍历并保存为List，再生成题目要求的链表
    public void flatten3(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        TreeNode node = root;
        while (node != null || stack != null) {
            while (node != null) {
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        int size = list.size();
        for (int i = 1; i < size - 1; i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode cur = list.get(i);
            prev.left = null;
            prev.right = cur;
        }
    }

    //方法4：只使用队列实现的先序遍历
    public void flatten4(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        if (node.right != null) {
            queue.push(node.right);
        }
        if (node.left != null) {
            queue.push(node.left);
        }
        while (!queue.isEmpty()) {
            TreeNode tmpNode = queue.pop();
            if (tmpNode.right != null) {
                queue.push(tmpNode.right);
            }
            if (tmpNode.left != null) {
                queue.push(tmpNode.left);
            }
            node.right = tmpNode;
            node.left = null;
            node = node.right;
        }
    }
}
