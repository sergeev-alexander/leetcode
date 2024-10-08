package alexander.sergeev.leetcode.tasks;

// 1736. Latest Time by Replacing Hidden Digits
public class a1736 {

    /*
    You are given a string time in the form of  hh:mm, where some of the digits in the string are hidden (represented by ?).
    The valid times are those inclusively between 00:00 and 23:59.
    Return the latest valid time you can get from time by replacing the hidden digits.
     */

    public static void main(String[] args) {

        String s = "?6:4?";

        System.out.println(maximumTime(s)); // 16:49
    }

    public static String maximumTime(String time) {
        String[] arr = time.split("");
        if (arr[0].equals("?")) {
            if (!arr[1].equals("?")) {
                if (Integer.parseInt(arr[1]) <= 3) arr[0] = "2";
                else arr[0] = "1";
            } else arr[0] = "2";
        }
        if (arr[1].equals("?")) {
            if (arr[0].equals("2")) arr[1] = "3";
            else arr[1] = "9";
        }
        if (arr[3].equals("?")) arr[3] = "5";
        if (arr[4].equals("?")) arr[4] = "9";
        return String.join("", arr);
    }
}