package alexander.sergeev.leetcode.tasks;

// 509. Fibonacci Number
public class a509 {

    /*
    Given n, calculate F(n).
     */

    public int fib(int n) {
        int[] arr = new int[n + 2];
        arr[0] = 0;
        arr[1] = 1;
        if (n > 1) { // case n = 0
            for (int i = 2; i < n + 1; i++) {
                arr[i] = arr[i - 2] + arr[i - 1];
            }
        }
        return arr[n];
    }
}
