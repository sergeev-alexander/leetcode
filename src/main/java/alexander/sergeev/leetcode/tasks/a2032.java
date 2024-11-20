package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 2032. Two Out of Three
public class a2032 {

    /*
    Given three integer arrays nums1, nums2, and nums3, return a distinct array
    containing all the values that are present in at least two out of the three arrays.
    You may return the values in any order.
     */

    public static void main(String[] args) {
        int[] n1 = {3, 1};
        int[] n2 = {2, 3};
        int[] n3 = {1, 2};
        System.out.println(twoOutOfThree(n1, n2, n3));
    }

    // BEATS 100%
    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] arr = new int[101];
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) arr[num] = 1;
        for (int num : nums2) {
            if (arr[num] == 3 || arr[num] == 2) continue;
            if (arr[num] == 1) {
                list.add(num);
                arr[num] = 3;
            }
            if (arr[num] == 0) arr[num] = 2;
        }
        for (int num : nums3) {
            if (arr[num] == 3) continue;
            if (arr[num] == 1 || arr[num] == 2) {
                list.add(num);
                arr[num] = 3;
            }
        }
        return list;
    }

    // BEATS 77%
    public static List<Integer> twoOutOfThree1(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) map.put(num, 1);
        for (int num : nums2) {
            if (map.containsKey(num)) {
                if (map.get(num) == 3) continue;
                if (map.get(num) == 1) {
                    list.add(num);
                    map.put(num, 3);
                } else map.put(num, 2);
            } else map.put(num, 2);
        }
        for (int num : nums3) {
            if (map.containsKey(num)) {
                if (map.get(num) == 3) continue;
                if (map.get(num) == 2 || map.get(num) == 1) {
                    list.add(num);
                    map.put(num, 3);
                }
            }
        }
        return list;
    }
}