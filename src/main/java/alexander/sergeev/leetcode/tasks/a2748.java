package alexander.sergeev.leetcode.tasks;

// 2748. Number of Beautiful Pairs
public class a2748 {

    /*
    You are given a 0-indexed integer array nums. A pair of indices i, j where 0 <= i < j < nums.length
    is called beautiful if the first digit of nums[i] and the last digit of nums[j] are coprime.
    Return the total number of beautiful pairs in nums.
    Two integers x and y are coprime if there is no integer greater than 1 that divides both of them.
    In other words, x and y are coprime if gcd(x, y) == 1, where gcd(x, y) is the greatest common divisor of x and y.
     */

    public static void main(String[] args) {
        int[] arr = {31,25,72,79,74};
        System.out.println(countBeautifulPairs(arr));
    }

    // BEATS 77%
    public static int countBeautifulPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int first = (int) (nums[i] / Math.pow(10, (int) (Math.log10(nums[i]))));
            for (int j = i + 1; j < nums.length; j++) {
                int second = nums[j] % 10;
                if (getGcd(first, second) == 1) count++;
            }
        }
        return count;
    }

    private static int getGcd(int a, int b) {
        while (true) {
            if (a == 0) return b;
            if (b == 0) return a;
            if (a >= b) {
                a %= b;
            } else {
                b %= a;
            }
        }
    }
}