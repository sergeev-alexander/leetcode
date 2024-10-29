package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 2488. Count Subarrays With Median K
public class a2488 {

    /*
    You are given an array nums of size n consisting of distinct integers from 1 to n and a positive integer k.
    Return the number of non-empty subarrays in nums that have a median equal to k.
    Note:
    The median of an array is the middle element after sorting the array in ascending order.
    If the array is of even length, the median is the left middle element.
    For example, the median of [2,3,1,4] is 2, and the median of [8,4,3,5,1] is 4.
    A subarray is a contiguous part of an array.
     */

    public static void main(String[] args) {
        int[] arr = {3,2,1,4,5};
        int k = 4;
        System.out.println(countSubarrays(arr, k));
    }

    // BEATS 100%
    public static int countSubarrays(int[] nums, int k) {
        int length = nums.length;
        int pos = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == k) {
                pos = i;
                break;
            }
        }
        int[] arr = new int[length * 2 + 1];
        int answer = 1;
        int count = 0;
        for (int i = pos + 1; i < length; i++) {
            count += nums[i] > k ? 1 : -1;
            if (count >= 0 && count <= 1) {
                answer++;
            }
            arr[count + length]++;
        }
        count = 0;
        for (int i = pos - 1; i >= 0; i--) {
            count += nums[i] > k ? 1 : -1;
            if (count >= 0 && count <= 1) {
                answer++;
            }
            answer += arr[-count + length] + arr[-count + 1 + length];
        }
        return answer;
    }

    // TLE
    public static int countSubarrays1(int[] nums, int k) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) pos = i;
        }
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > pos) break;
            for (int j = i + 1; j < nums.length; j++) {
                int[] arr = Arrays.copyOfRange(nums, i, j + 1);
                Arrays.sort(arr);
                if (arr.length == 2) {
                    if (arr[0] == k) {
                        count++;
                    }
                    continue;
                }
                if (arr.length == 3) {
                    if (arr[1] == k) {
                        count++;
                    }
                    continue;
                }
                if (arr.length % 2 == 0) {
                    if (arr[arr.length / 2 - 1] == k) count++;
                } else {
                    if (arr[arr.length / 2] == k) count++;
                }
            }
        }
        return count;
    }
}