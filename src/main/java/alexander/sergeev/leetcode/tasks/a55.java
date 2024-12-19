package alexander.sergeev.leetcode.tasks;

// 55. Jump Game
public class a55 {

    /*
    You are given an integer array nums. You are initially positioned at the array's first index,
    and each element in the array represents your maximum jump length at that position.
    Return true if you can reach the last index, or false otherwise.
     */

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(canJump(arr));
    }

    // BEATS 47%
    public static boolean canJump(int[] nums) {
        int maxReachable = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (maxReachable < i) {
                return false;
            }
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }
        return true;
    }
}
