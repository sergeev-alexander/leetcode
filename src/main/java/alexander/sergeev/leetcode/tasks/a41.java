package alexander.sergeev.leetcode.tasks;

// 41. First Missing Positive
public class a41 {

    /*
    Given an unsorted integer array nums.
    Return the smallest positive integer that is not present in nums.
    You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
     */

    public static void main(String[] args) {

        int[] nums = {7, 8, 9, 11, 12};

        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int numsLength = nums.length;
        boolean[] seen = new boolean[numsLength + 1];

        for (int num : nums) {
            if (num > 0 && num <= numsLength) {
                seen[num] = true;
            }
        }

        for (int i = 1; i <= numsLength; i++) {
            if (!seen[i]) {
                return i;
            }
        }

        return numsLength + 1;
    }
}
