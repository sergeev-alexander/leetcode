package alexander.sergeev.leetcode.tasks;

// 2490. Circular Sentence
public class a2490 {

    /*
    A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
    For example, "Hello World", "HELLO", "hello world hello world" are all sentences.
    Words consist of only uppercase and lowercase English letters.
    Uppercase and lowercase English letters are considered different.
    A sentence is circular if:
    The last character of a word is equal to the first character of the next word.
    The last character of the last word is equal to the first character of the first word.
     */

    public static void main(String[] args) {
        String s = "leetcode exercises sound delightful";
        System.out.println(isCircularSentence(s));
    }

    // BEATS 100%
    public static boolean isCircularSentence(String sentence) {
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) return false;
        String[] arr = sentence.split(" ");
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].charAt(arr[i - 1].length() - 1) != arr[i].charAt(0)) return false;
        }
        return true;
    }
}