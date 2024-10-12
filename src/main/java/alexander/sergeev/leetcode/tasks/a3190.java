package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 3190. Find Minimum Operations to Make All Elements Divisible by Three
public class a3190 {

    /*
    You are given an integer array nums. In one operation, you can add or subtract 1 from any element of nums.
    Return the minimum number of operations to make all elements of nums divisible by 3.
     */

    public static void main(String[] args) {

        int[] arr = {1,2,3,4};
        System.out.println(minimumOperations(arr));
    }

    public static int minimumOperations(int[] nums) {
        return (int) Arrays.stream(nums)
                .filter(i -> i % 3 != 0)
                .count();
    }
}
