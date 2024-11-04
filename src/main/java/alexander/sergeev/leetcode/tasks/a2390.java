package alexander.sergeev.leetcode.tasks;

import java.util.Deque;
import java.util.LinkedList;

// 2390. Removing Stars From a String
public class a2390 {

    /*
    You are given a string s, which contains stars *.
    In one operation, you can:
    Choose a star in s.
    Remove the closest non-star character to its left, as well as remove the star itself.
    Return the string after all stars have been removed.
    Note:
    The input will be generated such that the operation is always possible.
    It can be shown that the resulting string will always be unique.
     */

    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(removeStars(s));
    }

    // BEATS 94%
    public static String removeStars(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int i = -1, j = 0;
        while (j < s.length()) {
            if (s.charAt(j) != '*') {
                i++;
                stringBuilder.setCharAt(i, stringBuilder.charAt(j));
            } else {
                if (i >= 0)
                    i--;
            }
            j++;
        }
        return i >= 0 ? stringBuilder.substring(0, i + 1) : "";
    }

    // BEATS 75%
    public static String removeStars2(String s) {
        StringBuilder result = new StringBuilder(s.length());
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                result.deleteCharAt(--j);
            } else {
                result.append(s.charAt(i));
                j++;
            }
        }
        return result.toString();
    }

    // BEATS 70%
    public static String removeStars1(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                deque.pop();
            } else deque.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeLast());
        }
        return sb.toString();
    }

}