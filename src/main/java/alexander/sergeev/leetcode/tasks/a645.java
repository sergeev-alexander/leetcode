package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 645. Set Mismatch
public class a645 {

    /*
    You have a set of integers s, which originally contains all the numbers from 1 to n.
    Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
    which results in repetition of one number and loss of another number.
    You are given an integer array nums representing the data status of this set after the error.
    Find the number that occurs twice and the number that is missing and return them in the form of an array.
     */

    public static void main(String[] args) {
        int[] arr = {3,3,1};
        System.out.println(Arrays.toString(findErrorNums(arr)));
    }

    // BEATS 95%
    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] result = new int[2];
        int[] arr = new int[10_001];
        for (int num : nums) {
            if (++arr[num] == 2) {
                result[0] = num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                result[1] = i;
                return result;
            }
        }
        return result;
    }
}