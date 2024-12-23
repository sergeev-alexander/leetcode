package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.List;

// 2788. Split Strings by Separator
public class a2788 {

    /*
    Given an array of strings words and a character separator, split each string in words by separator.
    Return an array of strings containing the new strings formed after the splits, excluding empty strings.
    Notes
    separator is used to determine where the split should occur, but it is not included as part of the resulting strings.
    A split may result in more than two strings.
    The resulting strings must maintain the same order as they were initially given.
     */

    public static void main(String[] args) {
        List<String> words = List.of("$easy$","$problem$");
        char sep = '$';
        System.out.println(splitWordsBySeparator(words, sep));
    }

    // BEATS 98%
    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            int start = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == separator) {
                    if (i > start) {
                        list.add(word.substring(start, i));
                    }
                    start = i + 1;
                }
            }
            if (start < word.length()) {
                list.add(word.substring(start));
            }
        }
        return list;
    }

    // BEATS 93%
    public static List<String> splitWordsBySeparator1(List<String> words, char separator) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char ch : word.toCharArray()) {
                if (ch == separator) {
                    if (!stringBuilder.isEmpty()) {
                        list.add(stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                    }
                } else stringBuilder.append(ch);
            }
            if (!stringBuilder.isEmpty()) {
                list.add(stringBuilder.toString());
            }
        }
        return list;
    }
}