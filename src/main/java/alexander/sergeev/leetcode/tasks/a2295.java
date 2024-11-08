package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 2295. Replace Elements in an Array
public class a2295 {

    /*
    You are given a 0-indexed array nums that consists of n distinct positive integers.
    Apply m operations to this array, where in the ith operation you replace the number operations[i][0] with operations[i][1].
    It is guaranteed that in the ith operation:
    operations[i][0] exists in nums.
    operations[i][1] does not exist in nums.
    Return the array obtained after applying all the operations.
     */

    public static void main(String[] args) {
        int[] nums = {1,2,4,6};
        int[][] ops = {
                {1, 3},
                {4, 7},
                {6, 1}};
        System.out.println(Arrays.toString(arrayChange(nums, ops)));
    }

    // BEATS 95%
    public static int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int[] operation : operations) {
            int pos = map.remove(operation[0]);
            nums[pos] = operation[1];
            map.put(operation[1], pos);
        }
        return nums;
    }
}