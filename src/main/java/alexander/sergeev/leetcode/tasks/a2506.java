package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 2506. Count Pairs Of Similar Strings
public class a2506 {

    /*
    You are given a 0-indexed string array words.
    Two strings are similar if they consist of the same characters.
    For example, "abca" and "cba" are similar since both consist of characters 'a', 'b', and 'c'.
    However, "abacba" and "bcfd" are not similar since they do not consist of the same characters.
    Return the number of pairs (i, j) such that 0 <= i < j <= word.length - 1
    and the two strings words[i] and words[j] are similar.
     */

    public static void main(String[] args) {
        String[] arr = {"aabb","ab","ba"};
        System.out.println(similarPairs(arr));
    }

    // BEATS 37%
    public static  int similarPairs(String[] words) {
        List<String> list= Arrays.stream(words)
                .map(w -> Arrays.stream(w.split(""))
                        .distinct()
                        .sorted()
                        .collect(Collectors.joining()))
                .toList();
        int count = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }
}