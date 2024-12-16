package alexander.sergeev.leetcode.tasks;

// 738. Monotone Increasing Digits
public class a738 {

    /*
    An integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.
    Given an integer n, return the largest number that is less than or equal to n with monotone increasing digits.
     */

    public static void main(String[] args) {
        int n = 332;
        System.out.println(monotoneIncreasingDigits(n));
    }

    // BEATS 100%
    public static int monotoneIncreasingDigits(int n) {
        int size = (int) Math.log10(n);
        int max = (int) (n / Math.pow(10, size));
        int maxSize = size;
        int currentSize = size;
        for (int i = 0; i < size; i++) {
            int firstNum = (int) (n / Math.pow(10, currentSize)) % 10;
            int secondNum = (int) (n / Math.pow(10, currentSize - 1)) % 10;
            if (firstNum > max) {
                max = firstNum;
                maxSize = currentSize;
            }
            if (firstNum > secondNum) {
                int num = (int) (n / Math.pow(10, maxSize)) - 1;
                while (maxSize-- > 0) {
                    num *= 10;
                    num += 9;
                }
                return num;
            }
            currentSize--;
        }
        return n;
    }

    // BEATS 83%
    public static int monotoneIncreasingDigits1(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        char max = arr[0];
        int maxPos = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxPos = i;
            }
            if (arr[i] > arr[i + 1]) {
                arr[maxPos]--;
                while (++maxPos < arr.length) {
                    arr[maxPos] = '9';
                }
                return Integer.parseInt(new String(arr));
            }
        }
        return n;
    }
}