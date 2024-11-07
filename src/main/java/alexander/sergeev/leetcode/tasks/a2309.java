package alexander.sergeev.leetcode.tasks;

// 2309. Greatest English Letter in Upper and Lower Case
public class a2309 {

    /*
    Given a string of English letters s, return the greatest English letter which occurs
    as both a lowercase and uppercase letter in s. The returned letter should be in uppercase.
    If no such letter exists, return an empty string.
    An English letter b is greater than another letter a if b appears after a in the English alphabet.
     */

    public static void main(String[] args) {
        String s = "a rR AzFif";
        System.out.println(greatestLetter(s));
    }

    // BEATS 100%
    public static String greatestLetter(String s) {
        char l = 'z';
        char u = 'Z';
        char a = 'a';
        while (l >= a) {
            if (s.contains(String.valueOf(l)) && s.contains(String.valueOf(u))) {
                return String.valueOf(u);
            }
            l--;
            u--;
        }
        return "";
    }

    // BEATS 85%
    public static String greatestLetter2(String s) {
        char l = 'a';
        char u = 'A';
        char z = 'z';
        char max = 0;
        while (l <= z) {
            if (s.contains(String.valueOf(l)) && s.contains(String.valueOf(u))) {
                max = (char) Math.max(max, u);
            }
            l++;
            u++;
        }
        return max > 0 ? String.valueOf(max) : "";
    }

    // BEATS 36%
    public static String greatestLetter1(String s) {
        boolean[] lowArr = new boolean[26];
        boolean[] uppArr = new boolean[26];
        int max = -1;
        for (char ch : s.toCharArray()) {
            if (ch == ' ') continue;
            if (Character.isUpperCase(ch)) {
                uppArr[ch - 'A'] = true;
                if (lowArr[ch + 32 - 'a']) {
                    max = Math.max(max, ch);
                }
            }
            if (Character.isLowerCase(ch)) {
                lowArr[ch - 'a'] = true;
                if (uppArr[ch - 'a']) {
                    max = Math.max(max, Character.toUpperCase(ch));
                }
            }

        }
        return max == -1 ? "" : String.valueOf((char) max);
    }
}