package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 2729. Check if The Number is Fascinating
public class a2729 {

    /*
    You are given an integer n that consists of exactly 3 digits.
    We call the number n fascinating if, after the following modification,
    the resulting number contains all the digits from 1 to 9 exactly once and does not contain any 0's:
    Concatenate n with the numbers 2 * n and 3 * n.
    Return true if n is fascinating, or false otherwise.
    Concatenating two numbers means joining them together. For example, the concatenation of 121 and 371 is 121371.
     */

    public static void main(String[] args) {
        int num = 192;
        System.out.println(isFascinating(num));
    }

    // BEATS 94%
    public static boolean isFascinating(int n) {
        Set<Integer> set = new HashSet<>();
        int a = n * 2;
        int b = n * 3;
        while (n != 0) {
            if (!set.add(n % 10)) return false;
            n /= 10;
        }
        while (a != 0) {
            if (!set.add(a % 10)) return false;
            a /= 10;
        }
        while (b != 0) {
            if (!set.add(b % 10)) return false;
            b /= 10;
        }
        return set.size() == 9 && !set.contains(0);
    }

    // BEATS 29%
    public static boolean isFascinating3(int n) {
        String str = String.valueOf(n) + n * 2 + n * 3;
        if (str.length() != 9 || str.contains("0")) return false;
        for (int i = 1; i <= 9; i++) {
            String s = String.valueOf(i);
            if (str.indexOf(s) != str.lastIndexOf(s))
                return false;
        }
        return true;
    }

    // BEATS 14%
    public static boolean isFascinating2(int n) {
        String str = String.valueOf(n) + n * 2 + n * 3;
        if (str.length() != 9 || str.contains("0")) return false;
        for (int i = 1; i <= 9; i++) {
            if (str.indexOf(String.valueOf(i)) != str.lastIndexOf(String.valueOf(i)))
                return false;
        }
        return true;
    }

    // BEATS 6%
    public static boolean isFascinating1(int n) {
        String str = String.valueOf(n) + n * 2 + n * 3;
        return str.length() == 9
                && !str.contains("0")
                && Arrays.stream(str.split(""))
                .distinct()
                .count() == 9;
    }
}