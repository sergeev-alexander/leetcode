package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 2553. Separate the Digits in an Array
public class a2553 {

    /*
    Given an array of positive integers nums, return an array answer that consists of the digits of each integer
    in nums after separating them in the same order they appear in nums.
    To separate the digits of an integer is to get all the digits it has in the same order.
    For example, for the integer 10921, the separation of its digits is [1,0,9,2,1].
     */

    public static void main(String[] args) {
        int[] arr = {134, 25, 83, 77};
        System.out.println(Arrays.toString(separateDigits(arr)));
    }

    // BEATS 88%
    public static int[] separateDigits(int[] nums) {
        int[] result = new int[400_001];
        int pos = 0;
        int count = 0;
        for (int i : nums) {
            int dimension = (int) Math.log10(i);
            while (dimension > 0) {
                int s = (int) Math.pow(10, dimension--);
                result[pos++] = i / s;
                count++;
                i %= s;
            }
            result[pos++] = i % 10;
            count++;
        }
        return Arrays.copyOf(result, count);
    }

    // BEATS 23%
    public static int[] separateDigits1(int[] nums) {
        int[] result = new int[400_001];
        int pos = 0;
        int count = 0;
        for (int i : nums) {
            String s = String.valueOf(i);
            int length = 0;
            while (length < s.length()) {
                result[pos++] = Integer.parseInt(String.valueOf(s.charAt(length++)));
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }
}