package alexander.sergeev.leetcode.tasks;

// 2496. Maximum Value of a String in an Array
public class a2496 {

    /*
    The value of an alphanumeric string can be defined as:
    The numeric representation of the string in base 10, if it comprises of digits only.
    The length of the string, otherwise.
    Given an array strs of alphanumeric strings, return the maximum value of any string in strs.
     */

    public static void main(String[] args) {
        String[] arr = {"7","7i","cye","bv7yg","t3ye6","990"};
        System.out.println(maximumValue(arr));
    }

    // BEATS 93%
    public static int maximumValue(String[] strs) {
        int max = 0;
        MARK:
        for (String str : strs) {
            for (char ch : str.toCharArray()) {
                if (Character.isLetter(ch)) {
                    max = Math.max(max, str.length());
                    continue MARK;
                }
            }
            max = Math.max(max, Integer.parseInt(str));
        }
        return max;
    }
}