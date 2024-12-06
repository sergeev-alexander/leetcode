package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 500. Keyboard Row
public class a500 {

    /*
    Given an array of strings words, return the words that can be typed using letters of the alphabet
    on only one row of American keyboard like the image below.
    Note that the strings are case-insensitive,
    both lowercased and uppercased of the same letter are treated as if they are at the same row.
    In the American keyboard:
    the first row consists of the characters "qwertyuiop",
    the second row consists of the characters "asdfghjkl", and
    the third row consists of the characters "zxcvbnm".
     */

    public static void main(String[] args) {
        String[] words = {"Hello","Alaska","Dad","Peace"};
        System.out.println(Arrays.toString(findWords(words)));
    }

    // BEATS 100%
    public static String[] findWords(String[] words) {
        int[] arr = new int[26];
        for (char ch : "qwertyuiop".toCharArray()) {
            arr[ch - 'a'] = 1;
        }
        for (char ch : "asdfghjkl".toCharArray()) {
            arr[ch - 'a'] = 2;
        }
        for (char ch : "zxcvbnm".toCharArray()) {
            arr[ch - 'a'] = 3;
        }
        String[] result = new String[words.length];
        int count = 0;
        MARK:
        for (String word : words) {
            char[] chars = word.toLowerCase().toCharArray();
            int row = arr[chars[0] - 'a'];
            for (int j = 1; j < chars.length; j++) {
                if (arr[chars[j] - 'a'] != row) continue MARK;
            }
            result[count++] = word;
        }
        return Arrays.copyOfRange(result, 0, count);
    }
}