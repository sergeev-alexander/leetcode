package alexander.sergeev.leetcode.tasks;

// 1952. Three Divisors
public class a1952 {

    /*
    Given an integer n, return true if n has exactly three positive divisors. Otherwise, return false.
    An integer m is a divisor of n if there exists an integer k such that n = k * m.
     */

    public static void main(String[] args) {
        int n = 4;
        System.out.println(isThree(n));
    }

    // BEATS 63%
    public static boolean isThree(int n) {
        int count = 2;
        for (int i = n - 1; i > 1; i--) {
            if (n % i == 0) count++;
        }
        return count == 3;
    }
}