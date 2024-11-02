package alexander.sergeev.leetcode.tasks;

// 2427. Number of Common Factors
public class a2427 {

    /*
    Given two positive integers a and b, return the number of common factors of a and b.
    An integer x is a common factor of a and b if x divides both a and b.
     */

    public static void main(String[] args) {
        int a = 12;
        int b = 6;
        System.out.println(commonFactors(a,b));
    }

    // BEATS 100%
    public static int commonFactors(int a, int b) {
        int count = 1;
        int min = Math.min(a, b);
        for (int i = min; i > 1; i--) {
            if (a % i == 0 && b % i == 0) count++;
        }
        return count;
    }

    // BEATS 100% (EXPERIMENTAL, SHOULD BE FASTER)
    public static int commonFactors1(int a, int b) {
        int gcd = GCD(a,b);
        int count = 1;
        for (int i = gcd; i > 1; i--) {
            if (a % i == 0 && b % i == 0) count++;
        }
        return count;
    }

    public static int GCD(int a, int b) {
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