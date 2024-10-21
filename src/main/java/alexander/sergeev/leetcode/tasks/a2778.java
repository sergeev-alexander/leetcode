package alexander.sergeev.leetcode.tasks;

// 2778. Sum of Squares of Special Elements
public class a2778 {

    /*
    You are given a 1-indexed integer array nums of length n.
    An element nums[i] of nums is called special if i divides n, i.e. n % i == 0.
    Return the sum of the squares of all special elements of nums.
     */

    public static void main(String[] args) {
        int[] arr = {2, 7, 1, 19, 18, 3};
        System.out.println(sumOfSquares(arr));
    }

    // BEATS 100%
    public static int sumOfSquares(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (length % (i + 1) == 0) {
                sum += num * num;
            }
        }
        return sum;
    }
}