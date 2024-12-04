package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.List;

// 448. Find All Numbers Disappeared in an Array
public class a448 {

    /*
    Given an array nums of n integers where nums[i] is in the range [1, n],
    return an array of all the integers in the range [1, n] that do not appear in nums.
     */

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(arr));
    }

    // BEATS 99%
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] arr = new int[nums.length + 1];
        for (int num : nums) {
            arr[num]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) list.add(i);
        }
        return list;
    }

    // BEATS 88%
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        boolean[] arr = new boolean[nums.length + 1];
        for (int num : nums) {
            arr[num] = true;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i]) list.add(i);
        }
        return list;
    }
}