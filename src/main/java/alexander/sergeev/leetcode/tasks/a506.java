package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 506. Relative Ranks
public class a506 {

    /*
    You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition.
    All the scores are guaranteed to be unique.
    The athletes are placed based on their scores, where the 1st place athlete has the highest score,
    the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:
    The 1st place athlete's rank is "Gold Medal".
    The 2nd place athlete's rank is "Silver Medal".
    The 3rd place athlete's rank is "Bronze Medal".
    For the 4th place to the nth place athlete,
    their rank is their placement number (i.e., the xth place athlete's rank is "x").
    Return an array answer of size n where answer[i] is the rank of the ith athlete.
     */

    public static void main(String[] args) {
        int[] arr = {10, 3, 8, 9, 4};
        System.out.println(Arrays.toString(findRelativeRanks(arr)));
    }

    // BEATS 11%
    public static String[] findRelativeRanks(int[] score) {
        int[] arr = Arrays.copyOf(score, score.length);
        Arrays.sort(arr);
        String[] result = new String[score.length];
        int pos = 0;
        for (int k : score) {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] == k) {
                    if (i == arr.length - 1) {
                        result[pos++] = "Gold Medal";
                        break;
                    } else if (i == arr.length - 2) {
                        result[pos++] = "Silver Medal";
                        break;
                    } else if (i == arr.length - 3) {
                        result[pos++] = "Bronze Medal";
                        break;
                    } else {
                        result[pos++] = String.valueOf(arr.length - i);
                        break;
                    }
                }
            }
        }
        return result;
    }
}