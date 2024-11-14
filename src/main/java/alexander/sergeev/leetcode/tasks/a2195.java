package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 2195. Append K Integers With Minimal Sum
public class a2195 {

    /*
    You are given an integer array nums and an integer k.
    Append k unique positive integers that do not appear in nums to nums such that the resulting total sum is minimum.
    Return the sum of the k integers appended to nums.
     */

    public static void main(String[] args) {
        int[] arr = {1,4,25,10,25};
        int k = 2;
        System.out.println(minimalKSum(arr, k));
    }

    // BEATS 94%
    public static long minimalKSum(int[] nums, int k) {
        int[] sortedNums = new int[nums.length + 2];
        sortedNums[sortedNums.length - 1] = Integer.MAX_VALUE;
        System.arraycopy(nums, 0, sortedNums, 1, nums.length);
        Arrays.sort(sortedNums);
        long sum = 0;
        for (int i = 1; i < sortedNums.length; ++i) {
            int current = sortedNums[i - 1];
            int next = sortedNums[i];
            int count = Math.min(k, next - current - 1);
            if (count <= 0) {
                continue;
            }
            k -= count;
            sum += (long) (current + 1 + current + count) * count / 2;
            if (k == 0) {
                break;
            }
        }
        return sum;
    }
}