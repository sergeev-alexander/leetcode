package alexander.sergeev.leetcode.tasks;

// 26. Remove Duplicates from Sorted Array
public class a26 {

    /*
    Given an integer array nums sorted in non-decreasing order,
    remove the duplicates in-place such that each unique element appears only once.
    The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
     */

    public static void main(String[] args) {

        int[] n = new int[]{1, 1, 2, 2, 3, 3, 4, 4};
        System.out.println(removeDuplicates(n));
    }

    public static int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static int removeDuplicates_SLOWER(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int left = 0;
        int right = 1;
        while (right <= n - 1) {
            if (nums[right] != nums[left]) {
                nums[left + 1] = nums[right];
                left++;
            }
            right++;
        }
        return left + 1;
    }
}