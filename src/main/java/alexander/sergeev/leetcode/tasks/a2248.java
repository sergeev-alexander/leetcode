package alexander.sergeev.leetcode.tasks;

import java.util.*;

// 2248. Intersection of Multiple Arrays
public class a2248 {

    /*
    Given a 2D integer array nums where nums[i] is a non-empty array of distinct positive integers,
    return the list of integers that are present in each array of nums sorted in ascending order.
     */

    public static void main(String[] args) {
        int[][] arr = {{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};
        System.out.println(intersection(arr));
    }

    // BEATS 100%
    public static List<Integer> intersection(int[][] nums) {
        int[] freqArr = new int[1001];
        List<Integer> list = new ArrayList<>();
        for (int[] arr : nums) {
            for (int num : arr) {
                if (++freqArr[num] == nums.length) {
                    list.add(num);
                }
            }
        }
        list.sort(Comparator.naturalOrder());
        return list;
    }

    // BEATS 29%
    public static List<Integer> intersection1(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        for (int[] arr : nums) {
            for (int num : arr) {
                map.merge(num, 1, Integer::sum);
                if (map.get(num) == nums.length) {
                    set.add(num);
                }
            }
        }
        return new ArrayList<>(set);
    }
}