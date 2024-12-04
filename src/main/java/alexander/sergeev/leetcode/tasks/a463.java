package alexander.sergeev.leetcode.tasks;

// 463. Island Perimeter
public class a463 {

    /*
    You are given row x col grid representing a map where grid[i][j] = 1 represents land
    and grid[i][j] = 0 represents water.
    Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
    and there is exactly one island (i.e., one or more connected land cells).
    The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
    One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
    Determine the perimeter of the island.
     */

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        System.out.println(islandPerimeter(grid));
    }


    // BEATS 54%
    public static int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (isNotValidCell(i - 1, j, m, n) || grid[i - 1][j] == 0) count++;
                    if (isNotValidCell(i + 1, j, m, n) || grid[i + 1][j] == 0) count++;
                    if (isNotValidCell(i, j - 1, m, n) || grid[i][j - 1] == 0) count++;
                    if (isNotValidCell(i, j + 1, m, n) || grid[i][j + 1] == 0) count++;
                }
            }
        }
        return count;
    }

    private static boolean isNotValidCell(int row, int col, int m, int n) {
        return row < 0 || row >= m || col < 0 || col >= n;
    }
}