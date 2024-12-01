package alexander.sergeev.leetcode.tasks;

// 409. Longest Palindrome
public class a409 {

    /*
    Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome
    that can be built with those letters.
    Letters are case sensitive, for example, "Aa" is not considered a palindrome.
     */

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

    // BEATS 100%
    public static int longestPalindrome(String s) {
        int[] arr = new int[128];
        for (char ch : s.toCharArray()) {
            arr[ch]++;
        }
        int result = 0;
        for (int i : arr) {
            result = result + i / 2 * 2;
        }
        if (result < s.length()) {
            result++;
        }
        return result;
    }
}