package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

// 386. Lexicographical Numbers
public class a386 {

    /*
    Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
    You must write an algorithm that runs in O(n) time and uses O(1) extra space.
     */

    public static void main(String[] args) {
        int n = 13;
        System.out.println(lexicalOrder(n));
    }

    // BEATS 49%
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int current = 1;
        for (int i = 0; i < n; ++i) {
            result.add(current);
            if (current * 10 <= n) {
                current *= 10;
            } else {
                while (current % 10 == 9 || current + 1 > n) {
                    current /= 10;
                }
                current++;
            }
        }
        return result;
    }

    // BEATS 7%
    public static List<Integer> lexicalOrder2(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        list.sort(Comparator.comparing(String::valueOf));
        return list;
    }

    // BEATS 5%
    public static List<Integer> lexicalOrder1(int n) {
        TreeSet<Integer> treeSet = new TreeSet<>(Comparator.comparing(String::valueOf));
        for (int i = 1; i <= n; i++) {
            treeSet.add(i);
        }
        return new ArrayList<>(treeSet);
    }
}