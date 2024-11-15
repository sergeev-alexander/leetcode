package alexander.sergeev.leetcode.tasks;

// 2124. Check if All A's Appears Before All B's
public class a2124 {

    /*
    Given a string s consisting of only the characters 'a' and 'b',
    return true if every 'a' appears before every 'b' in the string. Otherwise, return false.
     */

    public static void main(String[] args) {
        String s = "abab";
        System.out.println(checkString(s));
    }

    // BEATS 100%
    public static boolean checkString(String s) {
        if (!s.contains("a") && s.contains("b") || !s.contains("b") && s.contains("a")) return true;
        return (s.lastIndexOf('a') < s.indexOf('b'));
    }
}