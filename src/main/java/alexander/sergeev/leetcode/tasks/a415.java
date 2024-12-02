package alexander.sergeev.leetcode.tasks;

// 415. Add Strings
public class a415 {

    /*
    Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
    You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
    You must also not convert the inputs to integers directly.
     */

    public static void main(String[] args) {
        String num1 = "456";
        String num2 = "77";
        System.out.println(addStrings(num1, num2));
    }

    // BEATS 100%
    public static String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        int pos1 = num1.length() - 1;
        int pos2 = num2.length() - 1;
        int carry = 0;
        while (pos1 >= 0 || pos2 >= 0 || carry != 0) {
            int sum = 0;
            if (pos1 >= 0) {
                sum += num1.charAt(pos1--) - '0';
            }
            if (pos2 >= 0) {
                sum += num2.charAt(pos2--) - '0';
            }
            sum += carry;
            stringBuilder.append(sum % 10);
            carry = sum / 10;
        }
        return stringBuilder.reverse().toString();
    }

    // BEATS 63%
    public static String addStrings1(String num1, String num2) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }
        String n1 = num1.length() > num2.length() ? num1 : num2;
        String n2 = num2.length() < num1.length() ? num2 : num1;
        int pos1 = n1.length() - 1;
        int pos2 = n2.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        boolean isMoreThenTen = false;
        int res;
        while (pos1 >= 0) {
            if (pos2 >= 0) {
                res = arr[n1.charAt(pos1--) - '0'] + arr[n2.charAt(pos2--) - '0'];
            } else {
                res = arr[n1.charAt(pos1--) - '0'];
            }
            if (isMoreThenTen) res++;
            stringBuilder.append(res % 10);
            isMoreThenTen = res / 10 > 0;
        }
        if (isMoreThenTen) stringBuilder.append(1);
        return stringBuilder.reverse().toString();
    }
}