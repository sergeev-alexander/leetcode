package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 2022. Convert 1D Array Into 2D Array
public class a2022 {

    /*
    You are given a 0-indexed 1-dimensional (1D) integer array original, and two integers, m and n.
    You are tasked with creating a 2-dimensional (2D) array with  m rows and n columns using all the elements from original.
    The elements from indices 0 to n - 1 (inclusive) of original should form the first row of the constructed 2D array,
    the elements from indices n to 2 * n - 1 (inclusive) should form the second row of the constructed 2D array, and so on.
    Return an m x n 2D array constructed according to the above procedure, or an empty 2D array if it is impossible.
     */

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int m = 2;
        int n = 2;
        int[][] result = construct2DArray(arr, m, n);
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }
    }

    // BEATS 97%
    public static int[][] construct2DArray1(int[] original, int m, int n) {
        if (m * n != original.length) return new int[0][0];
        int[][] arr = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = original[count++];
            }
        }
        return arr;
    }

    // BEATS 64%
    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) return new int[0][];
        int[][] arr = new int[m][n];
        for (int i = 0, j = 0, k = n; i < m; i++, j += n, k += n) {
            arr[i] = Arrays.copyOfRange(original, j, k);
        }
        return arr;
    }
}