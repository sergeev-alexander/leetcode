package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.List;

// 2215. Find the Difference of Two Arrays
public class a2215 {

    /*
    Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
    answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
    answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
    Note that the integers in the lists may be returned in any order.
     */

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,3};
        int[] nums2 = {1,1,2,2};
        System.out.println(findDifference(nums1, nums2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        boolean[] arr1 = new boolean[2001];
        boolean[] arr2 = new boolean[2001];
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums1) {
            arr1[num + 1000] = true;
        }
        for (int num : nums2) {
            arr2[num + 1000] = true;
        }
        for (int num : nums1) {
            if (!arr2[num + 1000]) {
                list1.add(num);
                arr2[num + 1000] = true;
            }
        }
        for (int num : nums2) {
            if (!arr1[num + 1000]) {
                list2.add(num);
                arr1[num + 1000] = true;
            }
        }
        return List.of(list1, list2);
    }
}