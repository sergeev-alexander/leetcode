package alexander.sergeev.leetcode.tasks;

// 2057. Smallest Index With Equal Value
public class a2057 {

    /*
    Given a 0-indexed integer array nums, return the smallest index i of nums such that i mod 10 == nums[i],
    or -1 if such index does not exist.
    x mod y denotes the remainder when x is divided by y.
     */

    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        System.out.println(smallestEqual(arr));
    }

    // BEATS 100%
    public static int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) return i;
        }
        return -1;
    }
}