package alexander.sergeev.leetcode.tasks;

import java.util.*;

// 2342. Max Sum of a Pair With Equal Sum of Digits
public class a2342 {

    /*
    You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j,
    such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].
    Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j
    that satisfy the conditions.
     */

    public static void main(String[] args) {
        int[] nums = {18, 43, 36, 13, 7};
        System.out.println(maximumSum(nums));
    }

    // BEATS 91%
    public static int maximumSum(int[] nums) {
        int result = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int tempNum = num;
            int sumOfDigits = 0;
            while (tempNum > 0) {
                sumOfDigits += tempNum % 10;
                tempNum /= 10;
            }
            if (map.containsKey(sumOfDigits)) {
                result = Math.max(result, map.get(sumOfDigits) + num);
                if (num > map.get(sumOfDigits)) {
                    map.put(sumOfDigits, num);
                }
            } else {
                map.put(sumOfDigits, num);
            }
        }
        return result;
    }

    // BEATS 13%
    public static int maximumSum1(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int sum = 0;
            int num1 = num;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            if (!map.containsKey(sum)) {
                List<Integer> list = new ArrayList<>();
                list.add(num1);
                map.put(sum, list);
            } else {
                map.get(sum).add(num1);
            }
        }
        return map.values().stream()
                .filter(integers -> integers.size() > 1)
                .mapToInt(integers -> integers.stream()
                        .sorted(Comparator.reverseOrder())
                        .limit(2L)
                        .mapToInt(Integer::intValue)
                        .sum())
                .max()
                .orElse(-1);
    }
}