package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 2678. Number of Senior Citizens
public class a2678 {

    /*
    You are given a 0-indexed array of strings details. Each element of details provides information about
    a given passenger compressed into a string of length 15. The system is such that:
    The first ten characters consist of the phone number of passengers.
    The next character denotes the gender of the person.
    The following two characters are used to indicate the age of the person.
    The last two characters determine the seat allotted to that person.
    Return the number of passengers who are strictly more than 60 years old.
     */

    public static void main(String[] args) {
        String[] details = {"7868190130M7522", "5303914400F9211", "9273338290F4010"};
        System.out.println(countSeniors(details)); // 2
    }

    // BEATS 80%
    public static int countSeniors(String[] details) {
        int count = 0;
        String str = "60";
        for (String s : details) {
            if (s.substring(11, 13).compareTo(str) > 0) {
                count++;
            }
        }
        return count;
    }

    // BEATS 80%
    public static int countSeniors2(String[] details) {
        int count = 0;
        for (String s : details) {
            if (Integer.parseInt(s.substring(11, 13)) > 60) {
                count++;
            }
        }
        return count;
    }

    // BEATS 9%
    public static int countSeniors1(String[] details) {
        return (int) Arrays.stream(details)
                .filter(s -> Integer.parseInt(s.substring(11, 13)) > 60)
                .count();
    }
}