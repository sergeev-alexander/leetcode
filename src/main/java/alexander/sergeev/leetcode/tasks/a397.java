package alexander.sergeev.leetcode.tasks;

// 397. Integer Replacement
public class a397 {

    /*
    Given a positive integer n, you can apply one of the following operations:
    If n is even, replace n with n / 2.
    If n is odd, replace n with either n + 1 or n - 1.
    Return the minimum number of operations needed for n to become 1.
     */

    public static void main(String[] args) {
        int n = 2147483647;
        System.out.println(integerReplacement(n));
    }

    // BEATS 100%
    public static int integerReplacement(int n) {
        long num = n;
        int count = 0;
        while (num > 1) {
            if (num % 2 == 0) num /= 2;
            else {
                if (num != 3) {
                    if ((num - 1) % 4 == 0) num--;
                    else if ((num + 1) % 4 == 0) num++;
                    else num--;
                } else num--;
            }
            count++;
        }
        return count;
    }
}