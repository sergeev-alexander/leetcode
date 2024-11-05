package alexander.sergeev.leetcode.tasks;

// 2348. Number of Zero-Filled Subarrays
public class a2348 {

    /*
    Given an integer array nums, return the number of subarrays filled with 0.
    A subarray is a contiguous non-empty sequence of elements within an array.
     */

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 2, 0, 0};
        System.out.println(zeroFilledSubarray(arr));
    }

    // BEATS 95%
    public static long zeroFilledSubarray(int[] nums) {
        long count = 0L;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) continue;
            long tempCount = 0;
            while (i < nums.length && nums[i] == 0) {
                tempCount++;
                i++;
            }
            count += (tempCount + 1) * tempCount / 2;
        }
        return count;
    }
}