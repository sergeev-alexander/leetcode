package alexander.sergeev.leetcode.tasks;

// 2596. Check Knight Tour Configuration
public class a2596 {

    /*
    There is a knight on an n x n chessboard. In a valid configuration,
    the knight starts at the top-left cell of the board and visits every cell on the board exactly once.
    You are given an n x n integer matrix grid consisting of distinct integers
    from the range [0, n * n - 1] where grid[row][col] indicates that the cell (row, col)
    is the grid[row][col]th cell that the knight visited. The moves are 0-indexed.
    Return true if grid represents a valid configuration of the knight's movements or false otherwise.
     */

    public static void main(String[] args) {
        int[][] grid = {
                {0, 11, 16, 5, 20},
                {17, 4, 19, 10, 15},
                {12, 1, 8, 21, 6},
                {3, 18, 23, 14, 9},
                {24, 13, 2, 7, 22}};
        System.out.println(checkValidGrid(grid));
    }

    // BEATS 95%
    public static boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;
        int[] iDir = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] jDir = {-2, -1, 1, 2, 2, 1, -1, -2};
        int size = grid.length;
        int i = 0;
        int j = 0;
        for (int moveCount = 1; moveCount < size * size; moveCount++) {
            boolean ok = false;
            for (int d = 0; d < 8; d++) {
                int tempI = i + iDir[d];
                int tempJ = j + jDir[d];
                if (isValid(tempI, size) && isValid(tempJ, size) && grid[tempI][tempJ] == moveCount) {
                    ok = true;
                    i = tempI;
                    j = tempJ;
                    break;
                }
            }
            if (!ok) return false;
        }
        return true;
    }

    public static boolean isValid(int pos, int size) {
        return pos >= 0 && pos < size;
    }
}