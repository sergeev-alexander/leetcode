package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 2616. Minimize the Maximum Difference of Pairs
public class a2616 {

    /*
    You are given a 0-indexed integer array nums and an integer p.
    Find p pairs of indices of nums such that the maximum difference amongst all the pairs is minimized.
    Also, ensure no index appears more than once amongst the p pairs.
    Note that for a pair of elements at the index i and j, the difference of this pair is |nums[i] - nums[j]|,
    where |x| represents the absolute value of x.
    Return the minimum maximum difference among all p pairs. We define the maximum of an empty set to be zero.
     */

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 1, 3};
        int p = 2;
        System.out.println(minimizeMax(arr, p));
    }

    public static int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0] + 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (countPairsWithDifference(nums, mid) >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int countPairsWithDifference(int[] nums, int maxDifference) {
        int pairCount = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i + 1] - nums[i] <= maxDifference) {
                pairCount++;
                i++;
            }
        }
        return pairCount;
    }
}