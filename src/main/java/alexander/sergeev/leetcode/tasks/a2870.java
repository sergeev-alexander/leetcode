package alexander.sergeev.leetcode.tasks;

import java.util.HashMap;
import java.util.Map;

// 2870. Minimum Number of Operations to Make Array Empty
public class a2870 {

    /*
    You are given a 0-indexed array nums consisting of positive integers.
    There are two types of operations that you can apply on the array any number of times:
    Choose two elements with equal values and delete them from the array.
    Choose three elements with equal values and delete them from the array.
    Return the minimum number of operations required to make the array empty, or -1 if it is not possible.
     */

    public static void main(String[] args) {
        int[] arr = {19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19};
        System.out.println(minOperations(arr));
    }

    // BEATS 90%
    public static int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int count = 0;
        for (int value : map.values()) {
            if (value == 1) return -1;
            while (value > 0) {
                if (value == 1) return -1;
                else if (value == 2 || value == 3) {
                    count++;
                    break;
                } else if (value == 4) {
                    count += 2;
                    break;
                } else if (value % 3 == 0) {
                    count += value / 3;
                    break;
                } else {
                    value -= 3;
                    count++;
                }
            }
        }
        return count;
    }

    // BEATS 85%
    public static int minOperations1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int count = 0;
        for (int value : map.values()) {
            if (value == 1) return -1;
            while (value > 0) {
                if (value == 1) return -1;
                else if (value == 2) {
                    count++;
                    break;
                } else if (value == 3) {
                    count++;
                    break;
                } else if (value == 4) {
                    count += 2;
                    break;
                } else {
                    value -= 3;
                    count++;
                }
            }
        }
        return count;
    }
}