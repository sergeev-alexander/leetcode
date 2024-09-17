package alexander.sergeev.leetcode.tasks;

// 101. Symmetric Tree
public class a101 {

    /*
    Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
     */

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3, null, null),
                        new TreeNode(4, null, null)),
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        new TreeNode(3, null, null)));

        System.out.println(isSymmetric(root));

    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return ((t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right));
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
    }
}
