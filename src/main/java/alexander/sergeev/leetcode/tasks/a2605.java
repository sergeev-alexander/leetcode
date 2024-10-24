package alexander.sergeev.leetcode.tasks;

import java.util.TreeSet;

// 2605. Form Smallest Number From Two Digit Arrays
public class a2605 {

    /*
    Given two arrays of unique digits nums1 and nums2,
    return the smallest number that contains at least one digit from each array.
     */

    public static void main(String[] args) {
        int[] a = {4, 1, 3};
        int[] b = {5, 7};
        System.out.println(minNumber(a, b));
    }

    // BEATS 100%
    public static int minNumber(int[] nums1, int[] nums2) {
        int[] a = new int[10];
        int min1 = nums1[0];
        int min2 = nums2[0];
        for (int x : nums1) {
            a[x]++;
            min1 = Math.min(min1, x);
        }
        for (int x : nums2) {
            a[x]++;
            min2 = Math.min(min2, x);
        }
        for (int i = 1; i < 10; i++) {
            if (a[i] == 2) {
                return i;
            }
        }
        if (min1 < min2) {
            return min1 * 10 + min2;
        }
        return min2 * 10 + min1;
    }

    // BEATS 87%
    public static int minNumber3(int[] nums1, int[] nums2) {
        int min = 100;
        for (int i : nums1) {
            for (int j : nums2) {
                if (i == j) {
                    min = Math.min(min, i);
                    continue;
                }
                if (i > j) min = Math.min(min, j * 10 + i);
                else min = Math.min(min, i * 10 + j);
            }
        }
        return min;
    }

    // BEATS 37%
    public int minNumber2(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums1) {
            for (int j : nums2) {
                if (i == j) {
                    set.add(i);
                    continue;
                }
                if (i > j) {
                    set.add(j * 10 + i);
                } else set.add(i * 10 + j);
            }
        }
        return set.first();
    }

    // BEATS 18%
    public static int minNumber1(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums1) {
            for (int j : nums2) {
                if (i == j) set.add(i);
                if (i > j) set.add(j * 10 + i);
                else set.add(i * 10 + j);
            }
        }
        return set.first();
    }
}