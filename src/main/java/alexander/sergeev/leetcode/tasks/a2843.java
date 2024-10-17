package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;
import java.util.stream.IntStream;

// 2843. Count Symmetric Integers
public class a2843 {

    /*
    You are given two positive integers low and high.
    An integer x consisting of 2 * n digits is symmetric
    if the sum of the first n digits of x is equal to the sum of the last n digits of x.
    Numbers with an odd number of digits are never symmetric.
    Return the number of symmetric integers in the range [low, high].
     */

    public static void main(String[] args) {
        int a = 1;
        int b = 100;
        System.out.println(countSymmetricIntegers(a, b));
    }

    // BEATS 96%
    public static int countSymmetricIntegers(int low, int high) {
        int result = 0;
        for (int i = low; i <= high; i++) {
            if (isSymmetricInteger(i)) result++;
        }
        return result;
    }

    private static boolean isSymmetricInteger(int num) {
        if (num >= 10 && num <= 99)
            return num / 10 == num % 10;
        if (num >= 1000 && num <= 9999) {
            final int left = num / 100;
            final int right = num % 100;
            return left / 10 + left % 10 == right / 10 + right % 10;
        }
        return false;
    }

    public static int countSymmetricIntegers_BEATS_89_PESENT(int low, int high) {
        int count = 0;
        for (int i = low; i <= (low + high) / 2; i++) {
            String str = String.valueOf(i);
            if (str.length() % 2 == 0) {
                int sum1 = 0;
                int sum2 = 0;
                for (int j = 0, k = str.length() / 2; j < str.length() / 2; j++, k++) {
                    sum1 += str.charAt(j);
                    sum2 += str.charAt(k);
                }
                if (sum1 == sum2) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countSymmetricIntegers_BEATS_5_PERCENT(int low, int high) {
        return (int) IntStream.range(low, high + 1)
                .mapToObj(String::valueOf)
                .filter(s -> s.length() % 2 == 0)
                .filter(s -> {
                    int size = s.length() / 2;
                    return Arrays.stream(s.substring(0, size).split(""))
                            .mapToInt(Integer::parseInt)
                            .sum() == Arrays.stream(s.substring(size).split(""))
                            .mapToInt(Integer::parseInt)
                            .sum();
                })
                .count();
    }
}