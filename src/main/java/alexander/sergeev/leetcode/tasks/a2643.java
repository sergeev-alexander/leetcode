package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 2643. Row With Maximum Ones
public class a2643 {

    /*
    Given a m x n binary matrix mat, find the 0-indexed position of the row that contains the maximum count of ones,
    and the number of ones in that row.
    In case there are multiple rows that have the maximum count of ones, the row with the smallest row number should be selected.
    Return an array containing the index of the row, and the number of ones in it.
     */

    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 1},
                {1, 0, 1}};
        System.out.println(Arrays.toString(rowAndMaximumOnes(mat)));
    }

    // BEATS 100%
    public static int[] rowAndMaximumOnes(int[][] mat) {
        int[] result = new int[2];
        for (int i= 0; i < mat.length; i++) {
            int sum = 0;
            for (int num : mat[i]) {
                sum += num;
            }
            if (sum > result[1]) {
                result[1] = sum;
                result[0] = i;
            }
            if (sum == result[1]) {
                result[0] = Math.min(result[0], i);
            }
        }
        return result;
    }
}