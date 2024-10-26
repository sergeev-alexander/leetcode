package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 2545. Sort the Students by Their Kth Score
public class a2545 {

    /*
    There is a class with m students and n exams. You are given a 0-indexed m x n integer matrix score,
    where each row represents one student and score[i][j] denotes the score the ith student got in the jth exam.
    The matrix score contains distinct integers only.
    You are also given an integer k. Sort the students (i.e., the rows of the matrix) by their scores
    in the kth (0-indexed) exam from the highest to the lowest.
    Return the matrix after sorting it.
     */

    public static void main(String[] args) {
        int[][] arr = {
                {10, 6, 9, 1},
                {7, 5, 11, 2},
                {4, 8, 3, 15}};
        int k = 2;

        for (int[] a : sortTheStudents(arr, k))
            System.out.println(Arrays.toString(a));
    }

    // BEATS 93%
    public static int[][] sortTheStudents(int[][] score, int k) {
        int max = 0;
        int pos= 0;
        for (int i = 0; i < score.length; i++) {
            for (int j = i; j < score.length; j++) {
                if (score[j][k] > max) {
                    max = score[j][k];
                    pos = j;
                }
            }
            int[] temp = score[i];
            score[i] = score[pos];
            score[pos] = temp;
            max = 0;
        }
        return score;
    }

    // BEATS 38%
    public static int[][] sortTheStudents1(int[][] score, int k) {
        int[] arr = new int[score.length];
        int pos = 0;
        for (int[] studs : score) arr[pos++] = studs[k];
        Arrays.sort(arr);
        int[][] result = new int[score.length][];
        for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
            for (int[] studs : score) {
                if (arr[i] == studs[k]) {
                    result[j] = studs;
                    break;
                }
            }
        }
        return result;
    }
}