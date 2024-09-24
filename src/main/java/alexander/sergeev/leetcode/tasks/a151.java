package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 151. Reverse Words in a String
public class a151 {

    /*
    Given an input string s, reverse the order of the words.
    A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
    Return a string of the words in reverse order concatenate
     */

    public static void main(String[] args) {

        String s = "the sky is blue";

        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        List<String> list = new ArrayList<>(Arrays.stream(s.trim().split(" "))
                .filter(str -> !str.isBlank())
                .toList());
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
