package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 3194. Minimum Average of Smallest and Largest Elements
public class a3194 {

    /*
    You have an array of floating point numbers averages which is initially empty.
    You are given an array nums of n integers where n is even.
    You repeat the following procedure n / 2 times:
    Remove the smallest element, minElement, and the largest element maxElement, from nums.
    Add (minElement + maxElement) / 2 to averages.
    Return the minimum element in averages.
     */

    public static void main(String[] args) {

        int[] arr = {7, 8, 3, 4, 15, 13, 4, 1};

        System.out.println(minimumAverage(arr));
    }

    public static double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        double min = Integer.MAX_VALUE;
        while (left < right) {
            min = Math.min((nums[left] + nums[right]) / 2.0, min);
            left++;
            right--;
        }
        return min;
    }
}
