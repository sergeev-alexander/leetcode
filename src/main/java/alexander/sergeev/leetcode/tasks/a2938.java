package alexander.sergeev.leetcode.tasks;

// 2938. Separate Black and White Balls
public class a2938 {

    /*
    There are n balls on a table, each ball has a color black or white.
    You are given a 0-indexed binary string s of length n, where 1 and 0 represent black and white balls, respectively.
    In each step, you can choose two adjacent balls and swap them.
    Return the minimum number of steps to group all the black balls to the right and all the white balls to the left.
     */

    public static void main(String[] args) {

        String s = "010011";
        System.out.println(minimumSteps(s));
    }

    // BEATS 45%
    public static long minimumSteps(String s) {
        long minSteps = 0;
        int whiteBallIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                minSteps += (i - whiteBallIndex);
                whiteBallIndex++;
            }
        }
        return minSteps;
    }
}
