package alexander.sergeev.leetcode.tasks;

// 400. Nth Digit
public class a400 {

    /*
    Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].
     */

    public static void main(String[] args) {
        int num = 10000000;
        System.out.println(findNthDigit(num));
    }

    // BEATS 100%
    public static int findNthDigit(int n) {
        int digitLength = 1;
        int digitCount = 9;
        while ((long) digitLength * digitCount < n) {
            n -= digitLength * digitCount;
            digitLength++;
            digitCount *= 10;
        }
        int number = (int) Math.pow(10, digitLength - 1) + (n - 1) / digitLength;
        int digitIndex = (n - 1) % digitLength;
        return String.valueOf(number).charAt(digitIndex) - '0';
    }

    // TLE
    public static int findNthDigit1(int n) {
        int num = 10;
        int count = 9;
        if (n <= 9) return n;
        while (true) {
            int copy = num;
            int size = (int) Math.log10(num);
            while (size >= 0) {
                int currentDigit = copy / (int) Math.pow(10, size);
                count++;
                if (count == n) return currentDigit;
                copy %= (int) Math.pow(10, size--);
            }
            count++;
            if (count == n) return num % 10;
            num++;
        }
    }
}