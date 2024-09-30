package alexander.sergeev.leetcode.tasks;

// 11. Container With Most Water
public class a11 {

    /*
    You are given an integer array height of length n.
    There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    Return the maximum amount of water a container can store.
     */

    public static void main(String[] args) {

        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(nums));

    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            max = Math.max(min * (right - left), max);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}