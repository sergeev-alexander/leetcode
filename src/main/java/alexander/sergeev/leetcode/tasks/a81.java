package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 81. Search in Rotated Sorted Array II
public class a81 {

    /*
    Given the array nums after the rotation and an integer target,
    return true if target is in nums, or false if it is not in nums.
    You must decrease the overall operation steps as much as possible.
     */

    public static void main(String[] args) {

        int[] nums = {1, 0, 1, 1, 1};

        int target = 0;

        System.out.println(search(nums, target));

    }

    public static boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return false;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (!isBinarySearchHelpful(nums, left, nums[mid])) {
                left++;
                continue;
            }
            boolean pivotArray = existsInFirst(nums, left, nums[mid]);
            boolean targetArray = existsInFirst(nums, left, target);
            if (pivotArray ^ targetArray) {
                if (pivotArray) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    private static boolean isBinarySearchHelpful(int[] arr, int start, int element) {
        return arr[start] != element;
    }

    private static boolean existsInFirst(int[] arr, int start, int element) {
        return arr[start] <= element;
    }

    public static boolean searchSLOW(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
