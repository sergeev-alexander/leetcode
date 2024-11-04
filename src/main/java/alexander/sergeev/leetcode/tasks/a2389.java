package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 2389. Longest Subsequence With Limited Sum
public class a2389 {

    /*
    You are given an integer array nums of length n, and an integer array queries of length m.
    Return an array answer of length m where answer[i] is the maximum size of a subsequence
    that you can take from nums such that the sum of its elements is less than or equal to queries[i].
    A subsequence is an array that can be derived from another array by deleting some or no elements without
    changing the order of the remaining elements.
     */

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 1};
        int[] queries = {3, 10, 21};
        System.out.println(Arrays.toString(answerQueries(arr, queries)));
    }

    // BEATS 98%
    public static int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            queries[i] = Math.abs(~Arrays.binarySearch(nums, queries[i]));
        }
        return queries;
    }

    // BEATS 54%
    public static int[] answerQueries4(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int num : nums) {
                if (num <= queries[i]) result[i] += 1;
                else break;
            }
        }
        return result;
    }

    // BEATS 28%
    public static int[] answerQueries3(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int num : nums) {
                if (num <= queries[i]) result[i] += 1;
                else break;
            }
        }
        return result;
    }

    // BEATS 19%
    public static int[] answerQueries2(int[] nums, int[] queries) {
        Arrays.sort(nums);
        MARK:
        for (int i = 0; i < queries.length; i++) {
            int sum = 0;
            int limit = queries[i];
            queries[i] = 0;
            for (int num : nums) {
                if (sum + num <= limit) {
                    sum += num;
                    queries[i]++;
                } else {
                    continue MARK;
                }
            }
        }
        return queries;
    }

    // BEATS 8%
    public static int[] answerQueries1(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] result = new int[queries.length];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            for (int j = 0; j < queries.length; j++) {
                if (sum <= queries[j]) {
                    result[j]++;
                }
            }
        }
        return result;
    }
}