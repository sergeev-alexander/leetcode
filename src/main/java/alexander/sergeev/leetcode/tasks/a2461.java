package alexander.sergeev.leetcode.tasks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 2461. Maximum Sum of Distinct Subarrays With Length K
public class a2461 {

    /*
    You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays
    of nums that meet the following conditions:
    The length of the subarray is k, and
    All the elements of the subarray are distinct.
    Return the maximum subarray sum of all the subarrays that meet the conditions.
    If no subarray meets the conditions, return 0.
    A subarray is a contiguous non-empty sequence of elements within an array.
     */

    public static void main(String[] args) {
        int[] nums = {9, 9, 9, 1, 2, 3};
        int k = 3;
        System.out.println(maximumSubarraySum(nums, k));
    }

    // BEATS 86%
    public static long maximumSubarraySum(int[] nums, int k) {
        if (k == 1) {
            int temp = 0;
            for (int n : nums) {
                temp = Math.max(temp, n);
            }
            return temp;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        int pointerLeft = 0;
        int pointerRight = 1;
        long sum = nums[0];
        long finalSum = 0;
        set.add(nums[0]);
        while (pointerRight < nums.length) {
            if (set.contains(nums[pointerRight])) {
                set.remove(nums[pointerLeft]);
                sum -= nums[pointerLeft];
                pointerLeft++;
            } else {
                set.add(nums[pointerRight]);
                sum += nums[pointerRight];
                if (pointerRight - pointerLeft == k - 1) {
                    finalSum = Math.max(sum, finalSum);
                    set.remove(nums[pointerLeft]);
                    sum -= nums[pointerLeft];
                    pointerLeft++;
                }
                pointerRight++;
            }
        }
        return finalSum;
    }

    // BEATS 58%
    public static long maximumSubarraySum3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long maxSum = 0L;
        long tempSum = 0L;
        for (int i = 0; i < k; i++) {
            map.merge(nums[i], 1, Integer::sum);
            tempSum += nums[i];
        }
        maxSum = map.size() == k ? tempSum : 0;
        for (int i = k; i < nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
            tempSum += nums[i];
            if (map.merge(nums[i - k], -1, Integer::sum) == 0) {
                map.remove(nums[i - k]);
            }
            tempSum -= nums[i - k];
            if (map.size() == k) {
                maxSum = Math.max(maxSum, tempSum);
            }
        }
        return maxSum;
    }

    // TLE
    public static long maximumSubarraySum2(int[] nums, int k) {
        long maxSum = 0L;
        MARK:
        for (int i = 0; i <= nums.length - k; i++) {
            Set<Integer> set = new HashSet<>();
            long tempSum = 0L;
            if (k % 2 != 0) {
                tempSum += nums[i + k % 2];
                set.add(nums[i + k % 2]);
            }
            for (int l = 0, r = k - 1; l < r; l++, r--) {
                if (set.contains(nums[i + l]) || set.contains(nums[i + r])) {
                    continue MARK;
                }
                tempSum += nums[i + l] + nums[i + r];
                set.add(nums[i + l]);
                set.add(nums[i + r]);
            }
            maxSum = Math.max(maxSum, tempSum);
        }
        return maxSum;
    }

    // TLE
    public static long maximumSubarraySum1(int[] nums, int k) {
        long maxSum = 0L;
        Set<Integer> set = new HashSet<>();
        MARK:
        for (int i = 0; i <= nums.length - k; i++) {
            long tempSum = 0L;
            for (int j = 0; j < k; j++) {
                if (set.contains(nums[i + j])) {
                    set.clear();
                    continue MARK;
                }
                tempSum += nums[i + j];
                set.add(nums[i + j]);
            }
            set.clear();
            maxSum = Math.max(maxSum, tempSum);
        }
        return maxSum;
    }
}