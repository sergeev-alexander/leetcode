package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 2099. Find Subsequence of Length K With the Largest Sum
public class a2099 {

    /*
    You are given an integer array nums and an integer k.
    You want to find a subsequence of nums of length k that has the largest sum.
    Return any such subsequence as an integer array of length k.
    A subsequence is an array that can be derived from another array by deleting some or no elements
    without changing the order of the remaining elements.
     */

    public static void main(String[] args) {
        int[] arr = {-1, 2, 1, 0, 3};
        int k = 3;
        System.out.println(Arrays.toString(maxSubsequence(arr, k)));
    }

    // BEATS 100%
    public static int[] maxSubsequence(int[] nums, int k) {
        if (nums.length == k) return nums;
        int[] numsCopy = new int[nums.length];
        System.arraycopy(nums, 0, numsCopy, 0, nums.length);
        int[] positionArray = new int[nums.length];
        for (int i = 0; i < positionArray.length; i++) {
            positionArray[i] = i;
        }
        quickSort(nums, positionArray, 0, nums.length - 1);
        int[] sortedPositionArray = new int[k];
        System.arraycopy(positionArray, positionArray.length - k, sortedPositionArray, 0, sortedPositionArray.length);
        Arrays.sort(sortedPositionArray);
        int[] resultArr = new int[k];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = numsCopy[sortedPositionArray[i]];
        }
        return resultArr;
    }

    public static void quickSort(int[] nums, int[] positionArray, int left, int right) {
        if (nums.length == 0 || left >= right) return;
        int pivot = nums[(left + right) / 2];
        int leftMarker = left;
        int rightMarker = right;
        while (leftMarker <= rightMarker) {
            while (nums[leftMarker] < pivot) leftMarker++;
            while (nums[rightMarker] > pivot) rightMarker--;
            if (leftMarker <= rightMarker) {
                int temp1 = nums[leftMarker];
                int temp2 = positionArray[leftMarker];
                nums[leftMarker] = nums[rightMarker];
                positionArray[leftMarker] = positionArray[rightMarker];
                nums[rightMarker] = temp1;
                positionArray[rightMarker] = temp2;
                leftMarker++;
                rightMarker--;
            }
        }
        if (left < rightMarker) quickSort(nums, positionArray, left, rightMarker);
        if (right > leftMarker) quickSort(nums, positionArray, leftMarker, right);
    }
}