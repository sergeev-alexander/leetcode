package alexander.sergeev.leetcode.tasks;

// 3114. Latest Time You Can Obtain After Replacing Characters
public class a3114 {

    /*
    You are given a string s representing a 12-hour format time where some of the digits (possibly none) are replaced with a "?".
    12-hour times are formatted as "HH:MM", where HH is between 00 and 11, and MM is between 00 and 59.
    The earliest 12-hour time is 00:00, and the latest is 11:59.
    You have to replace all the "?" characters in s with digits such that the time we obtain
    by the resulting string is a valid 12-hour format time and is the latest possible.
    Return the resulting string.
     */

    public static void main(String[] args) {

        String s = "??:1?";
        System.out.println(findLatestTime(s));
    }

    // BEATS 100%
    public static String findLatestTime(String s) {
        char[] times = s.toCharArray();
        if(times[0] == '?' && times[1] == '?') {
            times[0] = '1';
            times[1] = '1';
        } else if(times[1] == '?') {
            times[1] = times[0] == '0' ? '9' : '1';
        } else if(times[0] == '?') {
            times[0] = times[1] >= '2' ? '0' : '1';
        }
        if(times[3] == '?') {
            times[3] = '5';
        }
        if(times[4] == '?') {
            times[4] = '9';
        }
        return new String(times);
    }

    public static String findLatestTime_BEATS_30_PERCENT(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (sb.charAt(0) == '?') {
            if (sb.charAt(1) != '?') {
                if (Integer.parseInt(String.valueOf(sb.charAt(1))) <= 1) sb.setCharAt(0, '1');
                else sb.setCharAt(0, '0');
            } else sb.setCharAt(0, '1');
        }
        if (sb.charAt(1) == '?') {
            if (sb.charAt(0) == '0') sb.setCharAt(1, '9');
            else sb.setCharAt(1, '1');
        }
        if (sb.charAt(3) == '?') sb.setCharAt(3, '5');
        if (sb.charAt(4) == '?') sb.setCharAt(4, '9');
        return sb.toString();
    }
}
