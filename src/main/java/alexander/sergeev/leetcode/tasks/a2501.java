package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 2501. Longest Square Streak in an Array
public class a2501 {

    /*
    You are given an integer array nums. A subsequence of nums is called a square streak if:
    The length of the subsequence is at least 2, and
    after sorting the subsequence, each element (except the first element) is the square of the previous number.
    Return the length of the longest square streak in nums, or return -1 if there is no square streak.
    A subsequence is an array that can be derived from another array by deleting some or no elements without changing
    the order of the remaining elements.
     */

    public static void main(String[] args) {
        int[] nums = {4,3,6,16,8,2};
        System.out.println(longestSquareStreak(nums));
    }

    // BEATS 87%
    public static int longestSquareStreak(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int maxCount = -1;
        for (int i : nums) {
            int count = 1;
            int num = i;
            if (num > Math.sqrt(Integer.MAX_VALUE)) continue;
            while (set.contains(num * num)) {
                count++;
                num = num * num;
                if (count == 5) return 5;
            }
            maxCount = count > 1 ? Math.max(maxCount, count) : maxCount;
        }
        return maxCount;
    }

    // TLE
    public static int longestSquareStreak1(int[] nums) {
        Arrays.sort(nums);
        int maxCount = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            int count = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.sqrt(nums[j]) == num) {
                    count++;
                    num = nums[j];
                }
            }
            maxCount = count > 1 ? Math.max(maxCount, count) : maxCount;
        }
        return maxCount;
    }
}