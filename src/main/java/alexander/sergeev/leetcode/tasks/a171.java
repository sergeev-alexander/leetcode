package alexander.sergeev.leetcode.tasks;

import java.util.HashMap;
import java.util.Map;

// 171. Excel Sheet Column Number
public class a171 {

    /*
    Given a string columnTitle that represents the column title as appears in an Excel sheet,
    return its corresponding column number.
     */

    public static void main(String[] args) {

        String t = "AA";

        System.out.println(titleToNumber(t)); // 27
    }

    public static int titleToNumber(String columnTitle) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('A' + i);
            map.put(ch, i + 1);
        }
        String[] arr = columnTitle.split("");
        int sum = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char cur_char = columnTitle.charAt(columnTitle.length() - 1 - i);
            sum += (int) (map.get(cur_char) * Math.pow(26, i));
        }
        return sum;
    }
}
