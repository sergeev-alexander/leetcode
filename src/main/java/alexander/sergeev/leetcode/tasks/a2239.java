package alexander.sergeev.leetcode.tasks;

// 2239. Find Closest Number to Zero
public class a2239 {

    /*
    Given an integer array nums of size n, return the number with the value closest to 0 in nums.
    If there are multiple answers, return the number with the largest value.
     */

    public static void main(String[] args) {
        int[] arr = {-1, -4, -2, 1, 4, 8};
        System.out.println(findClosestNumber(arr));
    }

    // BEATS 100%
    public static int findClosestNumber(int[] nums) {
        int result = 100001;
        for (int num : nums) {
            if (num > 0 && num == -result) {
                result = num;
                continue;
            }
            if ((num < 0 ? -num : num) < (result < 0 ? -result : result)) {
                result = num;
            }
        }
        return result;
    }

    // BEATS 89%
    public static int findClosestNumber2(int[] nums) {
        int result = 100001;
        for (int num : nums) {
            if (num == 0) return 0;
            if (Math.abs(num) < Math.abs(result) || num == Math.abs(result)) {
                result = num;
            }
        }
        return result;
    }

    // BEATS 89%
    public static int findClosestNumber1(int[] nums) {
        int minDiff = 100001;
        int maxNum = 100001;
        for (int num : nums) {
            if (num == 0) return 0;
            int diff = Math.abs(num);
            if (diff == minDiff) {
                maxNum = Math.max(maxNum, num);
            }
            if (diff < minDiff) {
                maxNum = num;
                minDiff = diff;
            }
        }
        return maxNum;
    }
}