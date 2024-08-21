package alexander.sergeev;

import java.util.Arrays;

// 66. Plus One
public class a66 {

    /*
    You are given a large integer represented as an integer array digits,
    where each digits[i] is the ith digit of the integer.
    The digits are ordered from most significant to the least significant in left-to-right order.
    The large integer does not contain any leading 0's.
    Increment the large integer by one and return the resulting array of digits.
     */

    public static void main(String[] args) {

        int[] digits = {9, 9, 9, 9};

        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        if (digits[length - 1] == 9) {
            for (int i = length - 1; i >= 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i] = digits[i] + 1;
                    break;
                }
                if (i == 0) {
                    int[] result = new int[length + 1];
                    result[0] = 1;
                    System.arraycopy(digits, 0, result, 1, length);
                    return result;
                }
            }
        } else {
            digits[length - 1] = digits[length - 1] + 1;
        }
        return digits;
    }
}
