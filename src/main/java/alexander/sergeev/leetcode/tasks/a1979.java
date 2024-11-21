package alexander.sergeev.leetcode.tasks;

// 1979. Find Greatest Common Divisor of Array
public class a1979 {

    /*
    Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.
    The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
     */

    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 9, 10};
        System.out.println(findGCD(arr));
    }

    // BEATS 100%
    public static int findGCD(int[] nums) {
        int max = 1;
        int min = 1000;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int a = min;
        int b = max;
        int gcd = 1;
        while (true) {
            if (a == 0) {
                gcd = b;
                break;
            }
            if (b == 0) {
                gcd = a;
                break;
            }
            if (a >= b) a %= b;
            else b %= a;
        }
        return gcd;
    }
}