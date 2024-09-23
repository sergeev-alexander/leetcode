package alexander.sergeev.leetcode.tasks;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 144. Binary Tree Preorder Traversal
public class a144 {

    /*
    Given the root of a binary tree, return the preorder traversal of its nodes' values.
     */

    public static void main(String[] args) {

        TreeNode head = new TreeNode(1, null,
                new TreeNode(2, null,
                        new TreeNode(3, null, null)));

        System.out.println(preorderTraversal(head));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pollLast();
            if (root.right != null) {
                stack.add(root.right);
            }
            if (root.left != null) {
                stack.add(root.left);
            }
            list.add(root.val);
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
