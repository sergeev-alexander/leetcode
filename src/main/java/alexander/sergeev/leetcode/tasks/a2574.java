package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 2574. Left and Right Sum Differences
public class a2574 {

    /*
    Given a 0-indexed integer array nums, find a 0-indexed integer array answer where:
    answer.length == nums.length.
    answer[i] = |leftSum[i] - rightSum[i]|.
    Where:
    leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
    rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.
    Return the array answer.
     */

    public static void main(String[] args) {
        int[] arr = {10, 4, 8, 3};
        System.out.println(Arrays.toString(leftRightDifference(arr)));
    }

    // BEATS 99%
    public static int[] leftRightDifference(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] result = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = Math.abs(left[i] - right[i]);
        }

        return result;
    }

    // BEATS 12%
    public static int[] leftRightDifference1(int[] nums) {
        if (nums.length == 0) return new int[]{0};
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            int leftPos = i - 1;
            int rightPos = i + 1;
            while (leftPos >= 0) {
                leftSum += nums[leftPos--];
            }
            while (rightPos < nums.length) {
                rightSum += nums[rightPos++];
            }
            result[i] = Math.abs(leftSum - rightSum);
        }
        return result;
    }
}