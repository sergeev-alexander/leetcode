package alexander.sergeev.leetcode.tasks;

// 58. Length of Last Word
public class a58 {

    /*
    Given a string s consisting of words and spaces,
    return the length of the last word in the string.
    A word is a maximal substring
    consisting of non-space characters only.
     */

    public static void main(String[] args) {

        String s = "Hello World";

        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        return arr[arr.length - 1].length();
    }
}
