package alexander.sergeev.leetcode.tasks;

import java.util.HashMap;
import java.util.Map;

// 2475. Number of Unequal Triplets in Array
public class a2475 {

    /*
    You are given a 0-indexed array of positive integers nums.
    Find the number of triplets (i, j, k) that meet the following conditions:
    0 <= i < j < k < nums.length
    nums[i], nums[j], and nums[k] are pairwise distinct.
    In other words, nums[i] != nums[j], nums[i] != nums[k], and nums[j] != nums[k].
    Return the number of triplets that meet the conditions.
     */

    public static void main(String[] args) {
        int[] arr = {4,4,2,4,3};
        System.out.println(unequalTriplets(arr));
    }

    // BEATS 98%
    public static int unequalTriplets(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, (o, n) -> o + 1);
        }
        int res = 0, left = 0, right = nums.length;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            right -= entry.getValue();
            res += right * entry.getValue() * left;
            left += entry.getValue();
        }
        return res;
    }

    // BEATS 64%
    public static int unequalTriplets1(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}