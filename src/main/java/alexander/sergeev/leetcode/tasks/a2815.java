package alexander.sergeev.leetcode.tasks;

import java.util.HashMap;
import java.util.Map;

// 2815. Max Pair Sum in an Array
public class a2815 {

    /*
    You are given an integer array nums. You have to find the maximum sum of a pair of numbers from nums
    such that the largest digit in both numbers is equal.
    For example, 2373 is made up of three distinct digits: 2, 3, and 7, where 7 is the largest among them.
    Return the maximum sum or -1 if no such pair exists.
     */

    public static void main(String[] args) {
        int[] arr = {112,131,411};
        System.out.println(maxSum(arr));
    }

    // BEATS 81%
    public static int maxSum(int[] nums) {
        int maxSum = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            int num = x;
            int maxDigit = 0;
            while (num > 0) {
                maxDigit = Math.max(maxDigit, num % 10);
                num /= 10;
            }
            if (map.containsKey(maxDigit)) {
                int number = map.get(maxDigit);
                maxSum = Math.max(maxSum, number + x);
                if (number < x) map.put(maxDigit, x);
            } else map.put(maxDigit, x);
        }
        return maxSum;
    }
}