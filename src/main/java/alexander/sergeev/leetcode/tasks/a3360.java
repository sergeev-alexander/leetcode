package alexander.sergeev.leetcode.tasks;

// 3360. Stone Removal Game
public class a3360 {

    /*
    Alice and Bob are playing a game where they take turns removing stones from a pile, with Alice going first.
    Alice starts by removing exactly 10 stones on her first turn.
    For each subsequent turn, each player removes exactly 1 fewer stone than the previous opponent.
    The player who cannot make a move loses the game.
    Given a positive integer n, return true if Alice wins the game and false otherwise.
     */

    public static void main(String[] args) {
        int n = 31;
        System.out.println(canAliceWin(n));
    }

    // BEATS 100%
    public static boolean canAliceWin(int n) {
        if (n < 10) return false;
        n -= 10;
        int move = 9;
        boolean aliceWins = true;
        while (n >= move) {
            n -= move--;
            aliceWins = !aliceWins;
        }
        return aliceWins;
    }
}