package alexander.sergeev.leetcode.tasks;

import java.util.*;

// 3120. Count the Number of Special Characters I
public class a3120 {

    /*
    You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.
    Return the number of special letters in word.
     */

    public static void main(String[] args) {

        String s = "aaAbcBC";
        System.out.println(numberOfSpecialChars(s));
    }

    public static int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLowerCase(ch)
                    && word.contains(String.valueOf(Character.toUpperCase(ch))))
                set.add(ch);
        }
        return set.size();
    }

    public static int numberOfSpecialChars_VERY_SLOW(String word) {
        return (int) Arrays.stream(word.split(""))
                .filter(s -> Character.isLowerCase(s.charAt(0)) && word.contains(String.valueOf(Character.toUpperCase(s.charAt(0)))))
                .distinct()
                .count();
    }
}
