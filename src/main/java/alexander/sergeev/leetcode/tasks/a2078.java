package alexander.sergeev.leetcode.tasks;

// 2078. Two Furthest Houses With Different Colors
public class a2078 {

    /*
    There are n houses evenly lined up on the street, and each house is beautifully painted.
    You are given a 0-indexed integer array colors of length n, where colors[i] represents the color of the ith house.
    Return the maximum distance between two houses with different colors.
    The distance between the ith and jth houses is abs(i - j), where abs(x) is the absolute value of x.
     */

    public static void main(String[] args) {
        int[] arr = {1,1,1,6,1,1,1};
        System.out.println(maxDistance(arr));
    }

    // BEATS 100%
    public static int maxDistance(int[] colors) {
        int left = 0;
        int right = colors.length - 1;
        while (colors[left] == colors[colors.length - 1]) left++;
        while (colors[0] == colors[right]) right--;
        return Math.max(colors.length - 1 - left, right);
    }

    // BEATS 51%
    public static int maxDistance1(int[] colors) {
        int max = 0;
        for (int i = 0; i < colors.length - 1; i++) {
            for (int j = i + 1; j < colors.length; j++) {
                if (colors[i] != colors[j]) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }
}