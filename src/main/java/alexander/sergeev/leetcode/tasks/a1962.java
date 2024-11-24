package alexander.sergeev.leetcode.tasks;

import java.util.Comparator;
import java.util.PriorityQueue;

// 1962. Remove Stones to Minimize the Total
public class a1962 {

    /*
    You are given a 0-indexed integer array piles, where piles[i] represents the number of stones in the ith pile,
    and an integer k. You should apply the following operation exactly k times:
    Choose any piles[i] and remove floor(piles[i] / 2) stones from it.
    Notice that you can apply the operation on the same pile more than once.
    Return the minimum possible total number of stones remaining after applying the k operations.
    floor(x) is the greatest integer that is smaller than or equal to x (i.e., rounds x down).
     */

    public static void main(String[] args) {
        int[] arr = {4,3,6,7};
        int k = 3;
        System.out.println(minStoneSum(arr, k));
    }

    // BEATS 76%
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int sum = 0;
        for (int num : piles) {
            priorityQueue.add(-num);
            sum += num;
        }
        while (k > 0) {
            int num1 = priorityQueue.poll();
            int num2 = (num1 * -1) - (num1 / -2);
            sum += num1 + num2;
            priorityQueue.add(-num2);
            k--;
        }
        return sum;
    }

    // BEATS 76%
    public static int minStoneSum2(int[] piles, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : piles) {
            priorityQueue.add(-num);
        }
        while (k > 0) {
            int num1 = priorityQueue.poll();
            int num2 = (num1 * -1) - (num1 / -2);
            priorityQueue.add(-num2);
            k--;
        }
        int sum = 0;
        for (int num : priorityQueue) {
            sum -= num;
        }
        return sum;
    }

    // BEATS 44%
    public static int minStoneSum1(int[] piles, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : piles) {
            priorityQueue.add(num);
        }
        while (k > 0) {
            int num1 = priorityQueue.poll();
            int num2 = num1 - (num1 / 2);
            priorityQueue.add(num2);
            k--;
        }
        int sum = 0;
        for (int num : priorityQueue) {
            sum += num;
        }
        return sum;
    }
}