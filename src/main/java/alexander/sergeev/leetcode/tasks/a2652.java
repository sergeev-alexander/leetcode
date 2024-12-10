package alexander.sergeev.leetcode.tasks;

// 2652. Sum Multiples
public class a2652 {

    /*
    Given a positive integer n, find the sum of all integers in the range [1, n] inclusive that are divisible by 3, 5, or 7.
    Return an integer denoting the sum of all numbers in the given range satisfying the constraint.
     */

    public static void main(String[] args) {
        int n = 10;
        System.out.println(sumOfMultiples(n));
    }

    // BEATS 99%
    public static int sumOfMultiples(int n) {
        int sumA = getSum(n, 3);
        int sumB = getSum(n, 5);
        int sumC = getSum(n, 7);
        int sumAB = getSum(n, 3 * 5);
        int sumAC = getSum(n, 3 * 7);
        int sumBC = getSum(n, 5 * 7);
        int sumABC = getSum(n, 3 * 5 * 7);
        return sumA + sumB + sumC - sumAB - sumAC - sumBC + sumABC;
    }

    public static int getSum(int n, int value) {
        int high = (n / value) * value;
        int count = (high + value - value) / value;
        return (value + high) * count / 2;
    }

    // BEATS 63%
    public static int sumOfMultiples1(int n) {
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) sum += i;
        }
        return sum;
    }
}