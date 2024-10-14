package alexander.sergeev.leetcode.tasks;

// 3115. Maximum Prime Difference
public class a3115 {

    /*
    Return an integer that is the maximum distance between the indices of two (not necessarily different) prime numbers in nums.
     */

    public static void main(String[] args) {

        int[] s = {4,2,9,5,3};
        System.out.println(maximumPrimeDifference(s));
    }

    // BEATS 99%
    public static int maximumPrimeDifference(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (isPrime(nums[left]) && isPrime(nums[right]))
                return right - left;
            if (!isPrime(nums[left])) left++;
            if (!isPrime(nums[right])) right--;
        }
        return 0;
    }

    public static int maximumPrimeDifference_BEATS_48_PERCENT(int[] nums) {
        int minPos = nums.length - 1;
        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i])) {
                if (i < minPos) minPos = i;
                if (i > maxPos) maxPos = i;
            }
        }
        return maxPos - minPos;
    }

    private static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        if (num == 2 || num == 3)
            return true;
        if (num % 2 == 0 || num % 3 == 0)
            return false;
        for (int i = 5; i <= Math.sqrt(num); i += 6)
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        return true;
    }
}
