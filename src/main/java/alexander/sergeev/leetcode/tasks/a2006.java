package alexander.sergeev.leetcode.tasks;

// 2006. Count Number of Pairs With Absolute Difference K
public class a2006 {

    /*
    Given an integer array nums and an integer k,
    return the number of pairs (i, j) where i < j such that |nums[i] - nums[j]| == k.
    The value of |x| is defined as:
    x if x >= 0.
    -x if x < 0.
     */

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,4};
        int k = 2;
        System.out.println(countKDifference(arr, k));
    }

    // BEATS 98%
    public static int countKDifference(int[] nums, int k) {
        int countPairs = 0;
        int[] countNumbers = new int[110];
        for (int num : nums) {
            if (num >= k) {
                countPairs += countNumbers[num - k];
            }
            if (num + k <= 100) {
                countPairs += countNumbers[num + k];
            }
            ++countNumbers[num];
        }
        return countPairs;
    }

    // BEATS 45%
    public static int countKDifference1(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) count++;
            }
        }
        return count;
    }
}