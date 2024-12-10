package alexander.sergeev.leetcode.tasks;

import java.lang.management.MonitorInfo;

// 540. Single Element in a Sorted Array
public class a540 {

    /*
    You are given a sorted array consisting of only integers where every element appears exactly twice,
    except for one element which appears exactly once.
    Return the single element that appears only once.
    Your solution must run in O(log n) time and O(1) space.
     */

    public static void main(String[] args) {
        int[] nums = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(singleNonDuplicate(nums));
    }

    // BEATS 100%
    public static int singleNonDuplicate(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex < rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            int adjacentIndex = midIndex % 2 == 0 ? midIndex + 1 : midIndex - 1;
            if (nums[midIndex] == nums[adjacentIndex]) leftIndex = midIndex + 1;
            else rightIndex = midIndex;
        }
        return nums[leftIndex];
    }

    // BEATS 26%
    public static int singleNonDuplicate1(int[] nums) {
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            } else {
                if (count == 1) return num;
                else {
                    num = nums[i];
                    count = 1;
                }
            }
        }
        return -1;
    }
}