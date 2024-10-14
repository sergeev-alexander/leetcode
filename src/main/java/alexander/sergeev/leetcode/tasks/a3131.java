package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 3131. Find the Integer Added to Array I
public class a3131 {

    /*
    You are given two arrays of equal length, nums1 and nums2.
    Each element in nums1 has been increased (or decreased in the case of negative) by an integer,
    represented by the variable x.
    As a result, nums1 becomes equal to nums2.
    Two arrays are considered equal when they contain the same integers with the same frequencies.
    Return the integer x.
     */

    public static void main(String[] args) {

        int[] a = {2, 6, 4};
        int[] b = {9, 7, 5};
        System.out.println(addedInteger(a, b));
    }

    public static int addedInteger(int[] nums1, int[] nums2) {
        int min1 = nums1[0];
        int min2 = nums2[0];
        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i] < min1) min1 = nums1[i];
            if (nums2[i] < min2) min2 = nums2[i];
        }
        return min2 - min1;
    }

    public static int addedInteger_SLOW(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums2[0] - nums1[0];
    }

    public static int addedInteger_VERY_SLOW(int[] nums1, int[] nums2) {
        return Arrays.stream(nums2).min().getAsInt() - Arrays.stream(nums1).min().getAsInt();
    }
}
