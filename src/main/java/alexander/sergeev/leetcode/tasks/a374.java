package alexander.sergeev.leetcode.tasks;

// 374. Guess Number Higher or Lower
public class a374 {

    /*
    We are playing the Guess Game. The game is as follows:
    I pick a number from 1 to n. You have to guess which number I picked.
    Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
    You call a pre-defined API int guess(int num), which returns three possible results:
    -1: Your guess is higher than the number I picked (i.e. num > pick).
    1: Your guess is lower than the number I picked (i.e. num < pick).
    0: your guess is equal to the number I picked (i.e. num == pick).
    Return the number that I picked.
     */

    public static void main(String[] args) {
        int n = 10;
        System.out.println(guessNumber(n));
    }

    // BEATS 100%
    public static int guessNumber(int n) {
        int left = 0;
        int right = n;
        while (true) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);
            if (res == 0) return mid;
            if (res > 0) left = mid + 1;
            else right = mid - 1;
        }
    }

    private static int guess(int num) {
        return Integer.compare(6, num);
    }
}