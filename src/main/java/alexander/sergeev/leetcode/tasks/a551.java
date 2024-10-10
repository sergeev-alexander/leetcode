package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 551. Student Attendance Record I
public class a551 {

    /*
    You are given a string s representing an attendance record for a student where each character signifies
    whether the student was absent, late, or present on that day. The record only contains the following three characters:
    'A': Absent.
    'L': Late.
    'P': Present.
    The student is eligible for an attendance award if they meet both of the following criteria:
    The student was absent ('A') for strictly fewer than 2 days total.
    The student was never late ('L') for 3 or more consecutive days.
    Return true if the student is eligible for an attendance award, or false otherwise.
     */

    public static void main(String[] args) {

        String s = "PALLLP";
        System.out.println(checkRecord(s));

    }

    // VERY SLOW...
    public static boolean checkRecord(String s) {
        boolean l = !s.contains("LLL");
        String[] arr = s.split("");
        Arrays.sort(arr);
        return l && !Arrays.toString(arr).contains("A, A");
    }

    public static boolean checkRecord_SLOW1(String s) {
        return !s.contains("LLL")
                && s.replaceAll("A", "").length() > s.length() - 2;
    }

    public static boolean checkRecord_SLOW2(String s) {
        return !s.contains("LLL") && Arrays.stream(s.split(""))
                .filter(str -> str.equals("A"))
                .count() < 2;
    }
}
