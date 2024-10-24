package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 2610. Convert an Array Into a 2D Array With Conditions
public class a2610 {

    /*
    You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:
    The 2D array should contain only the elements of the array nums.
    Each row in the 2D array contains distinct integers.
    The number of rows in the 2D array should be minimal.
    Return the resulting array. If there are multiple answers, return any of them.
    Note that the 2D array can have a different number of elements on each row.
     */

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 1, 2, 3, 1};
        System.out.println(findMatrix(nums));
    }

    // BEATS 73%
    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        list.add(first);
        for (int num : nums) {
            boolean isAdded = false;
            for (List<Integer> list1 : list) {
                if (!list1.contains(num)) {
                    list1.add(num);
                    isAdded = true;
                    break;
                }
            }
            if (!isAdded) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(num);
                list.add(list1);
            }
        }
        return list;
    }

    // BEATS 52%
    public static List<List<Integer>> findMatrix1(int[] nums) {
        List<Set<Integer>> list = new ArrayList<>();
        Set<Integer> first = new HashSet<>();
        list.add(first);
        for (int num : nums) {
            boolean isAdded = false;
            for (Set<Integer> set : list) {
                if (!set.contains(num)) {
                    set.add(num);
                    isAdded = true;
                    break;
                }
            }
            if (!isAdded) {
                Set<Integer> set1 = new HashSet<>();
                set1.add(num);
                list.add(set1);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Set<Integer> set : list) {
            result.add(new ArrayList<>(set));
        }
        return result;
    }
}