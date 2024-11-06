package alexander.sergeev.leetcode.tasks;

public class a2335 {

    /*
    You have a water dispenser that can dispense cold, warm, and hot water.
    Every second, you can either fill up 2 cups with different types of water, or 1 cup of any type of water.
    You are given a 0-indexed integer array amount of length 3 where amount[0], amount[1],
    and amount[2] denote the number of cold, warm, and hot water cups you need to fill respectively.
    Return the minimum number of seconds needed to fill up all the cups.
     */

    public static void main(String[] args) {
        int[] arr = {5,4,4};
        System.out.println(fillCups(arr));
    }

    // BEATS 100%
    public static int fillCups(int[] amount) {
        int first = amount[0];
        int second = amount[1];
        int third = amount[2];
        int count = 0;
        while (first > 0 || second > 0 || third > 0) {
            if (first >= second && first >= third) {
                first--;
                if (second >= third) second--;
                else third--;
            } else if (second >= first && second >= third) {
                second--;
                if (first >= third) first--;
                else third--;
            } else {
                third--;
                if (first >= second) first--;
                else second--;
            }
            count++;
        }
        return count;
    }
}