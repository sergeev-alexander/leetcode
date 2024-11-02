package alexander.sergeev.leetcode.tasks;

// 2437. Number of Valid Clock Times
public class a2437 {

    /*
    You are given a string of length 5 called time, representing the current time on a digital clock in the format "hh:mm".
    The earliest possible time is "00:00" and the latest possible time is "23:59".
    In the string time, the digits represented by the ? symbol are unknown,
    and must be replaced with a digit from 0 to 9.
    Return an integer answer, the number of valid clock times that can be created by replacing every ? with a digit from 0 to 9.
     */

    public static void main(String[] args) {
        String s = "?3:1?";
        System.out.println(countTime(s));
    }

    // BEATS 100%
    public static int countTime(String time) {
        String[] arr = time.split(":");
        int hours;
        if (arr[0].equals("??")) {
            hours = 24;
        } else if (arr[0].charAt(0) == '?') {
            if (Character.getNumericValue(arr[0].charAt(1)) <= 3) {
                hours = 3;
            } else {
                hours = 2;
            }
        } else if (arr[0].charAt(1) == '?') {
            if (Character.getNumericValue(arr[0].charAt(0)) > 1) {
                hours = 4;
            } else {
                hours = 10;
            }
        } else {
            hours = 1;
        }
        int minutes;
        if (arr[1].equals("??")) {
            minutes = 60;
        } else if (arr[1].charAt(0) == '?') {
            minutes = 6;
        } else if (arr[1].charAt(1) == '?') {
            minutes = 10;
        } else {
            minutes = 1;
        }
        return hours * minutes;
    }
}