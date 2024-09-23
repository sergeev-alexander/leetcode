package alexander.sergeev;

import java.util.*;

public class Temp {

    public static void main(String[] args) {

        int[] nums = {100,4,200,1,3,2};

        System.out.println(longestConsecutive(nums));
    }

    private static boolean arrayContains(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }

    public static int longestConsecutive(int[] nums) {
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
}

