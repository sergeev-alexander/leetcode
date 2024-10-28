package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 2523. Closest Prime Numbers in Range
public class a2523 {

    /*
    Given two positive integers left and right, find the two integers num1 and num2 such that:
    left <= num1 < num2 <= right .
    num1 and num2 are both prime numbers.
    num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
    Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions,
    return the one with the minimum num1 value or [-1, -1] if such numbers do not exist.
    A number greater than 1 is called prime if it is only divisible by 1 and itself.
     */

    public static void main(String[] args) {
        int a = 10;
        int b = 19;
        System.out.println(Arrays.toString(closestPrimes(a, b)));
    }

    // BEATS 35%
    public static int[] closestPrimes(int left, int right) {
        int minDiff = 1_000_000;
        int nextPrime = -1;
        int[] result = new int[]{-1, -1};
        for (int i = right; i >= left; i--) {
            if (isPrime(i)) {
                if (nextPrime != -1) {
                    if (minDiff >= nextPrime - i) {
                        minDiff = nextPrime - i;
                        result[0] = i;
                        result[1] = nextPrime;
                    }
                }
                nextPrime = i;
            }
        }
        return result;
    }

    private static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        if (num == 2 || num == 3)
            return true;
        if (num % 2 == 0 || num % 3 == 0)
            return false;
        for (int i = 5; i <= Math.sqrt(num); i += 6)
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        return true;
    }
}