package alexander.sergeev.leetcode.tasks;

// 724. Find Pivot Index
public class a724 {

    /*
    Given an array of integers nums, calculate the pivot index of this array.
    The pivot index is the index where the sum of all the numbers strictly to the left of the index
    is equal to the sum of all the numbers strictly to the index's right.
    If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
    This also applies to the right edge of the array.
    Return the leftmost pivot index. If no such index exists, return -1.
     */

    public static void main(String[] args) {
        int[] nums = {-1,-1,0,0,-1,-1};
        System.out.println(pivotIndex(nums));
    }

    // BEATS 94%
    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] leftSumArr = new int[n];
        int[] rightSumArr = new int[n];
        int sum = 0;
        for (int i = 1; i < n; i++) {
            leftSumArr[i] = sum += nums[i - 1];
        }
        sum = 0;
        for (int i = n - 2; i >= 0; i--) {
            rightSumArr[i] = sum += nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            if (leftSumArr[i] == rightSumArr[i]) {
                return i;
            }
        }
        return -1;
    }
}