package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 217. Contains Duplicate
public class a217 {

    /*
    Given an integer array nums, return true if any value appears at least twice in the array,
    and return false if every element is distinct.
     */

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};

        System.out.println(containsDuplicate(nums));

    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate_A_BIT_FASTER(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }


    public static boolean containsDuplicate_SLOW(int[] nums) {
        boolean result = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1, k = nums.length - 1; j <= k; j++) {
                if (nums[i] == nums[j] || nums[i] == nums[k]) result = true;
            }
        }
        return result;
    }
}
