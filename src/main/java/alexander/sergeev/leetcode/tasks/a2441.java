package alexander.sergeev.leetcode.tasks;

// 2441. Largest Positive Integer That Exists With Its Negative
public class a2441 {

    /*
    Given an integer array nums that does not contain any zeros,
    find the largest positive integer k such that -k also exists in the array.
    Return the positive integer k. If there is no such integer, return -1.
     */

    public static void main(String[] args) {
        int[] nums = {-1,10,6,7,-7,1};
        System.out.println(findMaxK(nums));
    }

    // BEATS 95%
    public static int findMaxK(int[] nums) {
        int max = 0;
        int[] arr = new int[1001];
        for (int num : nums) {
            if (arr[Math.abs(num)] + num == 0) {
                max = Math.max(max, Math.abs(num));
            }
            arr[Math.abs(num)] = num;
        }
        return max == 0 ? -1 : max;
    }
}