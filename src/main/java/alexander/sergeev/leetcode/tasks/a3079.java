package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 3079. Find the Sum of Encrypted Integers
public class a3079 {

    /*
    You are given an integer array nums containing positive integers.
    We define a function encrypt such that encrypt(x) replaces every digit in x with the largest digit in x.
    For example, encrypt(523) = 555 and encrypt(213) = 333.
    Return the sum of encrypted elements.
     */

    public static void main(String[] args) {

        int[] a = {10, 21, 31};
        System.out.println(sumOfEncryptedInt(a));
    }

    // BEATS 99%
    public static int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            int max = 0;
            int p = 0;
            for (; num > 0; num /= 10) {
                max = Math.max(max, num % 10);
                p = p * 10 + 1;
            }
            sum += p * max;
        }
        return sum;
    }

    public static int sumOfEncryptedInt_BEATS_5_PERCENT(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            String[] arr = String.valueOf(num).split("");
            Arrays.sort(arr);
            Arrays.fill(arr, arr[arr.length - 1]);
            sum += Integer.parseInt(String.join("", arr));
        }
        return sum;
    }

    public static int sumOfEncryptedInt_BEATS_6_PERCENT(int[] nums) {
        return Arrays.stream(nums)
                .flatMap(i -> {
                    String str = String.valueOf(i);
                    int max = Integer.parseInt(Arrays.stream(str.split(""))
                            .max(Comparator.naturalOrder())
                            .get());
                    return IntStream.of(Integer.parseInt(Stream.generate(() -> max)
                            .map(String::valueOf)
                            .limit(str.length())
                            .collect(Collectors.joining())));
                })
                .sum();
    }
}
