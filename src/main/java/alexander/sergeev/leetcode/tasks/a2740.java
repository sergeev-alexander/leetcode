package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 2740. Find the Value of the Partition
public class a2740 {

    /*
    You are given a positive integer array nums.
    Partition nums into two arrays, nums1 and nums2, such that:
    Each element of the array nums belongs to either the array nums1 or the array nums2. Both arrays are non-empty.
    The value of the partition is minimized. The value of the partition is |max(nums1) - min(nums2)|.
    Here, max(nums1) denotes the maximum element of the array nums1, and min(nums2) denotes the minimum element of the array nums2.
    Return the integer denoting the value of such partition.
     */

    public static void main(String[] args) {
        int[] nums = {59,51,1,98,73};
        System.out.println(findValueOfPartition(nums));
    }

    // BEATS 98%
    public static int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            diff = Math.min(diff, nums[i + 1] - nums[i]);
        }
        return Math.abs(diff);
    }

    // BEATS 38%
    public static int findValueOfPartition1(int[] nums) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            diff = Math.min(diff, Math.abs(nums[i] - nums[i + 1]));
        }
        return diff;
    }
}