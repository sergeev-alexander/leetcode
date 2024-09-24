package alexander.sergeev.leetcode.tasks;

// 152. Maximum Product Subarray
public class a152 {

    /*
    Given an integer array nums, find a subarray that has the largest product, and return the product.
     */

    public static void main(String[] args) {

        int[] nums = {2,3,-2,4};

        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 1;
            for (int j = i; j < nums.length; j++) {
                sum *= nums[j];
                result = Math.max(result, sum);
            }
        }
        return result;
    }
}
