package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 524. Longest Word in Dictionary through Deleting
public class a524 {

    /*
    Given a string s and a string array dictionary,
    return the longest string in the dictionary that can be formed by deleting some of the given string characters.
    If there is more than one possible result, return the longest word with the smallest lexicographical order.
    If there is no possible result, return the empty string.
     */

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> list = List.of("ale","apple","monkey","plea");
        System.out.println(findLongestWord(s, list));
    }

    // BEATS 92%
    public static String findLongestWord(String s, List<String> dictionary) {
        char[] arr1 = s.toCharArray();
        List<String> list = new ArrayList<>();
        for (String word : dictionary) {
            char[] arr2 = word.toCharArray();
            int count = 0;
            int pos1 = 0;
            int pos2 = 0;
            while (pos1 < arr1.length && pos2 < arr2.length){
                if (arr1[pos1++] == arr2[pos2]) {
                    count++;
                    pos2++;
                }
            }
            if (count == arr2.length) list.add(word);
        }
        list.sort(Comparator.comparing(String::length).reversed().thenComparing(String::compareTo));
        return list.isEmpty() ? "" : list.get(0);
    }
}