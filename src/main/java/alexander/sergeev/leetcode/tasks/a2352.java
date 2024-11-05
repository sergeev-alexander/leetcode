package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 2352. Equal Row and Column Pairs
public class a2352 {

    /*
    Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
    A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
     */

    public static void main(String[] args) {
        int[][] grid = {
                {3, 1, 2, 2},
                {1, 4, 4, 5},
                {2, 4, 2, 2},
                {2, 4, 2, 2}};
        System.out.println(equalPairs(grid));
    }

    // BEATS 97%
    public static int equalPairs(int[][] grid) {
        int[][] arr = new int[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                arr[j][i] = grid[i][j];
            }
        }
        int count = 0;
        for (int[] a1 : grid) {
            for (int[] a2 : arr) {
                if (Arrays.equals(a1, a2)) {
                    count++;
                }
            }
        }
        return count;
    }
}