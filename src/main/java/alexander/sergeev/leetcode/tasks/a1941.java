package alexander.sergeev.leetcode.tasks;

// 1941. Check if All Characters Have Equal Number of Occurrences
public class a1941 {

    /*
    Given a string s, return true if s is a good string, or false otherwise.
    A string s is good if all the characters that appear in s have the same number of occurrences
    (i.e., the same frequency).
     */

    public static void main(String[] args) {
        String s = "abacbc";
        System.out.println(areOccurrencesEqual(s));
    }

    // BEATS 100%
    public static boolean areOccurrencesEqual(String s) {
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        int occurrence = arr[s.charAt(0) - 'a'];
        for (int i : arr) {
            if (i != 0 && i != occurrence) return false;
        }
        return true;
    }
}