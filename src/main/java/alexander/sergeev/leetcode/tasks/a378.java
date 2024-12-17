package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 378. Kth Smallest Element in a Sorted Matrix
public class a378 {

    /*
    Given an n x n matrix where each of the rows and columns is sorted in ascending order,
    return the kth smallest element in the matrix.
    Note that it is the kth smallest element in the sorted order, not the kth distinct element.
    You must find a solution with a memory complexity better than O(n2).
     */

    public static void main(String[] args) {
        int[][] grid = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}};
        int k = 8;
        System.out.println(kthSmallest(grid, k));
    }

    // BEATS 61%
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] arr = new int[n * n];
        int count = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                arr[count++] = num;
            }
        }
        Arrays.sort(arr);
        return arr[--k];
    }
}