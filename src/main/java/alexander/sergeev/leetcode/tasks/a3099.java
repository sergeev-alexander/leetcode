package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 3099. Harshad Number
public class a3099 {

    /*
    An integer divisible by the sum of its digits is said to be a Harshad number.
    You are given an integer x. Return the sum of the digits of x if x is a Harshad number, otherwise, return -1.
     */

    public static void main(String[] args) {

        int x = 23;
        System.out.println(sumOfTheDigitsOfHarshadNumber(x));
    }

    // BEATS 100%
    public static int sumOfTheDigitsOfHarshadNumber(int x) {
        int divisor =  Arrays.stream(String.valueOf(x).split(""))
                .mapToInt(Integer::parseInt)
                .sum();
        return x % divisor == 0 ? divisor : -1;
    }
}
