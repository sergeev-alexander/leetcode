package alexander.sergeev.leetcode.tasks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 145. Binary Tree Postorder Traversal
public class a145 {

    public static void main(String[] args) {

        /*
        Given the root of a binary tree, return the postorder traversal of its nodes' values.
         */

        TreeNode head = new TreeNode(1, null,
                new TreeNode(2, null,
                        new TreeNode(3, null, null)));

        System.out.println(postorderTraversal(head));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) return list;
        deque.push(root);
        while (!deque.isEmpty()) {
            root = deque.pop();
            list.addFirst(root.val);
            if (root.left != null) deque.push(root.left);
            if (root.right != null) deque.push(root.right);
        }
        return list;
    }

    static class TreeNode {
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

        @Override
        public String toString() {
            return "Value: " + val + " right: " + right + " left: " + left;
        }
    }
}
