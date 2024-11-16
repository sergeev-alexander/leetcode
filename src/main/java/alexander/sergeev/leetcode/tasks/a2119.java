package alexander.sergeev.leetcode.tasks;

// 2119. A Number After a Double Reversal
public class a2119 {

    /*
    Reversing an integer means to reverse all its digits.
    For example, reversing 2021 gives 1202. Reversing 12300 gives 321 as the leading zeros are not retained.
    Given an integer num, reverse num to get reversed1, then reverse reversed1 to get reversed2.
    Return true if reversed2 equals num. Otherwise return false.
     */

    // BEATS 100%
    public static void main(String[] args) {
        int num = 1800;
        System.out.println(isSameAfterReversals(num));
    }

    public static boolean isSameAfterReversals(int num) {
        return (num / 10 == 0) || (num % 10 != 0);
    }
}