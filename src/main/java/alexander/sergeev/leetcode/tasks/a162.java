package alexander.sergeev.leetcode.tasks;

// 162. Find Peak Element
public class a162 {

    /*
    A peak element is an element that is strictly greater than its neighbors.
    Given a 0-indexed integer array nums, find a peak element, and return its index.
    If the array contains multiple peaks, return the index to any of the peaks.
    You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always
    considered to be strictly greater than a neighbor that is outside the array.
    You must write an algorithm that runs in O(log n) time.
     */

    public static void main(String[] args) {

        int[] g = {1};

        System.out.println(findPeakElement(g));

    }

    // O(n)
    public static int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int prev = i == 0 ? Integer.MIN_VALUE : nums[i - 1];
            int next = i == nums.length - 1 ? Integer.MIN_VALUE : nums[i + 1];
            if (prev < nums[i] && nums[i] > next) {
                return i;
            }
        }
        return 0;
    }
}

