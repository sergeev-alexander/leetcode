package alexander.sergeev.leetcode.tasks;

// 2710. Remove Trailing Zeros From a String
public class a2710 {

    /*
    Given a positive integer num represented as a string, return the integer num without trailing zeros as a string.
     */

    public static void main(String[] args) {
        String num = "51230100";
        System.out.println(removeTrailingZeros(num));

    }

    // BEATS 100%
    public static String removeTrailingZeros(String num) {
        int count = 0;
        for (int i = num.length() - 1; i > 0; i--) {
            if (num.charAt(i) == '0') count++;
            else break;
        }
        return num.substring(0, num.length() - count);
    }

    // BEATS 23%
    public static String removeTrailingZeros2(String num) {
        StringBuilder sb = new StringBuilder(num);
        for (int i = sb.length() - 1; i > 0; i--) {
            if (sb.charAt(i) == '0') {
                sb.deleteCharAt(i);
            } else break;
        }
        return sb.toString();
    }

    // BEATS 8%
    public static String removeTrailingZeros1(String num) {
        for (int i = num.length() - 1; i > 0 ; i--) {
            if (num.endsWith("0")) {
                num = num.substring(0, i);
            } else break;
        }
        return num;
    }
}