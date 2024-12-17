package alexander.sergeev.leetcode.tasks;

// 762. Prime Number of Set Bits in Binary Representation
public class a762 {

    /*
    Given two integers left and right, return the count of numbers in the inclusive range [left, right]
    having a prime number of set bits in their binary representation.
    Recall that the number of set bits an integer has is the number of 1's present when written in binary.
    For example, 21 written in binary is 10101, which has 3 set bits.
     */

    public static void main(String[] args) {
        int left = 10;
        int right = 15;
        System.out.println(countPrimeSetBits(left,right));
    }

    // BEATS 88%
    public static int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(Integer.bitCount(i))) count++;
        }
        return count;
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i <= Math.sqrt(num); i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
}