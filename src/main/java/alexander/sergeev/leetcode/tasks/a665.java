package alexander.sergeev.leetcode.tasks;

// 665. Non-decreasing Array
public class a665 {

    /*
    Given an array nums with n integers,
    your task is to check if it could become non-decreasing by modifying at most one element.
    We define an array is non-decreasing if nums[i] <= nums[i + 1] holds
    for every i (0-based) such that (0 <= i <= n - 2).
     */

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 3}; // -1,4,2,3      3,4,2,3
        System.out.println(checkPossibility(arr));
    }

    // BEATS 100%
    public static boolean checkPossibility(int[] nums) {
        int n = nums.length - 1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > nums[i + 1]) {
                int current = nums[i];
                int next = nums[i + 1];
                nums[i] = next;
                boolean isSorted = true;
                for (int j = 0; j < n; j++) {
                    if (nums[j] > nums[j + 1]) {
                        isSorted = false;
                        break;
                    }
                }
                if (isSorted) return true;
                nums[i] = current;
                nums[i + 1] = current;
                for (int j = 0; j < n; j++) {
                    if (nums[j] > nums[j + 1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}