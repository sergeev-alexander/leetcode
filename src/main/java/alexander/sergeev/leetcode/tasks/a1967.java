package alexander.sergeev.leetcode.tasks;

// 1967. Number of Strings That Appear as Substrings in Word
public class a1967 {

    /*
    Given an array of strings patterns and a string word,
    return the number of strings in patterns that exist as a substring in word.
    A substring is a contiguous sequence of characters within a string.
     */

    public static void main(String[] args) {
        String[] arr = {"a","abc","bc","d"};
        String s = "abc";
        System.out.println(numOfStrings(arr, s));
    }

    // BEATS 100%
    public static int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String s : patterns) {
            if (word.contains(s)) count++;
        }
        return count;
    }
}