package alexander.sergeev.leetcode.tasks;

// 2108. Find First Palindromic String in the Array
public class a2108 {

    /*
    Given an array of strings words, return the first palindromic string in the array.
    If there is no such string, return an empty string "".
    A string is palindromic if it reads the same forward and backward.
     */

    public static void main(String[] args) {
        String[] arr = {"abc", "car", "ada", "racecar", "cool"};
        System.out.println(firstPalindrome(arr));
    }

    // BEATS 40%
    public static String firstPalindrome(String[] words) {
        MARK:
        for (String str : words) {
            int start = 0;
            int end = str.length() - 1;
            while (start < end) {
                if (str.charAt(start++) != str.charAt(end++)) {
                    continue MARK;
                }
            }
            return str;
        }
        return "";
    }
}