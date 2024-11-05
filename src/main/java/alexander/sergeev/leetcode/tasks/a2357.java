package alexander.sergeev.leetcode.tasks;

import java.util.HashSet;
import java.util.Set;

// 2357. Make Array Zero by Subtracting Equal Amounts
public class a2357 {

    /*
    You are given a non-negative integer array nums. In one operation, you must:
    Choose a positive integer x such that x is less than or equal to the smallest non-zero element in nums.
    Subtract x from every positive element in nums.
    Return the minimum number of operations to make every element in nums equal to 0.
     */

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 0, 3, 5};
        System.out.println(minimumOperations(arr1));
    }

    // BEATS 97%
    public static int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int num : nums) {
            set.add(num);
        }
        return set.size() - 1;
    }
}