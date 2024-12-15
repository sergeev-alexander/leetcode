package alexander.sergeev.leetcode.tasks;

// 704. Binary Search
public class a704 {

    /*
    Given an array of integers nums which is sorted in ascending order, and an integer target,
    write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
    You must write an algorithm with O(log n) runtime complexity.
     */

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums, target));
    }

    // BEATS 100%
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) right = --mid;
            else left = ++mid;
        }
        return -1;
    }
}