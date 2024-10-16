package alexander.sergeev.leetcode.tasks;

// 2894. Divisible and Non-divisible Sums Difference
public class a2894 {

    /*
    You are given positive integers n and m.
    Define two integers as follows:
    num1: The sum of all integers in the range [1, n] (both inclusive) that are not divisible by m.
    num2: The sum of all integers in the range [1, n] (both inclusive) that are divisible by m.
    Return the integer num1 - num2.
     */

    public static void main(String[] args) {
        int n = 10;
        int m = 3;
        System.out.println(differenceOfSums(n, m));
    }

    // BEATS 100%
    public static int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) num2 += i;
            else num1 += i;
        }
        return num1 - num2;
    }
}