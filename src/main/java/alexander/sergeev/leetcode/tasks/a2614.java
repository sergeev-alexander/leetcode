package alexander.sergeev.leetcode.tasks;

// 2614. Prime In Diagonal
public class a2614 {

    /*
    You are given a 0-indexed two-dimensional integer array nums.
    Return the largest prime number that lies on at least one of the diagonals of nums.
    In case, no prime is present on any of the diagonals, return 0.
    Note that:
    An integer is prime if it is greater than 1 and has no positive integer divisors other than 1 and itself.
    An integer val is on one of the diagonals of nums if there exists an integer i for which
    nums[i][i] = val or an i for which nums[i][nums.length - i - 1] = val.
     */

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11}};
        System.out.println(diagonalPrime(arr));
    }

    public static int diagonalPrime(int[][] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (i == j || j == nums.length - i - 1) {
                    if (isPrime(nums[i][j])) {
                        max = Math.max(max, nums[i][j]);
                    }
                }
            }
        }
        return max;
    }

    private static boolean isPrime(int num) {
        if (num == 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i <= Math.sqrt(num) ; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
}