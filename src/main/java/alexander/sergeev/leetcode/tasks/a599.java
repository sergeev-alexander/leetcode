package alexander.sergeev.leetcode.tasks;

import java.util.*;

// 599. Minimum Index Sum of Two Lists
public class a599 {

    /*
    Given two arrays of strings list1 and list2, find the common strings with the least index sum.
    A common string is a string that appeared in both list1 and list2.
    A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j]
    then i + j should be the minimum value among all the other common strings.
    Return all the common strings with the least index sum. Return the answer in any order.
     */

    public static void main(String[] args) {

        String[] a = {"happy", "sad", "good"};
        String[] b = {"sad", "happy", "good"};

        System.out.println(Arrays.toString(findRestaurant(a, b)));

    }

    // COULD BE A BIT FASTER...
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        List<String> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) {
                int sum = map1.get(list2[i]) + i;
                if (sum < min) {
                    min = sum;
                    list.clear();
                    list.add(list2[i]);
                } else if (sum == min) {
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(String[]::new);
    }

    public static String[] findRestaurant_A_BIT_FASTER(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) {
                int sum = map1.get(list2[i]) + i;
                map2.put(list2[i], sum);
                if (sum < min) {
                    min = sum;
                }
            }
        }
        int finalMin = min;
        return map2.entrySet().stream()
                .filter(e -> e.getValue() == finalMin)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }

    public static String[] findRestaurant_SLOW(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (map.containsKey(list1[i])) {
                        if (map.get(list1[i]) > i + j) {
                            map.put(list1[i], i + j);
                        }
                    } else {
                        map.put(list1[i], i + j);
                    }
                }
            }
        }
        int min = map.values().stream().min(Comparator.naturalOrder()).get();
        return map.entrySet().stream()
                .filter(e -> e.getValue() == min)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }
}
