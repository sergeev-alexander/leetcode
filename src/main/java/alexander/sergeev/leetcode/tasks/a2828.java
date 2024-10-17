package alexander.sergeev.leetcode.tasks;

import java.util.List;
import java.util.stream.Collectors;

// 2828. Check if a String Is an Acronym of Words
public class a2828 {

    /*
    Given an array of strings words and a string s, determine if s is an acronym of words.
    The string s is considered an acronym of words if it can be formed by concatenating the first character
    of each string in words in order. For example, "ab" can be formed from ["apple", "banana"],
    but it can't be formed from ["bear", "aardvark"].
    Return true if s is an acronym of words, and false otherwise.
     */

    public static void main(String[] args) {
        List<String> words = List.of("never","gonna","give","up","on","you");
        String s = "ngguoy";
        System.out.println(isAcronym(words, s));
    }

    // BEATS 100%
    public static boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) {
            return false;
        }
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).charAt(0) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAcronym_BEATS_8_PERCENT(List<String> words, String s) {
        return words.stream()
                .map(w -> w.charAt(0))
                .map(String::valueOf)
                .collect(Collectors.joining(""))
                .equals(s);
    }
}