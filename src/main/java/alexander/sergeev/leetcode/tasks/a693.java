package alexander.sergeev.leetcode.tasks;

// 693. Binary Number with Alternating Bits
public class a693 {

    /*
    Given a positive integer, check whether it has alternating bits: namely,
    if two adjacent bits will always have different values.
     */

    public static void main(String[] args) {
        int n = 7;
        System.out.println(hasAlternatingBits(n));
    }

    // BEATS 100%
    public static boolean hasAlternatingBits(int n) {
        String binaryString = Integer.toBinaryString(n);
        return !binaryString.contains("00") && !binaryString.contains("11");
    }
}