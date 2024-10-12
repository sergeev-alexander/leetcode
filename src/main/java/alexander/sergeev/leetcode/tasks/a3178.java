package alexander.sergeev.leetcode.tasks;

// 3178. Find the Child Who Has the Ball After K Seconds
public class a3178 {

    /*
    You are given two positive integers n and k. There are n children numbered from 0 to n - 1
    standing in a queue in order from left to right.
    Initially, child 0 holds a ball and the direction of passing the ball is towards the right direction.
    After each second, the child holding the ball passes it to the child next to them.
    Once the ball reaches either end of the line, i.e. child 0 or child n - 1, the direction of passing is reversed.
    Return the number of the child who receives the ball after k seconds.
     */

    public static void main(String[] args) {

        int n = 4;
        int k = 2;

        System.out.println(numberOfChild(n, k));

    }

    // COULD BE FASTER
    public static int numberOfChild(int n, int k) {
        boolean positive = true;
        int count = 1;
        int pos = 0;
        while (count <= k) {
            if (pos == n - 1) {
                positive = false;
            }
            if (pos == 0) {
                positive = true;
            }
            if (positive) {
                pos++;
            } else {
                pos--;
            }
            count++;
        }
        return pos;
    }
}
