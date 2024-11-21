package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 1984. Minimum Difference Between Highest and Lowest of K Scores
public class a1984 {

    /*
    You are given a 0-indexed integer array nums, where nums[i] represents the score of the ith student.
    You are also given an integer k.
    Pick the scores of any k students from the array so that
    the difference between the highest and the lowest of the k scores is minimized.
    Return the minimum possible difference.
     */

    public static void main(String[] args) {
        int[] arr = {9,4,1,7};
        int k = 2;
        System.out.println(minimumDifference(arr, k));
    }

    // BEATS 98%
    public static int minimumDifference(int[] nums, int k) {
        if (nums.length == 1) return 0;
        Arrays.sort(nums);
        int minDif = 100000;
        for (int i = 0, j = k - 1; j < nums.length; i++, j++) {
            minDif = Math.min(minDif, nums[j] - nums[i]);
        }
        return minDif;
    }
}