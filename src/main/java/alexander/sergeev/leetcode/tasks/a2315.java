package alexander.sergeev.leetcode.tasks;

// 2315. Count Asterisks
public class a2315 {

    /*
    You are given a string s, where every two consecutive vertical bars '|' are grouped into a pair.
    In other words, the 1st and 2nd '|' make a pair, the 3rd and 4th '|' make a pair, and so forth.
    Return the number of '*' in s, excluding the '*' between each pair of '|'.
    Note that each '|' will belong to exactly one pair.
     */

    public static void main(String[] args) {
        String s = "yo|uar|e**|b|e***au|tifu|l";
        System.out.println(countAsterisks(s));
    }

    // BEATS 100%
    public static int countAsterisks(String s) {
        boolean open = true;
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '|') open = !open;
            if (open && ch == '*') count++;
        }
        return count;
    }

    // BEATS 65%
    public static int countAsterisks4(String s) {
        String[] arr = s.split("\\|");
        int start = s.startsWith("\\|") ? 1 : 0;
        int count = 0;
        for (int i = start; i < arr.length; i += 2) {
            for (int j = 0; j < arr[i].length(); j++) {
                if (arr[i].charAt(j) == '*') count++;
            }
        }
        return count;
    }
}