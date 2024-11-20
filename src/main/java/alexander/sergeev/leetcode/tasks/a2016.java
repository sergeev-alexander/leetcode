package alexander.sergeev.leetcode.tasks;

// 2016. Maximum Difference Between Increasing Elements
public class a2016 {

    /*
    Given a 0-indexed integer array nums of size n, find the maximum difference between nums[i] and nums[j]
    (i.e., nums[j] - nums[i]), such that 0 <= i < j < n and nums[i] < nums[j].
    Return the maximum difference. If no such i and j exists, return -1.
     */

    public static void main(String[] args) {
        int[] arr = {7,1,5,4};
        System.out.println(maximumDifference(arr));
    }

    // BEATS 100%
    public static int maximumDifference(int[] nums) {
        int minNum = nums[0];
        int maxDif = -1;
        for (int num : nums) {
            if (num < minNum) {
                minNum = num;
                continue;
            }
            if (num > minNum) {
                maxDif = Math.max(maxDif, num - minNum);
            }
        }
        return maxDif;
    }

    // BEATS 10%
    public static int maximumDifference1(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    max = Math.max(max, nums[j] - nums[i]);
                }
            }
        }
        return max;
    }
}