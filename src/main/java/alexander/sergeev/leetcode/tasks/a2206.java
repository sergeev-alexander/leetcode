package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 2206. Divide Array Into Equal Pairs
public class a2206 {

    /*
    You are given an integer array nums consisting of 2 * n integers.
    You need to divide nums into n pairs such that:
    Each element belongs to exactly one pair.
    The elements present in a pair are equal.
    Return true if nums can be divided into n pairs, otherwise return false.
     */

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 1, 1};
        System.out.println(divideArray(arr));
    }

    // BEATS 100%
    public static boolean divideArray(int[] nums) {
        int[] arr = new int[501];
        int count = 0;
        for (int num : nums) {
            if (arr[num] == 0) {
                arr[num]++;
                count++;
            } else if (arr[num] == 1) {
                arr[num]--;
                count--;
            }
        }
        return count == 0;
    }

    // BEATS 81%
    public static boolean divideArray3(int[] nums) {
        boolean[] arr = new boolean[501];
        int count = 0;
        for (int num : nums) {
            if (count < -1) return false;
            if (arr[num]) count--;
            else count++;
            arr[num] = !arr[num];
        }
        return count == 0;
    }

    // BEATS 77%
    public static boolean divideArray2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0, j = 1; j < nums.length; i += 2, j += 2) {
            if (nums[i] != nums[j]) return false;
        }
        return true;
    }

    // BEATS 81%
    public static boolean divideArray1(int[] nums) {
        boolean[] arr = new boolean[501];
        for (int num : nums) {
            arr[num] = !arr[num];
        }
        for (boolean is : arr) {
            if (is) return false;
        }
        return true;
    }
}