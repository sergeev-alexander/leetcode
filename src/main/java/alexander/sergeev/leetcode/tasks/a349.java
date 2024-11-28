package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 349. Intersection of Two Arrays
public class a349 {

    /*
    Given two integer arrays nums1 and nums2, return an array of their intersection.
    Each element in the result must be unique and you may return the result in any order.
     */

    public static void main(String[] args) {
        int[] a1 = {4,9,5};
        int[] a2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(a1, a2)));
    }

    // BEATS 98%
    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];
        for (int num : nums1) {
            if (arr[num] == 0) {
                arr[num]++;
            }
        }
        int count = 0;
        int min = 1000;
        int max = 1;
        for (int num : nums2) {
            if (arr[num] == 1) {
                count++;
                arr[num]++;
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
        }
        int[] result = new int[count];
        int pos = 0;
        for (int i = min; i <= max; i++) {
            if (arr[i] == 2) {
                result[pos++] = i;
            }
        }
        return result;
    }

    // BEATS 98%
    public static int[] intersection1(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];
        for (int num : nums1) {
            if (arr[num] == 0) {
                arr[num]++;
            }
        }
        int count = 0;
        for (int num : nums2) {
            if (arr[num] == 1) {
                count++;
                arr[num]++;
            }
        }
        int[] result = new int[count];
        int pos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                result[pos++] = i;
            }
        }
        return result;
    }
}