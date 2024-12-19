package alexander.sergeev.leetcode.tasks;

// 2579. Count Total Number of Colored Cells
public class a2579 {

    /*
    There exists an infinitely large two-dimensional grid of uncolored unit cells.
    You are given a positive integer n, indicating that you must do the following routine for n minutes:
    At the first minute, color any arbitrary unit cell blue.
    Every minute thereafter, color blue every uncolored cell that touches a blue cell.
    Below is a pictorial representation of the state of the grid after minutes 1, 2, and 3.
     */

    public static void main(String[] args) {
        int n = 3;
        System.out.println(coloredCells(n));
    }

    // BEATS 100%
    public static long coloredCells(int n) {
        return 1L + 4L * (n - 1L) + 2L * (n - 1L) * (n - 2L);
    }

    // BEATS 53%
    public static long coloredCells1(int n) {
        if (n == 1) return 1;
        long count = 1L;
        for (int i = 2; i <= n; i++) {
            count += 4L * (i - 1);
        }
        return count;
    }
}