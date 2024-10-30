package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

// 2472. Maximum Number of Non-overlapping Palindrome Substrings
public class a2472 {

    /*
    You are given a string s and a positive integer k.
    Select a set of non-overlapping substrings from the string s that satisfy the following conditions:
    The length of each substring is at least k.
    Each substring is a palindrome.
    Return the maximum number of substrings in an optimal selection.
    A substring is a contiguous sequence of characters within a string.
     */

    public static void main(String[] args) {
        String s = "zqzogfurlfmrnlffuipuupidkfhkggkhdrzezghwziopoinnsdkwkymhygonbiizmmmmzjhmyczzlz";
        int k = 2;
        System.out.println(maxPalindromes(s, k)); // 12
    }

    // BEATS 6%
    public static int maxPalindromes(String s, int k) {
        if (k == 1) {
            return s.length();
        }
        List<Segment> list = new ArrayList<>();
        MARK:
        for (int i = 0; i < s.length() - k + 1; i++) {
            for (int j = i + k; j <= s.length(); j++) {
                String word = s.substring(i, j);
                if (isPalindrome(word)) {
                    list.add(new Segment(i, j - 1));
                    continue MARK;
                }
            }
        }
        list.sort(Comparator.comparingInt(a -> a.end));
        if (list.isEmpty()) return 0;
        int count = 1;
        int end = list.get(0).end;
        for (int i = 1; i < list.size(); i++) {
            if (end < list.get(i).start) {
                end = list.get(i).end;
                count++;
            }
        }
        return count;
    }

    public static boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0, j = length - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    static class Segment {
        int start;
        int end;

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Segment segment)) return false;
            return start == segment.start && end == segment.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public String toString() {
            return "Segment{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}