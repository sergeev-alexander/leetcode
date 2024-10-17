package alexander.sergeev.leetcode.tasks;

// 2849. Determine if a Cell Is Reachable at a Given Time
public class a2849 {

    /*
    You are given four integers sx, sy, fx, fy, and a non-negative integer t.
    In an infinite 2D grid, you start at the cell (sx, sy). Each second, you must move to any of its adjacent cells.
    Return true if you can reach cell (fx, fy) after exactly t seconds, or false otherwise.
    A cell's adjacent cells are the 8 cells around it that share at least one corner with it.
    You can visit the same cell several times.
     */

    public static void main(String[] args) {
        int sx = 1, sy = 1, fx = 2, fy = 1, t = 2;
        System.out.println(isReachableAtTime(sx, sy, fx, fy, t));
    }

    public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy) {
            return t != 1;
        }
        return t >= Math.max(Math.abs(sx - fx), Math.abs(sy - fy));
    }
}