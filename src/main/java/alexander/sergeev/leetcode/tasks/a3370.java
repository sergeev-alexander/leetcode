package alexander.sergeev.leetcode.tasks;

// 3370. Smallest Number With All Set Bits
public class a3370 {

    /*
    Return the smallest number x greater than or equal to n, such that the binary representation of x contains only
    set bits
     */

    public static void main(String[] args) {
        int n = 5;
        System.out.println(smallestNumber(n));
    }

    // BEATS 8%
    public static int smallestNumber(int n) {
        for ( ; ; n++) {
            if (!Integer.toBinaryString(n).contains("0")) {
                return n;
            }
        }
    }

    // BEATS 8%
    public static int smallestNumber1(int n) {
        for ( ; ; n++) {
            if (Integer.bitCount(n) == Integer.toBinaryString(n).length()) {
                return n;
            }
        }
    }
}