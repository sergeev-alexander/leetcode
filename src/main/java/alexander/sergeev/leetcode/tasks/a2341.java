package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 2341. Maximum Number of Pairs in Array
public class a2341 {

    /*
    You are given a 0-indexed integer array nums. In one operation, you may do the following:
    Choose two integers in nums that are equal.
    Remove both integers from nums, forming a pair.
    The operation is done on nums as many times as possible.
    Return a 0-indexed integer array answer of size 2 where answer[0] is the number of pairs that are formed
    and answer[1] is the number of leftover integers in nums after doing the operation as many times as possible.
     */

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 3, 2, 2};
        System.out.println(Arrays.toString(numberOfPairs(arr)));
    }

    // BEATS 100%
    public static int[] numberOfPairs(int[] nums) {
        int[] arr = new int[101];
        int count = 0;
        int rest = 0;
        for (int num : nums) {
            if (++arr[num] % 2 != 0) rest++;
            else {
                count++;
                rest--;
            }
        }
        return new int[]{count, rest};
    }

    // BEATS 78%
    public static int[] numberOfPairs1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                count++;
                set.remove(num);
            } else set.add(num);
        }
        return new int[]{count, set.size()};
    }
}