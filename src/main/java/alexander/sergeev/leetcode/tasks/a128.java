package alexander.sergeev.leetcode.tasks;

import java.util.HashSet;
import java.util.Set;

// 128. Longest Consecutive Sequence
public class a128 {

    /*
    Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
    You must write an algorithm that runs in O(n) time.
     */

    public static void main(String[] args) {
        int[] arr = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(arr));
    }

    // BEATS 67%
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxCount = 0;
        int count = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                count++;
                while (set.contains(num + 1)) {
                    num++;
                    count++;
                }
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        return maxCount;
    }
}