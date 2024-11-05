package alexander.sergeev.leetcode.tasks;

import java.util.HashSet;
import java.util.Set;

// 2351. First Letter to Appear Twice
public class a2351 {

    /*
    Given a string s consisting of lowercase English letters, return the first letter to appear twice.
    Note:
    A letter a appears twice before another letter b if the second occurrence of a is before the second occurrence of b.
    s will contain at least one letter that appears twice.
     */

    public static void main(String[] args) {
        String s = "abccbaacz";
        System.out.println(repeatedCharacter(s));
    }

    // BEATS 100%
    public static char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
            } else {
                return ch;
            }
        }
        return s.charAt(0);
    }
}