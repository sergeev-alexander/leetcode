package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.List;

// 2194. Cells in a Range on an Excel Sheet
public class a2194 {

    /*
    A cell (r, c) of an excel sheet is represented as a string "<col><row>" where:
    <col> denotes the column number c of the cell. It is represented by alphabetical letters.
    For example, the 1st column is denoted by 'A', the 2nd by 'B', the 3rd by 'C', and so on.
    <row> is the row number r of the cell. The rth row is represented by the integer r.
    You are given a string s in the format "<col1><row1>:<col2><row2>",
    where <col1> represents the column c1, <row1> represents the row r1, <col2> represents the column c2,
    and <row2> represents the row r2, such that r1 <= r2 and c1 <= c2.
    Return the list of cells (x, y) such that r1 <= x <= r2 and c1 <= y <= c2.
    The cells should be represented as strings in the format mentioned above and be sorted in non-decreasing order
    first by columns and then by rows.
     */

    public static void main(String[] args) {
        String s = "A1:F1";
        System.out.println(cellsInRange(s));
    }

    // BEATS 45%
    public static List<String> cellsInRange(String s) {
        List<String> list = new ArrayList<>();
        for (int i = s.charAt(0); i <= s.charAt(3); i++) {
            for (int j = s.charAt(1); j <= s.charAt(4); j++) {
                list.add(String.valueOf((char) i) + (char) j);
            }
        }
        return list;
    }
}