package alexander.sergeev.leetcode.tasks;

// 2544. Alternating Digit Sum
public class a2544 {

    /*
    You are given a positive integer n. Each digit of n has a sign according to the following rules:
    The most significant digit is assigned a positive sign.
    Each other digit has an opposite sign to its adjacent digits.
    Return the sum of all digits with their corresponding sign.
     */

    public static void main(String[] args) {
        int num = 886996;
        System.out.println(alternateDigitSum(num));
    }

    // BEATS 100%
    public static int alternateDigitSum(int n) {
        int sum = 0;
        int size = (int) Math.log10(n);
        int count = 0;
        while (size >= 0) {
            if (count % 2 == 0) sum += (int) (n / Math.pow(10, size));
            else sum -= (int) (n / Math.pow(10, size));
            count++;
            n = n % (int) Math.pow(10, size--);
        }
        return sum;
    }
}