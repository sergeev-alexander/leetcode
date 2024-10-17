package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;
import java.util.List;

// 2824. Count Pairs Whose Sum is Less than Target
public class a2824 {

    /*
    Given a 0-indexed integer array nums of length n and an integer target,
    return the number of pairs (i, j) where 0 <= i < j < n and nums[i] + nums[j] < target.
     */

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-6, 2, 5, -2, -7, -1, 3);
        int targ = -2;
        System.out.println(countPairs(list, targ));
    }

    // BEATS 93%
    public static int countPairs(List<Integer> nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target)
                    count++;
            }
        }
        return count;
    }
}