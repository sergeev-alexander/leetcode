package alexander.sergeev.leetcode.tasks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// 739. Daily Temperatures
public class a739 {

    /*
    Given an array of integers temperatures represents the daily temperatures,
    return an array answer such that answer[i] is the number of days you have to wait after the ith day
    to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
     */

    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(arr)));
    }

    // BEATS 85%
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] arr = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int currentPos = 1; currentPos < n; currentPos++) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[currentPos]) {
                    int prevPos = stack.pop();
                    arr[prevPos] = currentPos - prevPos;
                }
                stack.push(currentPos);
            }
        }
        return arr;
    }

    // TLE
    public static int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        int[] arr = new int[n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    arr[i] = j - i;
                    break;
                }
            }
        }
        return arr;
    }
}