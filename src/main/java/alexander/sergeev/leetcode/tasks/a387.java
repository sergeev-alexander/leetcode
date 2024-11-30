package alexander.sergeev.leetcode.tasks;

import java.util.HashMap;
import java.util.Map;

// 387. First Unique Character in a String
public class a387 {

    /*
    Given a string s, find the first non-repeating character in it and return its index.
    If it does not exist, return -1.
     */

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    // BEATS 99%
    public static int firstUniqChar(String s) {
        char[] wordArr = s.toCharArray();
        int[] arr = new int[26];
        for (char ch : wordArr) {
            arr[ch - 'a']++;
        }
        int pos = 0;
        for (char ch : wordArr) {
            if (arr[ch - 'a'] == 1) return pos;
            pos++;
        }
        return -1;
    }

    // BEATS 91%
    public static int firstUniqChar2(String s) {
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }

    // BEATS 55%
    public static int firstUniqChar1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}