package alexander.sergeev.leetcode.tasks;

// 70. Climbing Stairs
public class a70 {

    /*
    You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     */

    public static void main(String[] args) {

        int n = 3;

        System.out.println(climbStairs(n)); // 3
    }

    public static int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev = 1;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr += prev;
            prev = temp;
        }
        return curr;
    }
}

