package alexander.sergeev.leetcode.tasks;

// 2645. Minimum Additions to Make Valid String
public class a2645 {

    /*
    Given a string word to which you can insert letters "a", "b" or "c" anywhere and any number of times,
    return the minimum number of letters that must be inserted so that word becomes valid.
    A string is called valid if it can be formed by concatenating the string "abc" several times.
     */

    public static void main(String[] args) {
        String s = "aaabbac";
        System.out.println(addMinimum(s));
    }

    // BEATS 100%
    public static int addMinimum(String word) {
        int count = 0;
        int pos = 0;
        while (pos < word.length()) {
            if (word.startsWith("abc", pos)) {
                pos += 3;
                continue;
            }
            if (word.startsWith("ab", pos)
                    || word.startsWith("bc", pos)
                    || word.startsWith("ac", pos)) {
                pos += 2;
                count++;
                continue;
            }
            if (word.charAt(pos) == 'a'
                    || word.charAt(pos) == 'b'
                    || word.charAt(pos) == 'c') {
                pos++;
                count += 2;
            }
        }
        return count;
    }

    // BEATS 21%
    public static int addMinimum2(String word) {
        int length = word.length();
        word = word.replace("abc", "XXX");
        word = word.replace("ab", "XXX");
        word = word.replace("bc", "XXX");
        word = word.replace("ac", "XXX");
        word = word.replace("a", "XXX");
        word = word.replace("b", "XXX");
        word = word.replace("c", "XXX");
        return word.length() - length;
    }


    // BEATS 8%
    public static int addMinimum1(String word) {
        StringBuilder sb = new StringBuilder(word.replace("abc", "XXX"));
        int count = 0;
        while (sb.indexOf("ab") != -1) {
            int index = sb.indexOf("ab");
            sb.replace(index, index + 2, "XX");
            count++;
        }
        while (sb.indexOf("bc") != -1) {
            int index = sb.indexOf("bc");
            sb.replace(index, index + 2, "XX");
            count++;
        }
        while (sb.indexOf("ac") != -1) {
            int index = sb.indexOf("ac");
            sb.replace(index, index + 2, "XX");
            count++;
        }
        while (sb.indexOf("a") != -1) {
            int index = sb.indexOf("a");
            sb.replace(index, index + 1, "X");
            count += 2;
        }
        while (sb.indexOf("b") != -1) {
            int index = sb.indexOf("b");
            sb.replace(index, index + 1, "X");
            count += 2;
        }
        while (sb.indexOf("c") != -1) {
            int index = sb.indexOf("c");
            sb.replace(index, index + 1, "X");
            count += 2;
        }
        return count;
    }
}