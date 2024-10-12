package alexander.sergeev.leetcode.tasks;

// 3232. Find if Digit Game Can Be Won
public class a3232 {

    /*
    You are given an array of positive integers nums.
    Alice and Bob are playing a game. In the game, Alice can choose either all single-digit numbers
    or all double-digit numbers from nums, and the rest of the numbers are given to Bob.
    Alice wins if the sum of her numbers is strictly greater than the sum of Bob's numbers.
    Return true if Alice can win this game, otherwise, return false.
     */

    public static void main(String[] args) {

        int[] arr = {2, 1, 2, 3, 4, 10};

        System.out.println(canAliceWin(arr));
    }

    public static boolean canAliceWin(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if (num / 10 > 0) a += num;
            else b += num;
        }
        return a > b || b > a;
    }
}
