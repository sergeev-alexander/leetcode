package alexander.sergeev.leetcode.tasks;

// 2529. Maximum Count of Positive Integer and Negative Integer
public class a2529 {

    /*
    Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers
    and the number of negative integers.
    In other words, if the number of positive integers in nums is pos and the number of negative integers is neg,
    then return the maximum of pos and neg.
    Note that 0 is neither positive nor negative.
     */

    public static void main(String[] args) {
        int[] nums = {-2, -1, -1, 0, 0, 0, 1, 2, 3};
        System.out.println(maximumCount(nums));
    }

    // BEATS 100%
    public static int maximumCount(int[] nums) {
        int posCount = 0;
        int negCont = 0;
        int posPos = nums.length - 1;
        int negPos = 0;
        int count = 0;
        while (count < nums.length) {
            if (nums[posPos] > 0) {
                posCount++;
                count++;
            }
            if (nums[negPos] < 0) {
                negCont++;
                count++;
            }
            if (nums[negPos] == 0 || nums[posPos] == 0) {
                count++;
            }
            negPos++;
            posPos--;
        }
        return Math.max(posCount, negCont);
    }
}