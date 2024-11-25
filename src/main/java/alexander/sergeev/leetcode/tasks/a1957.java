package alexander.sergeev.leetcode.tasks;

// 1957. Delete Characters to Make Fancy String
public class a1957 {

    /*
    A fancy string is a string where no three consecutive characters are equal.
    Given a string s, delete the minimum possible number of characters from s to make it fancy.
    Return the final string after the deletion. It can be shown that the answer will always be unique.
     */

    public static void main(String[] args) {
        String s = "aaabaaaa";
        System.out.println(makeFancyString(s));
    }

    // BEATS 29%
    public static String makeFancyString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char currentChar : s.toCharArray()) {
            int currentLength = stringBuilder.length();
            if (currentLength > 1
                    && stringBuilder.charAt(currentLength - 1) == currentChar
                    && stringBuilder.charAt(currentLength - 2) == currentChar) {
                continue;
            }
            stringBuilder.append(currentChar);
        }
        return stringBuilder.toString();
    }

    // TLE
    public static String makeFancyString2(String s) {
        for (int i = 0; i < 27; i++) {
            String ch = String.valueOf((char) ('a' + i));
            StringBuilder pattern = new StringBuilder(ch).append(ch).append(ch);
            if (!s.contains(pattern)) continue;
            while (s.contains(pattern)) {
                s = s.replaceAll(String.valueOf(pattern), pattern.substring(1));
            }
        }
        return s;
    }

    // TLE
    public static String makeFancyString1(String s) {
        for (int i = 0; i < 27; i++) {
            String ch = String.valueOf((char) ('a' + i));
            String pattern = ch + ch + ch;
            if (!s.contains(pattern)) continue;
            String replacement = ch + ch;
            while (s.contains(pattern)) {
                s = s.replaceAll(pattern, replacement);
            }
        }
        return s;
    }
}