package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 2639. Find the Width of Columns of a Grid
public class a2639 {

    /*
    You are given a 0-indexed m x n integer matrix grid. The width of a column is the maximum length of its integers.
    For example, if grid = [[-10], [3], [12]], the width of the only column is 3 since -10 is of length 3.
    Return an integer array ans of size n where ans[i] is the width of the ith column.
    The length of an integer x with len digits is equal to len if x is non-negative, and len + 1 otherwise.
     */

    public static void main(String[] args) {
        int[][] mat = {
                {-15, 1, 3},
                {15, 7, 12},
                {5, 6, -2}};
        System.out.println(Arrays.toString(findColumnWidth(mat))); // [3,1,2]
    }

    // BEATS 99%
    public static int[] findColumnWidth(int[][] grid) {
        int[] result = new int[grid[0].length];
        for(int j = 0; j < grid[0].length; j++) {
            int max = grid[0][j];
            int min = grid[0][j];
            for(int i = 1; i < grid.length; i++) {
                int x = grid[i][j];
                if (x > max)
                    max = x;
                if (x < min)
                    min = x;
            }
            result[j] = Math.max(getLength(max), getLength(min));
        }
        return result;
    }

    public static int getLength(int num) {
        int count = 1;
        if (num > 9) count = (int) Math.log10(num) + 1;
        if (num < 0) count = (int) Math.log10(num * -1) + 2;
        return count;
    }

    // BEATS 83%
    public static int[] findColumnWidth2(int[][] grid) {
        int[] result = new int[grid[0].length];
        for (int[] row : grid) {
            for (int j = 0; j < row.length; j++) {
                int count = 1;
                if (row[j] > 9) count = (int) Math.log10(row[j]) + 1;
                if (row[j] < 0) count = (int) Math.log10(row[j] * -1) + 2;
                result[j] = Math.max(result[j], count);
            }
        }
        return result;
    }

    // BEATS 56%
    public static int[] findColumnWidth1(int[][] grid) {
        int[] result = new int[grid[0].length];
        for (int[] row : grid) {
            for (int j = 0; j < row.length; j++) {
                result[j] = Math.max(result[j], String.valueOf(row[j]).length());
            }
        }
        return result;
    }
}