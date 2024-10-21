package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 2733. Neither Minimum nor Maximum
public class a2733 {

    /*
    Given an integer array nums containing distinct positive integers, find and return any number from the array
    that is neither the minimum nor the maximum value in the array, or -1 if there is no such number.
    Return the selected integer.
     */

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4};
        System.out.println(findNonMinOrMax(arr));
    }

    // BEATS 99%
    public static int findNonMinOrMax(int[] nums) {
        if (nums.length <= 2) return -1;
        int min = Math.min(nums[0], Math.min(nums[1], nums[2]));
        int max = Math.max(nums[0], Math.max(nums[1], nums[2]));
        if (nums[0] > min && nums[0] < max) return nums[0];
        else if (nums[1] > min && nums[1] < max) return nums[1];
        else return nums[2];
    }

    // BEATS 51%
    public static int findNonMinOrMax1(int[] nums) {
        if (nums.length <= 2) return -1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[0] && nums[i] < nums[nums.length - 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}