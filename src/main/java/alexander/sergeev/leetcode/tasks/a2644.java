package alexander.sergeev.leetcode.tasks;

import java.util.*;

// 2644. Find the Maximum Divisibility Score
public class a2644 {

    /*
    You are given two integer arrays nums and divisors.
    The divisibility score of divisors[i] is the number of indices j such that nums[j] is divisible by divisors[i].
    Return the integer divisors[i] with the maximum divisibility score.
    If multiple integers have the maximum score, return the smallest one.
     */

    public static void main(String[] args) {
        int[] nums = {1};
        int[] divs = {5, 7, 5};
        System.out.println(maxDivScore(nums, divs));
    }

    // BEATS 67%
    public static int maxDivScore(int[] nums, int[] divisors) {
        int divisor = divisors[0];
        int max = 0;
        for (int div : divisors) {
            int count = 0;
            for (int num : nums) {
                if (num % div == 0) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                divisor = div;
            }
            if (count == max) {
                divisor = Math.min(divisor, div);
            }
        }
        return divisor;
    }

    // BEATS 41%
    public static int maxDivScore4(int[] nums, int[] divisors) {
        Set<Integer> divSet = new HashSet<>();
        int divisor = divisors[0];
        int max = 0;
        for (int div : divisors) {
            if (divSet.contains(div)) continue;
            int count = 0;
            for (int num : nums) {
                if (num % div == 0) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                divisor = div;
            }
            if (count == max) {
                divisor = Math.min(divisor, div);
            }
            divSet.add(div);
        }
        return divisor;
    }

    // BEATS 13%
    public static int maxDivScore3(int[] nums, int[] divisors) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int div : divisors) {
            if (map.containsKey(div)) continue;
            map.put(div, 0);
            for (int num : nums) {
                if (num % div == 0) {
                    map.merge(div, 1, (o, n) -> o + 1);
                }
            }
        }
        int max = -1;
        int val = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                val = entry.getKey();
            }
            if (entry.getValue() == max) {
                val = Math.min(val, entry.getKey());
            }
        }
        return val;
    }

    // BEATS 5%
    public static int maxDivScore2(int[] nums, int[] divisors) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> divsSet = new HashSet<>();
        for (int divisor : divisors) {
            if (!divsSet.add(divisor)) continue;
            int count = 0;
            for (int num : nums) {
                if (num % divisor == 0) count++;
            }
            map.put(divisor, count);
        }
        Comparator<Map.Entry<Integer, Integer>> first = Map.Entry.comparingByValue();
        Comparator<Map.Entry<Integer, Integer>> second = Map.Entry.comparingByKey();
        return map.entrySet().stream()
                .min(first.reversed().thenComparing(second))
                .get()
                .getKey();
    }

    // BEATS 7%
    public static int maxDivScore1(int[] nums, int[] divisors) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int divisor : divisors) {
            int count = 0;
            for (int num : nums) {
                if (num % divisor == 0) count++;
            }
            map.put(divisor, count);
        }
        Comparator<Map.Entry<Integer, Integer>> first = Map.Entry.comparingByValue();
        Comparator<Map.Entry<Integer, Integer>> second = Map.Entry.comparingByKey();
        return map.entrySet().stream()
                .min(first.reversed().thenComparing(second))
                .get()
                .getKey();
    }
}