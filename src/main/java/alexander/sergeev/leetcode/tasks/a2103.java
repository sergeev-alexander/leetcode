package alexander.sergeev.leetcode.tasks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 2103. Rings and Rods
public class a2103 {

    /*
    There are n rings and each ring is either red, green, or blue. The rings are distributed across ten rods labeled from 0 to 9.
    You are given a string rings of length 2n that describes the n rings that are placed onto the rods.
    Every two characters in rings forms a color-position pair that is used to describe each ring where:
    The first character of the ith pair denotes the ith ring's color ('R', 'G', 'B').
    The second character of the ith pair denotes the rod that the ith ring is placed on ('0' to '9').
    For example, "R3G2B1" describes n == 3 rings: a red ring placed onto the rod labeled 3,
    a green ring placed onto the rod labeled 2, and a blue ring placed onto the rod labeled 1.
    Return the number of rods that have all three colors of rings on them.
     */

    public static void main(String[] args) {
        String s = "B0B6G0R6R0R6G9";
        System.out.println(countPoints(s));
    }

    // BEATS 100%
    public static int countPoints(String rings) {
        int[][] rodArr = new int[10][3];
        boolean[] isComplete = new boolean[10];
        char[] arr = rings.toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length - 1; i += 2) {
            int rod = Character.getNumericValue(arr[i + 1]);
            if (isComplete[rod]) continue;
            char ch = arr[i];
            switch (ch) {
                case 'R' -> rodArr[rod][0] = 1;
                case 'G' -> rodArr[rod][1] = 1;
                case 'B' -> rodArr[rod][2] = 1;
            }
            if (rodArr[rod][0] == 1 && rodArr[rod][1] == 1 && rodArr[rod][2] == 1) {
                count++;
                isComplete[rod] = true;
            }
        }
        return count;
    }


    // BEATS 59%
    public static int countPoints1(String rings) {
        Map<Integer, Set<Character>> map = new HashMap<>();
        Set<Integer> rodSet = new HashSet<>();
        char[] arr = rings.toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length - 1; i += 2) {
            int rod = Character.getNumericValue(arr[i + 1]);
            if (rodSet.contains(rod)) continue;
            if (map.containsKey(rod)) {
                map.get(rod).add(arr[i]);
                if (map.get(rod).size() == 3) {
                    count++;
                    rodSet.add(rod);
                }
            } else {
                Set<Character> set = new HashSet<>();
                set.add(arr[i]);
                map.put(rod, set);
            }
        }
        return count;
    }
}