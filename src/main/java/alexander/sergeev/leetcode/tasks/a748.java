package alexander.sergeev.leetcode.tasks;

import java.util.HashSet;
import java.util.Set;

// 748. Shortest Completing Word
public class a748 {

    /*
    Given a string licensePlate and an array of strings words, find the shortest completing word in words.
    A completing word is a word that contains all the letters in licensePlate. Ignore numbers and spaces in licensePlate,
    and treat letters as case insensitive.
    If a letter appears more than once in licensePlate, then it must appear in the word the same number of times or more.
    For example, if licensePlate = "aBc 12c", then it contains letters 'a', 'b' (ignoring case), and 'c' twice.
    Possible completing words are "abccdef", "caaacab", and "cbca".
    Return the shortest completing word in words. It is guaranteed an answer exists.
    If there are multiple shortest completing words, return the first one that occurs in words.
     */

    public static void main(String[] args) {
        String s = "AN87005";
        String[] arr = {"participant", "individual", "start", "exist", "above", "already", "easy", "attack", "player", "important"};
        System.out.println(shortestCompletingWord(s, arr));
    }

    // BETAS 80%
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        int[] wordArr = new int[26];
        for (char ch : licensePlate.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                wordArr[ch - 'a']++;
            }
        }
        String result = null;
        int minLength = 16;
        MARK:
        for (String word : words) {
            if (word.length() > minLength) continue;
            int[] arr = new int[26];
            for (char ch : word.toCharArray()) {
                arr[ch - 'a']++;
            }
            for (int i = 0; i < arr.length; i++) {
                if (wordArr[i] != 0 && arr[i] < wordArr[i]) {
                    continue MARK;
                }
            }
            if (word.length() < minLength) {
                result = word;
                minLength = word.length();
            }
        }
        return result;
    }

    // BEATS 67%
    public static String shortestCompletingWord1(String licensePlate, String[] words) {
        Set<String> set = new HashSet<>();
        int[] wordArr = new int[26];
        for (char ch : licensePlate.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                wordArr[ch - 'a']++;
            }
        }
        int minLength = 16;
        MARK:
        for (String word : words) {
            int[] arr = new int[26];
            for (char ch : word.toCharArray()) {
                arr[ch - 'a']++;
            }
            for (int i = 0; i < arr.length; i++) {
                if (wordArr[i] != 0 && arr[i] < wordArr[i]) {
                    continue MARK;
                }
            }
            minLength = Math.min(minLength, word.length());
            set.add(word);
        }
        for (String word : words) {
            if (set.contains(word) && word.length() == minLength) return word;
        }
        return null;
    }
}