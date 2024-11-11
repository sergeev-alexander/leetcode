package alexander.sergeev.leetcode.tasks;

import java.util.HashMap;
import java.util.Map;

// 2244. Minimum Rounds to Complete All Tasks
public class a2244 {

    /*
    You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task.
    In each round, you can complete either 2 or 3 tasks of the same difficulty level.
    Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.
     */

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        System.out.println(minimumRounds(arr));
    }

    // BEATS 96%
    public static int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tasks) {
            map.merge(i, 1, Integer::sum);
        }
        int count = 0;
        for (int i : map.values()) {
            if (i == 1) return -1;
            if (i >= 3) {
                count += i / 3;
                if (i % 3 > 0) count++;
            } else count++;
        }
        return count;
    }
}