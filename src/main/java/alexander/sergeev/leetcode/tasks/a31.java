package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 31. Next Permutation
public class a31 {

    /*
    Given an array of integers nums, find the next permutation of nums.
    While the next permutation of arr = [3,2,1] is [1,2,3]
    because [3,2,1] does not have a lexicographical larger rearrangement.
     */

    public static List<Integer[]> list = new ArrayList<>();

    public static void main(String[] args) {

        int[] nums = {3, 2, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
