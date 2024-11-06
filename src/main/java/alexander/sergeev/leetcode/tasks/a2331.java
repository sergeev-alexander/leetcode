package alexander.sergeev.leetcode.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

// 2331. Evaluate Boolean Binary Tree
public class a2331 {

    /*
    You are given the root of a full binary tree with the following properties:
    Leaf nodes have either the value 0 or 1, where 0 represents False and 1 represents True.
    Non-leaf nodes have either the value 2 or 3, where 2 represents the boolean OR and 3 represents the boolean AND.
    The evaluation of a node is as follows:
    If the node is a leaf node, the evaluation is the value of the node, i.e. True or False.
    Otherwise, evaluate the node's two children and apply the boolean operation of its value with the children's evaluations.
    Return the boolean result of evaluating the root node.
    A full binary tree is a binary tree where each node has either 0 or 2 children.
    A leaf node is a node that has zero children.
     */

    static TreeNode root =
            new TreeNode(2,
                    new TreeNode(1),
                    new TreeNode(3,
                            new TreeNode(0),
                            new TreeNode(1)));

    public static void main(String[] args) {
        System.out.println(evaluateTree(root));
    }

    public static boolean evaluateTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (root.val > 1) {
            if (queue.peek() == null) {
                queue.remove();
                continue;
            }
            TreeNode node = queue.poll();
            Integer first = null;
            Integer second = null;
            if (node.left != null && node.left.val <= 1) {
                first = node.left.val;
            } else if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null && node.right.val <= 1) {
                second = node.right.val;
            } else if (node.right != null) {
                queue.add(node.right);
            }
            if (first != null && second != null) {
                if (node.val == 3) {
                    node.val = first == 1 && second == 1 ? 1 : 0;
                } else if (node.val == 2) {
                    node.val = !first.equals(second) ? 1
                            : first == 1 ? 1 : 0;
                }
                node.left = null;
                node.right = null;
                queue.add(node);
                queue.add(root);
            }
        }
        return root.val == 1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
}