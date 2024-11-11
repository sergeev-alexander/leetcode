package alexander.sergeev.leetcode.tasks;

// 2255. Count Prefixes of a Given String
public class a2255 {

    /*
    You are given a string array words and a string s, where words[i] and s comprise only of lowercase English letters.
    Return the number of strings in words that are a prefix of s.
    A prefix of a string is a substring that occurs at the beginning of the string.
    A substring is a contiguous sequence of characters within a string.
     */

    public static void main(String[] args) {
        String s = "abc";
        String[] words = {"a","b","c","ab","bc","abc"};
        System.out.println(countPrefixes(words, s));
    }

    // BEATS 100%
    public static int countPrefixes(String[] words, String s) {
        int count = 0;
        for (String str : words) {
            if (s.startsWith(str)) count++;
        }
        return count;
    }
}