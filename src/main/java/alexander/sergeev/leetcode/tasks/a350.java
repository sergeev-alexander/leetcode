package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 350. Intersection of Two Arrays II
public class a350 {

    /*
    Given two integer arrays nums1 and nums2, return an array of their intersection.
    Each element in the result must appear as many times as it shows in both arrays
    and you may return the result in any order.
     */

    public static void main(String[] args) {
        int[] a1 = {2, 2, 1, 2};
        int[] a2 = {2, 2};
        System.out.println(Arrays.toString(intersect(a1, a2)));
    }

    // BEATS 98%
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] arr1 = new int[1001];
        int[] arr2 = new int[1001];
        for (int num : nums1) {
            arr1[num]++;
        }
        int min = 1000;
        int max = 1;
        for (int num : nums2) {
            arr2[num]++;
            if (arr1[num] > 0) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
        }
        int[] result = new int[1001];
        int pos = 0;
        int count = 0;
        for (int i = min; i <= max; i++) {
            if (arr1[i] > 0 && arr2[i] > 0) {
                int num = Math.min(arr1[i], arr2[i]);
                while (num-- > 0) {
                    result[pos++] = i;
                    count++;
                }
            }
        }
        return Arrays.copyOfRange(result, 0, count);
    }

    // BEATS 94%
    public static int[] intersect1(int[] nums1, int[] nums2) {
        int[] arr1 = new int[1001];
        int[] arr2 = new int[1001];
        for (int num : nums1) {
            arr1[num]++;
        }
        for (int num : nums2) {
            arr2[num]++;
        }
        int[] result = new int[1001];
        int pos = 0;
        int count = 0;
        for (int i = 0; i < result.length; i++) {
            if (arr1[i] > 0 && arr2[i] > 0) {
                int num = Math.min(arr1[i], arr2[i]);
                while (num-- > 0) {
                    result[pos++] = i;
                    count++;
                }
            }
        }
        return Arrays.copyOfRange(result, 0, count);
    }
}