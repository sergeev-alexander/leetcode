package alexander.sergeev.leetcode.tasks;

// 2000. Reverse Prefix of Word
public class a2000 {

    /*
    Given a 0-indexed string word and a character ch,
    reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive).
    If the character ch does not exist in word, do nothing.
    For example, if word = "abcdefd" and ch = "d",
    then you should reverse the segment that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".
    Return the resulting string.
     */

    public static void main(String[] args) {
        String s = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(s, ch));
    }

    // BEATS 100%
    public static String reversePrefix(String word, char ch) {
        int pos = word.indexOf(ch);
        if (pos <= 0) return word;
        return new StringBuilder(word.substring(0, pos + 1))
                .reverse()
                .append(word.substring(pos + 1))
                .toString();
    }

    // BEATS 100%
    public static String reversePrefix1(String word, char ch) {
        int pos = word.indexOf(ch);
        if (pos <= 0) return word;
        StringBuilder sb = new StringBuilder();
        for (int i = pos; i >= 0; i--) {
            sb.append(word.charAt(i));
        }
        sb.append(word.substring(pos + 1));
        return sb.toString();
    }
}