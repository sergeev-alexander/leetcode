package alexander.sergeev.leetcode.tasks;

// 1961. Check If String Is a Prefix of Array
public class a1961 {

    /*
    Given a string s and an array of strings words, determine whether s is a prefix string of words.
    A string s is a prefix string of words if s can be made by concatenating the first k strings in words
    for some positive k no larger than words.length.
    Return true if s is a prefix string of words, or false otherwise.
     */

    public static void main(String[] args) {
        String[] arr = {"i","love","leetcode","apples"};
        String s = "iloveleetcode";
        System.out.println(isPrefixString(s, arr));
    }

    // BEATS 81%
    public static boolean isPrefixString(String s, String[] words) {
        StringBuilder prefix = new StringBuilder();
        for (String word : words) {
            prefix.append(word);
            if (s.length() == prefix.length()) {
                return s.contentEquals(prefix);
            }
        }
        return false;
    }
}