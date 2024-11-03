package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

// 2418. Sort the People
public class a2418 {

    /*
    You are given an array of strings names, and an array heights that consists of distinct positive integers.
    Both arrays are of length n.
    For each index i, names[i] and heights[i] denote the name and height of the ith person.
    Return names sorted in descending order by the people's heights.
     */

    public static void main(String[] args) {
        int[] h = {180,165,170};
        String[] n = {"Mary","John","Emma"};
        System.out.println(Arrays.toString(sortPeople(n, h)));
    }

    // BEATS 100%
    public static String[] sortPeople(String[] names, int[] heights) {
        quickSort(heights, names, 0, heights.length - 1);
        return names;
    }

    public static void quickSort(int[] heights, String[] names, int leftIndex, int rightIndex) {
        if (heights.length == 0 || leftIndex >= rightIndex) return;
        int pivot = heights[(leftIndex + rightIndex) / 2];
        int leftMarkerIndex = leftIndex;
        int rightMarkerIndex = rightIndex;
        while (leftMarkerIndex <= rightMarkerIndex) {
            while (heights[leftMarkerIndex] > pivot) leftMarkerIndex++;
            while (heights[rightMarkerIndex] < pivot) rightMarkerIndex--;
            if (leftMarkerIndex <= rightMarkerIndex) {
                int temp = heights[leftMarkerIndex];
                String tempName = names[leftMarkerIndex];
                heights[leftMarkerIndex] = heights[rightMarkerIndex];
                names[leftMarkerIndex] = names[rightMarkerIndex];
                heights[rightMarkerIndex] = temp;
                names[rightMarkerIndex] = tempName;
                leftMarkerIndex++;
                rightMarkerIndex--;
            }
        }
        if (leftIndex < rightMarkerIndex) quickSort(heights, names, leftIndex, rightMarkerIndex);
        if (rightIndex > leftMarkerIndex) quickSort(heights, names, leftMarkerIndex, rightIndex);
    }

    // BEATS 49%
    public static String[] sortPeople1(String[] names, int[] heights) {
        TreeMap<Integer, String> map = new TreeMap<>(Comparator.comparingInt(Integer::intValue).reversed());
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        return map.values().toArray(String[]::new);
    }
}