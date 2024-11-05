package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// 2363. Merge Similar Items
public class a2362 {

    /*
    You are given two 2D integer arrays, items1 and items2, representing two sets of items.
    Each array items has the following properties:
    items[i] = [valuei, weighti] where valuei represents the value and weighti represents the weight of the ith item.
    The value of each item in items is unique.
    Return a 2D integer array ret where ret[i] = [valuei, weighti], with weighti being the sum of weights of all items
    with value valuei.
    Note: ret should be returned in ascending order by value.
     */

    public static void main(String[] args) {
        int[][] arr1 = {{1,1}, {4,5}, {3,8}};
        int[][] arr2 = {{3,1}, {1,5}};
        System.out.println(mergeSimilarItems(arr1, arr2));
    }

    // BEATS 94%
    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] arr = new int[1001];
        for (int[] i : items1) {
            arr[i[0]] = i[1];
        }
        for (int[] i : items2) {
            arr[i[0]] += i[1];
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 0) {
                list.add(List.of(i, arr[i]));
            }
        }
        return list;
    }

    // BEATS 73%
    public static List<List<Integer>> mergeSimilarItems1(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] arr : items1) {
            map.put(arr[0], arr[1]);
        }
        for (int[] arr : items2) {
            map.merge(arr[0], arr[1], Integer::sum);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(List.of(entry.getKey(), entry.getValue()));
        }
        return list;
    }
}