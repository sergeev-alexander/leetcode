package alexander.sergeev.leetcode.tasks;

// 74. Search a 2D Matrix
public class a74 {

    /*
    You are given an m x n integer matrix with the following two properties:
    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.
    Given an integer target, return true if target is in matrix or false otherwise.
    You must write a solution in O(log(m * n)) time complexity.
     */

    public static void main(String[] args) {

        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;

        System.out.println(searchMatrix(matrix, target));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            int firstRowNum = ints[0];
            int lastRowNum = ints[ints.length - 1];
            if (firstRowNum <= target && lastRowNum >= target) {
                if (firstRowNum == target) return true;
                if (lastRowNum == target) return true;
                for (int j = 1, k = ints.length - 2; j <= k; j++, k--) {
                    if (ints[j] == target || ints[k] == target) return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrixOTHER(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) return true;
            else {
                if (target < pivotElement) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }
}
