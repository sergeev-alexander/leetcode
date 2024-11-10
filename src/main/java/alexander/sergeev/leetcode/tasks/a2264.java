package alexander.sergeev.leetcode.tasks;

// 2264. Largest 3-Same-Digit Number in String
public class a2264 {

    /*
    You are given a string num representing a large integer. An integer is good if it meets the following conditions:
    It is a substring of num with length 3.
    It consists of only one unique digit.
    Return the maximum good integer as a string or an empty string "" if no such integer exists.
    Note:
    A substring is a contiguous sequence of characters within a string.
    There may be leading zeroes in num or a good integer.
     */

    public static void main(String[] args) {
        String s = "6777133339";
        System.out.println(largestGoodInteger(s));
    }

    // BEATS 100%
    public static String largestGoodInteger(String num) {
        String[] arr = {"999", "888", "777", "666", "555", "444", "333", "222", "111", "000"};
        String result = "";
        for (String s : arr) {
            if (num.contains(s)) {
                result = s;
                break;
            }
        }
        return result;
    }
}