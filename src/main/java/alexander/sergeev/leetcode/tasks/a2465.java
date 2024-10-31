package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 2465. Number of Distinct Averages
public class a2465 {

    /*
    You are given a 0-indexed integer array nums of even length.
    As long as nums is not empty, you must repetitively:
    Find the minimum number in nums and remove it.
    Find the maximum number in nums and remove it.
    Calculate the average of the two removed numbers.
    The average of two numbers a and b is (a + b) / 2.
    For example, the average of 2 and 3 is (2 + 3) / 2 = 2.5.
    Return the number of distinct averages calculated using the above process.
    Note that when there is a tie for a minimum or maximum number, any can be removed.
     */

    public static void main(String[] args) {
        int[] nums = {4, 1, 4, 0, 3, 5};
        System.out.println(distinctAverages(nums));
    }

    // BEATS 100%
    public static int distinctAverages(int[] nums) {
        Set<Double> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            set.add((nums[i] + nums[j]) / 2.0);
        }
        return set.size();
    }
}