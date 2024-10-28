package alexander.sergeev.leetcode.tasks;

// 2520. Count the Digits That Divide a Number
public class a2520 {

    /*
    Given an integer num, return the number of digits in num that divide num.
    An integer val divides nums if nums % val == 0.
     */

    public static void main(String[] args) {
        int a = 1248;
        System.out.println(countDigits(a));
    }

    // BEATS 100%
    public static int countDigits(int num) {
        int size = (int) Math.log10(num) + 1;
        int count = 0;
        int temp = num;
        for (int i = 0; i < size; i++) {
            int div = temp % 10;
            if (num % div == 0) count++;
            temp /= 10;
        }
        return count;
    }
}