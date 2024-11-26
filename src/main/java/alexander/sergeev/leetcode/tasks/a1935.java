package alexander.sergeev.leetcode.tasks;

// 1935. Maximum Number of Words You Can Type
public class a1935 {

    /*
    There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.
    Given a string text of words separated by a single space (no leading or trailing spaces)
    and a string brokenLetters of all distinct letter keys that are broken,
    return the number of words in text you can fully type using this keyboard.
     */

    public static void main(String[] args) {
        String s = "hello world";
        String b = "ad";
        System.out.println(canBeTypedWords(s, b));
    }

    // BEATS 100%
    public static int canBeTypedWords(String text, String brokenLetters) {
        int[] arr = new int[26];
        for (char ch : brokenLetters.toCharArray()) {
            arr[ch - 'a']++;
        }
        int count = 0;
        MARK:
        for (String s : text.split(" ")) {
            for (char ch : s.toCharArray()) {
                if (arr[ch - 'a'] != 0) {
                    continue MARK;
                }
            }
            count++;
        }
        return count;
    }
}