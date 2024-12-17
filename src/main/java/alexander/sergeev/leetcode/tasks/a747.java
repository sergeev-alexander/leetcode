package alexander.sergeev.leetcode.tasks;

// 747. Largest Number At Least Twice of Others
public class a747 {

    /*
    You are given an integer array nums where the largest integer is unique.
    Determine whether the largest element in the array is at least twice as much as every other number in the array.
    If it is, return the index of the largest element, or return -1 otherwise.
     */

    public static void main(String[] args) {
        int[] arr = {1,0};
        System.out.println(dominantIndex(arr));
    }

    // BEATS 100%
    public static int dominantIndex(int[] nums) {
        int maxNum = nums[0];
        int maxNumIndex = 0;
        int maxProduct = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                maxNumIndex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != maxNumIndex) {
                maxProduct = Math.max(maxProduct, nums[i] * 2);
            }
        }
        if (maxNum >= maxProduct) return maxNumIndex;
        else return -1;
    }
}