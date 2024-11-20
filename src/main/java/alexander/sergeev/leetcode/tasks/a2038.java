package alexander.sergeev.leetcode.tasks;

// 2038. Remove Colored Pieces if Both Neighbors are the Same Color
public class a2038 {

    /*
    There are n pieces arranged in a line, and each piece is colored either by 'A' or by 'B'.
    You are given a string colors of length n where colors[i] is the color of the ith piece.
    Alice and Bob are playing a game where they take alternating turns removing pieces from the line.
    In this game, Alice moves first.
    Alice is only allowed to remove a piece colored 'A' if both its neighbors are also colored 'A'.
    She is not allowed to remove pieces that are colored 'B'.
    Bob is only allowed to remove a piece colored 'B' if both its neighbors are also colored 'B'.
    He is not allowed to remove pieces that are colored 'A'.
    Alice and Bob cannot remove pieces from the edge of the line.
    If a player cannot make a move on their turn, that player loses and the other player wins.
    Assuming Alice and Bob play optimally, return true if Alice wins, or return false if Bob wins.
     */

    public static void main(String[] args) {
        String s = "AAAABBBB";
        System.out.println(winnerOfGame(s));
    }

    // BEATS 85%
    public static boolean winnerOfGame(String colors) {
        int aliceScore = 0;
        int bobScore = 0;
        int countA = 0;
        int countB = 0;
        char current = colors.charAt(0);
        for (int i = 0; i < colors.length(); i++) {
            if (colors.charAt(i) == current) {
                if (current == 'A') countA++;
                else countB++;
            } else {
                if (current == 'A') {
                    if (countA >= 3) {
                        aliceScore += countA - 2;
                    }
                    countA = 0;
                    countB++;
                    current = 'B';
                    continue;
                }
                if (current == 'B') {
                    if (countB >= 3) {
                        bobScore += countB - 2;
                    }
                    countB = 0;
                    countA++;
                    current = 'A';
                }
            }
        }
        if (current == 'A' && countA >= 3) {
            aliceScore += countA - 2;
        }
        if (current == 'B' && countB >= 3) {
            bobScore += countB - 2;
        }
        return aliceScore > bobScore;
    }

    // TLE
    public static boolean winnerOfGame1(String colors) {
        StringBuilder sb = new StringBuilder(colors);
        boolean isAliceTurn = true;
        while (sb.indexOf("AAA") > -1 || sb.indexOf("BBB") > -1) {
            if (isAliceTurn) {
                if (sb.indexOf("AAA") == -1) return false;
                else {
                    int pos = sb.indexOf("AAA") + 1;
                    sb.deleteCharAt(pos);
                    isAliceTurn = false;
                }
            } else {
                if (sb.indexOf("BBB") == -1) return true;
                else {
                    int pos = sb.indexOf("BBB") + 1;
                    sb.deleteCharAt(pos);
                    isAliceTurn = true;
                }
            }
        }
        return !isAliceTurn;
    }
}