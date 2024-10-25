package alexander.sergeev.leetcode.tasks;

// 2582. Pass the Pillow
public class a2582 {

    /*
    There are n people standing in a line labeled from 1 to n. The first person in the line is holding a pillow initially.
    Every second, the person holding the pillow passes it to the next person standing in the line.
    Once the pillow reaches the end of the line, the direction changes,
    and people continue passing the pillow in the opposite direction.
    For example, once the pillow reaches the nth person they pass it to the n - 1th person, then to the n - 2th person and so on.
    Given the two positive integers n and time, return the index of the person holding the pillow after time seconds.
     */

    public static void main(String[] args) {
        int n = 4;
        int t = 5;
        System.out.println(passThePillow(n, t));
    }

    // BEATS 100%
    public static int passThePillow(int n, int time) {
        int pos = 1;
        boolean forward = true;
        while (time > 0) {
            if (pos == n) {
                forward = false;
                pos--;
                time--;
                continue;
            }
            if (pos == 1) {
                forward = true;
                pos++;
                time--;
                continue;
            }
            if (forward) {
                pos++;
            } else {
                pos--;
            }
            time--;
        }
        return pos;
    }
}