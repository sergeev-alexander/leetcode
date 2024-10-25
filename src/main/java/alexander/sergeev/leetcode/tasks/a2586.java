package alexander.sergeev.leetcode.tasks;

import java.util.Set;

// 2586. Count the Number of Vowel Strings in Range
public class a2586 {

    /*
    You are given a 0-indexed array of string words and two integers left and right.
    A string is called a vowel string if it starts with a vowel character and ends with a vowel character
    where vowel characters are 'a', 'e', 'i', 'o', and 'u'.
    Return the number of vowel strings words[i] where i belongs to the inclusive range [left, right].
     */

    public static void main(String[] args) {
        String[] words = {"hey", "aeo", "mu", "ooo", "artro"};
        int left = 1;
        int right = 4;
        System.out.println(vowelStrings(words, left, right));
    }

    // BEATS 100%
    public static int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                count++;
            }
        }
        return count;
    }

    public static boolean isVowel(char ch) {
        return ch == 'a'
                || ch == 'e'
                || ch == 'i'
                || ch == 'o'
                || ch == 'u';
    }

    // BEATS 23%
    public static int vowelStrings1(String[] words, int left, int right) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int count = 0;
        for (int i = left; i <= right; i++) {
            char s = words[i].charAt(0);
            char e = words[i].charAt(words[i].length() - 1);
            if (set.contains(s) && set.contains(e)) count++;
        }
        return count;
    }
}