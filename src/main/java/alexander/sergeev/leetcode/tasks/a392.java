package alexander.sergeev.leetcode.tasks;

// 392. Is Subsequence
public class a392 {

    /*
    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
    A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
    of the characters without disturbing the relative positions of the remaining characters.
    (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
     */

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }

    // BEATS 93%
    public static boolean isSubsequence(String s, String t) {
        if (t.isBlank() && s.isBlank()) return true;
        if (t.isBlank()) return false;
        if (s.isBlank()) return true;
        char[] arr = s.toCharArray();
        int pos = 0;
        for (char ch : t.toCharArray()) {
            if (ch == arr[pos]) pos++;
            if (pos == s.length()) return true;
        }
        return false;
    }

    // BEATS 93%
    public static boolean isSubsequence1(String s, String t) {
        if (t.isBlank() && s.isBlank()) return true;
        if (t.isBlank()) return false;
        if (s.isBlank()) return true;
        int pos = 0;
        for (char ch : t.toCharArray()) {
            if (ch == s.charAt(pos)) pos++;
            if (pos == s.length()) return true;
        }
        return false;
    }
}