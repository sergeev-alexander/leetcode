package alexander.sergeev.leetcode.tasks;

import java.util.HashMap;
import java.util.Map;

// 2404. Most Frequent Even Element
public class a2404 {

    /*
    Given an integer array nums, return the most frequent even element.
    If there is a tie, return the smallest one. If there is no such element, return -1.
     */

    public static void main(String[] args) {
        int[] h = {0,1,2,2,4,4,1};
        System.out.println(mostFrequentEven(h));
    }

    // BEATS 92%
    public static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean wasEven = false;
        for (int num : nums) {
            if (num % 2 == 0) {
                map.merge(num, 1, Integer::sum);
                wasEven = true;
            }
        }
        int maxVal = 0;
        int minKey = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxVal) {
                minKey = entry.getKey();
                maxVal = entry.getValue();
            } else if (entry.getValue() == maxVal) {
                minKey = Math.min(minKey, entry.getKey());
            }
        }
        return wasEven ? minKey : -1;
    }
}