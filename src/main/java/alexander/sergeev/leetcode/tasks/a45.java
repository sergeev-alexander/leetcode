package alexander.sergeev.leetcode.tasks;

// 45. Jump Game II
public class a45 {

    /*
    You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
    Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
    0 <= j <= nums[i] and i + j < n
    Return the minimum number of jumps to reach nums[n - 1].
    The test cases are generated such that you can reach nums[n - 1].
     */

    public static void main(String[] args) {

        int nums[] = {2, 3, 0, 1, 4};

        System.out.println(jump(nums));

    }

    public static int jump(int[] nums) {
        int length = nums.length;
        if (length == 1)
            return 0;
        int currentPosition = 0;
        int jumps = 0;
        int maxReachability = 0;
        int maxReachabilityIndex = 0;
        for (int i = 0; i < length; i++) {
            if (currentPosition + nums[currentPosition] >= length - 1)
                return jumps + 1;
            if (i > currentPosition + nums[currentPosition]) {
                currentPosition = maxReachabilityIndex;
                jumps++;
            }
            int reachability = i + nums[i];
            if (reachability > maxReachability) {
                maxReachability = reachability;
                maxReachabilityIndex = i;
            }
        }
        return jumps + 1;
    }
}
