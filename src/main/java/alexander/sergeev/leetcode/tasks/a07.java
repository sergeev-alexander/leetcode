package alexander.sergeev.leetcode.tasks;

import java.util.stream.Collectors;
import java.util.stream.Stream;

// 7. Reverse Integer
public class a07 {

    /*
    Given a signed 32-bit integer x, return x with its digits reversed.
    If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
     */

    public static void main(String[] args) {

        int n = -210;

        System.out.println(reverse(n)); // -12

    }

    public static int reverse(int x) {
        boolean isPositive = x >= 0;
        String[] str = String.valueOf(x).split("");
        long result = Long.parseLong(Stream.iterate(str.length - 1, i -> i >= (isPositive ? 0 : 1), i -> --i)
                .map(i -> str[i])
                .collect(Collectors.joining()));
        System.out.println(result);
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
        else return (int) result * (isPositive ? 1 : -1);
    }

    public static int reverse_A_BIT_SLOW(int x) {
        boolean isPositive = x >= 0;
        String s = isPositive ? String.valueOf(x) : String.valueOf(x).substring(1);
        long result = Long.parseLong(new StringBuilder(s).reverse().toString());
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result * (isPositive ? 1 : -1);
    }
}
