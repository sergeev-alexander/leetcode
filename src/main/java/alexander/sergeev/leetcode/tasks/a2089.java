package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 2089. Find Target Indices After Sorting Array
public class a2089 {

    /*
    You are given a 0-indexed integer array nums and a target element target.
    A target index is an index i such that nums[i] == target.
    Return a list of the target indices of nums after sorting nums in non-decreasing order.
    If there are no target indices, return an empty list. The returned list must be sorted in increasing order.
     */

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 2, 3}; // 1 2 2 3 4 5
        int target = 2;
        System.out.println(targetIndices(arr, target));
    }

    // BEATS 100%
    public static List<Integer> targetIndices(int[] nums, int target) {
        int elementsLower = 0;
        int timesTargetPresent = 0;
        for (int num : nums) {
            if (num == target) {
                timesTargetPresent++;
            }
            if (num < target) elementsLower++;
        }
        List<Integer> list = new ArrayList<>();
        while (timesTargetPresent-- > 0) {
            list.add(elementsLower++);
        }
        return list;
    }


    // BEATS 84%
    public static List<Integer> targetIndices2(int[] nums, int target) {
        int[] arr = new int[101];
        for (int num : nums) {
            if (num > target) continue;
            arr[num]++;
        }
        List<Integer> list = new ArrayList<>();
        int pos = 0;
        for (int num = 1; num <= target; num++) {
            if (num == target) {
                while (arr[num] > 0) {
                    list.add(pos++);
                    arr[num]--;
                }
            }
            if (arr[num] > 0) {
                pos += arr[num];
            }
        }
        return list;
    }

    // BEATS 41%
    public static List<Integer> targetIndices1(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) list.add(i);
        }
        return list;
    }
}