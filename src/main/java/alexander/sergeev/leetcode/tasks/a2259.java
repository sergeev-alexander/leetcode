package alexander.sergeev.leetcode.tasks;

// 2259. Remove Digit From Number to Maximize Result
public class a2259 {

    /*
    You are given a string number representing a positive integer and a character digit.
    Return the resulting string after removing exactly one occurrence of digit from number such that the value of
    the resulting string in decimal form is maximized.
    The test cases are generated such that digit occurs at least once in number.
     */

    public static void main(String[] args) {
        String num = "32313";
        char digit = '1';
        System.out.println(removeDigit(num, digit));
    }

    // BEATS 100%
    public static String removeDigit(String number, char digit) {
        int index = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                index = i;
                if (i < number.length() - 1 && digit < number.charAt(i + 1)) break;
            }
        }
        number = number.substring(0, index) + number.substring(index + 1);
        return number;
    }

    // BEATS 66%
    public static String removeDigit1(String number, char digit) {
        int[] sumArr = new int[number.length()];
        String max = "";
        char[] arr = number.toCharArray();
        for (int i = 0; i < number.length(); i++) {
            if (arr[i] == digit) {
                String temp = number.substring(0, i) + number.substring(i + 1);
                if (temp.compareTo(max) > 0) {
                    max = temp;
                }
            }
        }
        return max;
    }
}