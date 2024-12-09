package alexander.sergeev.leetcode.tasks;

import java.util.HashMap;
import java.util.Map;

// 525. Contiguous Array
public class a525 {

    /*
    Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
     */

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 0, 1, 0, 0, 0, 0, 0};
        System.out.println(findMaxLength(nums));
    }

    // BEATS 55%
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) sum++;
            else sum--;
            if (map.containsKey(sum)) maxLength = Math.max(maxLength, i - map.get(sum));
            else map.put(sum, i);
        }
        return maxLength;
    }
}