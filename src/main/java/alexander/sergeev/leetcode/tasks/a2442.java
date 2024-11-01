package alexander.sergeev.leetcode.tasks;

import java.util.HashSet;
import java.util.Set;

// 2442. Count Number of Distinct Integers After Reverse Operations
public class a2442 {

    /*
    You are given an array nums consisting of positive integers.
    You have to take each integer in the array, reverse its digits, and add it to the end of the array.
    You should apply this operation to the original integers in nums.
    Return the number of distinct integers in the final array.
     */

    public static void main(String[] args) {
        int[] nums = {1,13,10,12,31};
        System.out.println(countDistinctIntegers(nums));
    }

    // BEATS 80%
    public static int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            int reversed = 0;
            while (num > 0) {
                reversed = reversed * 10 + num % 10;
                num /= 10;
            }
            set.add(reversed);
        }
        return set.size();
    }

    // BEATS 17%
    public static int countDistinctIntegers2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            int reversed = 0;
            int size = (int) Math.log10(num);
            while (num > 0) {
                reversed += reversed % 10 * (int) Math.pow(10, size);
                num /= 10;
                size--;
            }
            set.add(reversed);
        }
        return set.size();
    }

    // BEATS 8%
    public static int countDistinctIntegers1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            set.add(Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString()));
        }
        return set.size();
    }
}