package alexander.sergeev.leetcode.tasks;

import java.util.HashSet;
import java.util.Set;

// 2540. Minimum Common Value
public class a2540 {

    /*
    Given two integer arrays nums1 and nums2, sorted in non-decreasing order,
    return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.
    Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.
     */

    public static void main(String[] args) {
        int[] num1 = {1,2,3,6};
        int[] num2 = {2,3,4,5};
        System.out.println(getCommon(num1, num2));
    }

    // BEATS 15%
    public static int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set  = new HashSet<>();
        for(int n : nums1) set.add(n);
        int min = Integer.MAX_VALUE;
        for (int n : nums2)
            if (set.contains(n) && min > n) min = n;
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}