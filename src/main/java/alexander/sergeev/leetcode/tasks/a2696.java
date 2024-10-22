package alexander.sergeev.leetcode.tasks;

import java.util.Deque;
import java.util.LinkedList;

// 2696. Minimum String Length After Removing Substrings
public class a2696 {

    /*
    You are given a string s consisting only of uppercase English letters.
    You can apply some operations to this string where, in one operation,
    you can remove any occurrence of one of the substrings "AB" or "CD" from s.
    Return the minimum possible length of the resulting string that you can obtain.
    Note that the string concatenates after removing the substring and could produce new "AB" or "CD" substrings.
     */

    public static void main(String[] args) {
        String s = "ABFCACDB";
        System.out.println(minLength(s)); // 2
    }

    // BEATS 90%
    public static int minLength(String s) {
        Deque<Character> deque = new LinkedList<>();
        deque.push('X');
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char dequeCh = deque.peek();
            if ((dequeCh == 'A' && ch == 'B') || (dequeCh == 'C' && ch == 'D')) {
                deque.pop();
            } else deque.push(ch);
        }
        return deque.size() - 1;
    }

    // BEATS 8%
    public static int minLength3(String s) {
        Deque<String> deque = new LinkedList<>();
        deque.push("X");
        for (int i = 0; i < s.length(); i++) {
            if ((deque.peek() + s.charAt(i)).equals("AB") || (deque.peek() + s.charAt(i)).equals("CD")) {
                deque.pop();
            } else deque.push(String.valueOf(s.charAt(i)));
        }
        return deque.size() - 1;
    }

    // BEATS 22%
    public static int minLength2(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            if (s.contains("AB")) s = s.replace("AB", "");
            if (s.contains("CD")) s = s.replace("CD", "");
        }
        return s.length();
    }

    // BEATS 5%
    public static int minLength1(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            s = s.replaceAll("AB", "");
            s = s.replaceAll("CD", "");
        }
        return s.length();
    }
}