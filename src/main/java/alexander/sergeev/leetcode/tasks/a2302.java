package alexander.sergeev.leetcode.tasks;

// 2302. Count Subarrays With Score Less Than K
public class a2302 {

    /*
    The score of an array is defined as the product of its sum and its length.
    For example, the score of [1, 2, 3, 4, 5] is (1 + 2 + 3 + 4 + 5) * 5 = 75.
    Given a positive integer array nums and an integer k, return the number of non-empty subarrays of nums
    whose score is strictly less than k.
    A subarray is a contiguous sequence of elements within an array.
     */

    public static void main(String[] args) {
        int[] nums = {353, 217, 672, 408, 6, 322, 536, 59, 129, 141, 771, 955, 871, 912, 684, 181, 962, 211, 277,
                724, 856, 220, 942, 265, 634, 240, 375, 753, 734, 895, 517, 949, 35};
        int k = 797;
        System.out.println(countSubarrays(nums, k));
    }

    // BEATS 100%
    public static long countSubarrays(int[] nums, long k) {
        long count = 0;
        long sum = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum * (end - start + 1) >= k) {
                sum -= nums[start];
                start++;
            }
            count += end - start + 1;
        }
        return count;
    }

    // TLE
    public static long countSubarrays1(int[] nums, long k) {
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) count++;
            else continue;
            if (nums[i] * 2L >= k) continue;
            long tempCount = 2L;
            long sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= k) break;
                if ((nums[j] + sum) * tempCount < k) {
                    tempCount++;
                    sum += nums[j];
                    count++;
                } else break;
            }
        }
        return count;
    }
}