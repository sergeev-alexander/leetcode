package alexander.sergeev.leetcode.tasks;

// 2027. Minimum Moves to Convert String
public class a2027 {

    /*
    You are given a string s consisting of n characters which are either 'X' or 'O'.
    A move is defined as selecting three consecutive characters of s and converting them to 'O'.
    Note that if a move is applied to the character 'O', it will stay the same.
    Return the minimum number of moves required so that all the characters of s are converted to 'O'.
     */

    public static void main(String[] args) {
        String s = "OXOX";
        System.out.println(minimumMoves(s));
    }

    // BEATS 100%
    public static int minimumMoves(String s) {
        int moves = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; ) {
            if (arr[i] == 'O') {
                i++;
                continue;
            }
            if (i + 1 == arr.length - 1) {
                if (arr[i + 1] == 'X') {
                    moves++;
                    break;
                }
            }
            if (i + 2 == arr.length - 1) {
                if (arr[i + 1] == 'X' || arr[i + 2] == 'X') {
                    moves++;
                    break;
                }
            }
            if (arr[i] == 'X' || arr[i - 1] == 'X' || arr[i - 2] == 'X') {
                moves++;
                i += 3;
            }
        }
        return moves;
    }

    // BEATS 5%
    public static int minimumMoves1(String s) {
        StringBuilder sb = new StringBuilder(s);
        int moves = 0;
        while (sb.indexOf("X") != -1) {
            int pos = sb.indexOf("X");
            if (pos + 3 > sb.length()) {
                moves++;
                break;
            }
            sb = new StringBuilder(sb.substring(pos + 3));
            moves++;
        }
        return moves;
    }
}