package alexander.sergeev.leetcode.tasks;

// 507. Perfect Number
public class a507 {

    /*
    A perfect number is a positive integer that is equal to the sum of its positive divisors,
    excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.
    Given an integer n, return true if n is a perfect number, otherwise return false.
     */

    public static void main(String[] args) {
        int num = 28;
        System.out.println(checkPerfectNumber(num));
    }

    // BEATS 75%
    public static boolean checkPerfectNumber(int num) {
        if (num % 2 != 0) return false;
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) sum += i;
        }
        return sum == num;
    }

    // BEATS 51%
    public static boolean checkPerfectNumber1(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) sum += i;
        }
        return sum == num;
    }
}