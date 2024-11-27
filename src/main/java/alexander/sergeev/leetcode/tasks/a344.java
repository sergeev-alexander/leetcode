package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 344. Reverse String
public class a344 {

    /*
    Write a function that reverses a string. The input string is given as an array of characters s.
    You must do this by modifying the input array in-place with O(1) extra memory.
     */

    public static void main(String[] args) {
        char[] arr = {'H','e','l','l','o'};
        reverseString(arr);
        System.out.println(Arrays.toString(arr));
    }

    // BEATS 100%
    public static void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}