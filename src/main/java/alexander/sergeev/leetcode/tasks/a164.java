package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 164. Maximum Gap
public class a164 {

    /*
    Given an integer array nums, return the maximum difference between two successive elements in its sorted form.
    If the array contains less than two elements, return 0.
    You must write an algorithm that runs in linear time and uses linear extra space.
     */
    public static void main(String[] args) {

        int[] arr = {3,6,9,1};

        System.out.println(maximumGap(arr));
    }

    public static int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        int dif = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            dif = Math.max(dif, nums[i + 1] - nums[i]);
        }
        return dif;
    }
}
