package alexander.sergeev.leetcode.tasks;

public class a128_NO_SOLUTION {

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println(longestConsecutive_SLOW(nums));
    }

    public static int longestConsecutive_SLOW(int[] nums) {
        int longestStreak = 0;
        for (int num : nums) {
            int currentNum = num;
            int currentStreak = 1;
            while (arrayContains(nums, currentNum + 1)) {
                currentNum += 1;
                currentStreak += 1;
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }
        return longestStreak;
    }

    private static boolean arrayContains(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }
}