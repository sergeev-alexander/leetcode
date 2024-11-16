package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 2114. Maximum Number of Words Found in Sentences
public class a2114 {

    /*
    A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
    You are given an array of strings sentences, where each sentences[i] represents a single sentence.
    Return the maximum number of words that appear in a single sentence.
     */

    public static void main(String[] args) {
        String[] arr = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        System.out.println(mostWordsFound(arr));
    }

    // BEATS 91%
    public static int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String s : sentences) {
            max = Math.max(max, s.split(" ").length);
        }
        return max;
    }

    // BEATS 32%
    public static int mostWordsFound1(String[] sentences) {
        return Arrays.stream(sentences)
                .mapToInt(s -> s.split(" ").length)
                .max()
                .getAsInt();
    }
}