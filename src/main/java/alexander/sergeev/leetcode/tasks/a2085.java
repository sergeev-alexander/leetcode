package alexander.sergeev.leetcode.tasks;

import java.util.HashMap;
import java.util.Map;

// 2085. Count Common Words With One Occurrence
public class a2085 {

    /*
    Given two string arrays words1 and words2,
    return the number of strings that appear exactly once in each of the two arrays.
     */

    public static void main(String[] args) {
        String[] words1 = {"a","ab"};
        String[] words2 = {"a","a","a","ab"};
        System.out.println(countWords(words1, words2));
    }

    // BEATS 92%
    public static int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String s : words1) {
            map1.merge(s, 1, Integer::sum);
        }
        for (String s : words2) {
            map2.merge(s, 1, Integer::sum);
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())
                    && entry.getValue() == 1
                    && map2.get(entry.getKey()) == 1) count++;
        }
        return count;
    }

    // BEATS 62%
    public static int countWords1(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String s : words1) {
            map1.merge(s, 1, Integer::sum);
        }
        for (String s : words2) {
            map2.merge(s, 1, Integer::sum);
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (entry.getValue() == 1
                    && map2.containsKey(entry.getKey())
                    && map2.get(entry.getKey()) == 1) count++;
        }
        return count;
    }
}