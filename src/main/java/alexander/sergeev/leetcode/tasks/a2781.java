package alexander.sergeev.leetcode.tasks;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 2781. Length of the Longest Valid Substring
public class a2781 {

    /*
    You are given a string word and an array of strings forbidden.
    A string is called valid if none of its substrings are present in forbidden.
    Return the length of the longest valid substring of the string word.
    A substring is a contiguous sequence of characters in a string, possibly empty.
     */

    public static void main(String[] args) {
        List<String> denied = List.of("de", "le", "e");
        String word = "leetcode";
        System.out.println(longestValidSubstring(word, denied));
    }

    // BEATS 76%
    public static int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> forbiddenSet = new HashSet<>(forbidden);
        int maxValidLength = 0;
        int wordLength = word.length();
        for (int i = 0, j = 0; j < wordLength; ++j) {
            for (int k = j; k > Math.max(j - 10, i - 1); --k) {
                if (forbiddenSet.contains(word.substring(k, j + 1))) {
                    i = k + 1;
                    break;
                }
            }
            maxValidLength = Math.max(maxValidLength, j - i + 1);
        }
        return maxValidLength;
    }
}