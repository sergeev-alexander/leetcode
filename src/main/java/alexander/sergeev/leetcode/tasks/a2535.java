package alexander.sergeev.leetcode.tasks;

// 2535. Difference Between Element Sum and Digit Sum of an Array
public class a2535 {

    /*
    You are given a positive integer array nums.
    The element sum is the sum of all the elements in nums.
    The digit sum is the sum of all the digits (not necessarily distinct) that appear in nums.
    Return the absolute difference between the element sum and digit sum of nums.
    Note that the absolute difference between two integers x and y is defined as |x - y|.
     */

    public static void main(String[] args) {
        int[] nums = {1,15,6,3};
        System.out.println(differenceOfSum(nums));
    }

    // BEATS 99%
    public static int differenceOfSum(int[] nums) {
        int elSum = 0;
        int digSum = 0;
        for (int num : nums) {
            elSum += num;
            while (num > 0) {
                digSum += num % 10;
                num /= 10;
            }
        }
        return Math.abs(elSum - digSum);
    }

    // BEATS 6%
    public static int differenceOfSum1(int[] nums) {
        int elSum = 0;
        int digSum = 0;
        for (int num : nums) {
            int size = (int) Math.log10(num);
            if (size < 1) continue;
            elSum += num;
            while (size > 0) {
                int div = (int) Math.pow(10, size--);
                digSum += num / div;
                num %= div;
            }
            digSum += num % 10;
        }
        return Math.abs(elSum - digSum);
    }
}