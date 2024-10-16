package alexander.sergeev.leetcode.tasks;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 2869. Minimum Operations to Collect Elements
public class a2869 {

    /*
    You are given an array nums of positive integers and an integer k.
    In one operation, you can remove the last element of the array and add it to your collection.
    Return the minimum number of operations needed to collect elements 1, 2, ..., k.
     */

    public static void main(String[] args) {
        List<Integer> nums = List.of(3,1,5,4,2);
        int k = 5;
        System.out.println(minOperations(nums, k));
    }

    // BEATS 47%
    public static int minOperations(List<Integer> nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= k; i++) {
            set.add(i);
        }
        Set<Integer> result = new HashSet<>();
        int count = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (result.containsAll(set)) {
                return count;
            }
            result.add(nums.get(i));
            count++;
        }
        return count;
    }
}