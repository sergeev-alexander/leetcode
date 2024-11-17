package alexander.sergeev.leetcode.tasks;

// 2104. Sum of Subarray Ranges
public class a2104 {

    /*
    You are given an integer array nums.
    The range of a subarray of nums is the difference between the largest and smallest element in the subarray.
    Return the sum of all subarray ranges of nums.
    A subarray is a contiguous non-empty sequence of elements within an array.
     */

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(subArrayRanges(arr));
    }

    // BEATS 95%
    public static long subArrayRanges(int[] nums) {
        long subArraysSumm = 0L;
        for (int i = 0; i < nums.length - 1; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                subArraysSumm += max - min;
            }
        }
        return subArraysSumm;
    }
}