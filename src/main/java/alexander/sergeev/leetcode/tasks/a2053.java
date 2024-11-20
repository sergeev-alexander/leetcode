package alexander.sergeev.leetcode.tasks;

import java.util.*;

// 2053. Kth Distinct String in an Array
public class a2053 {

    /*
    A distinct string is a string that is present only once in an array.
    Given an array of strings arr, and an integer k, return the kth distinct string present in arr.
    If there are fewer than k distinct strings, return an empty string "".
    Note that the strings are considered in the order in which they appear in the array.
     */

    public static void main(String[] args) {
        String[] arr = {"d","b","c","b","c","a"};
        int k = 2;
        System.out.println(kthDistinct(arr, k));
    }

    // BEATS 87%
    public static String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String s : arr) {
            map.merge(s, 1, Integer::sum);
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) count++;
            if (count == k) return entry.getKey();
        }
        return "";
    }

    // BEATS 18%
    public static String kthDistinct1(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String s : arr) {
            map.merge(s, 1, Integer::sum);
            if (map.get(s) == 1) {
                list.add(s);
            } else list.remove(s);
        }
        return list.size() < k ? "" : list.get(--k);
    }
}