package alexander.sergeev.leetcode.tasks;

import java.util.Comparator;
import java.util.PriorityQueue;

// 2208. Minimum Operations to Halve Array Sum
public class a2208 {

    /*
    You are given an array nums of positive integers.
    In one operation, you can choose any number from nums and reduce it to exactly half the number.
    (Note that you may choose this reduced number in future operations.)
    Return the minimum number of operations to reduce the sum of nums by at least half.
     */

    public static void main(String[] args) {
        int[] arr = {92,91,55,74,98,45,94,99,35,28,78,10,27,55,93,93,33,76,14,27,82,11,5,58,96,70,31,6};
        System.out.println(halveArray(arr));
    }

    // BEATS 98%
    public static int halveArray(int[] nums) {
        PriorityQueue<Double> queue = new PriorityQueue<>();
        double sum = 0.0;
        for (double i : nums) {
            sum -= i;
            queue.add(-i);
        }
        double target = sum / 2.0;
        int count = 0;
        while (sum < target) {
            double num = queue.remove() / 2.0;
            sum -= num;
            queue.add(num);
            count++;
        }
        return count;
    }

    // BEATS 53%
    public static int halveArray1(int[] nums) {
        PriorityQueue<Double> queue = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0.0;
        for (double i : nums) {
            sum -= i;
            queue.add(i);
        }
        double target = sum / 2.0;
        int count = 0;
        while (sum > target) {
            double num = queue.remove() / 2.0;
            sum -= num;
            queue.add(num);
            count++;
        }
        return count;
    }
}