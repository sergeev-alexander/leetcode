package alexander.sergeev.leetcode.tasks;

import java.util.HashSet;
import java.util.Set;

// 532. K-diff Pairs in an Array
public class a532 {

    /*
    Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
    A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
    0 <= i, j < nums.length
    i != j
    |nums[i] - nums[j]| == k
    Notice that |val| denotes the absolute value of val.
     */

    public static void main(String[] args) {

        int[] arr = {1,2,4,4,3,3,0,9,2,3};
        System.out.println(findPairs(arr, 3));

    }

    // VERY SLOW...
    public static int findPairs(int[] nums, int k) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    set.add(Math.max(nums[i], nums[j]) + "" + Math.min(nums[i], nums[j]));
                }
            }
        }
        return set.size();
    }
}