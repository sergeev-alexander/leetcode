package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;
import java.util.stream.Collectors;

// 557. Reverse Words in a String III
public class a557 {

    /*
    Given a string s, reverse the order of characters in each word within a sentence
    while still preserving whitespace and initial word order.
     */

    public static void main(String[] args) {

        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    // COULD BE FASTER...
    public static String reverseWords(String s) {
        return Arrays.stream(s.split(" "))
                .map(str -> new StringBuilder(str).reverse())
                .collect(Collectors.joining(" "));
    }
}