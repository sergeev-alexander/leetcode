package alexander.sergeev.leetcode.tasks;

// 2455. Average Value of Even Numbers That Are Divisible by Three
public class a2455 {

    /*
    Given an integer array nums of positive integers, return the average value of all even integers that are divisible by 3.
    Note that the average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
     */

    public static void main(String[] args) {
        int[] nums = {1,3,6,10,12,15};
        System.out.println(averageValue(nums));
    }

    // BEATS 100%
    public static int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int n : nums) {
            if (n > 5 && n % 6 == 0) {
                sum+=n;
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }
}