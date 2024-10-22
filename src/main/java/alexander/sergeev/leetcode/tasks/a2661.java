package alexander.sergeev.leetcode.tasks;

import java.util.HashMap;
import java.util.Map;

// 2661. First Completely Painted Row or Column
public class a2661 {

    /*
    You are given a 0-indexed integer array arr, and an m x n integer matrix mat.
    arr and mat both contain all the integers in the range [1, m * n].
    Go through each index i in arr starting from index 0 and paint the cell in mat containing the integer arr[i].
    Return the smallest index i at which either a row or a column will be completely painted in mat.
     */

    public static void main(String[] args) {
        int[][] mat = {
                {3, 2, 5},
                {1, 4, 6},
                {8, 7, 9}};
        int[] arr = {2, 8, 7, 4, 1, 3, 5, 6, 9};
        System.out.println(firstCompleteIndex(arr, mat)); // 3
    }

    // BEATS 98%
    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        final int m = mat.length;
        final int n = mat[0].length;
        int[] numToRow = new int[m * n + 1];
        int[] numToCol = new int[m * n + 1];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                numToRow[mat[i][j]] = i;
                numToCol[mat[i][j]] = j;
            }
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < arr.length; i++) {
            if (++row[numToRow[arr[i]]] == n || ++col[numToCol[arr[i]]] == m) {
                return i;
            }
        }
        return 0;
    }

    // BEATS 49%
    public static int firstCompleteIndex2(int[] arr, int[][] mat) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        for (int i = 0; i < arr.length; i++) {
            if (++row[map.get(arr[i])[0]] == mat[0].length || ++col[map.get(arr[i])[1]] == mat.length) {
                return i;
            }
        }
        return 0;
    }

    // TLE
    public static int firstCompleteIndex1(int[] arr, int[][] mat) {
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                for (int k = 0; k < mat[j].length; k++) {
                    if (mat[j][k] == arr[i]) {
                        row.merge(j, 1, (o, n) -> o + 1);
                        col.merge(k, 1, (o, n) -> o + 1);
                        if (row.get(j) == mat[j].length || col.get(k) == mat.length) {
                            return i;
                        }
                    }
                }
            }
        }
        return 0;
    }
}