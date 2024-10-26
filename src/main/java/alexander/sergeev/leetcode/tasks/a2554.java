package alexander.sergeev.leetcode.tasks;

import java.util.HashSet;
import java.util.Set;

// 2554. Maximum Number of Integers to Choose From a Range I
public class a2554 {

    /*
    You are given an integer array banned and two integers n and maxSum. You are choosing some number of integers following the below rules:
    The chosen integers have to be in the range [1, n].
    Each integer can be chosen at most once.
    The chosen integers should not be in the array banned.
    The sum of the chosen integers should not exceed maxSum.
    Return the maximum number of integers you can choose following the mentioned rules.
     */

    public static void main(String[] args) {
        int[] arr = {1, 6, 5};
        int n = 5;
        int max = 6;
        System.out.println(maxCount(arr, n, max));
    }

    // BEATS 100%
    public static int maxCount(int[] banned, int n, int maxSum) {
        boolean[] vis = new boolean[10001];
        for (int j : banned) {
            vis[j] = true;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (vis[i]) continue;
            if (maxSum >= i) {
                maxSum -= i;
                count++;
            } else break;
        }
        return count;
    }

    // BEATS 80%
    public static int maxCount1(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for (int i : banned) set.add(i);
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) continue;
            if ((sum + i) <= maxSum) {
                sum += i;
                count++;
            } else break;
        }
        return count;
    }
}