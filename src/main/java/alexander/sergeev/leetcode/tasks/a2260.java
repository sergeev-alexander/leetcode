package alexander.sergeev.leetcode.tasks;

import java.util.HashMap;
import java.util.Map;

// 2260. Minimum Consecutive Cards to Pick Up
public class a2260 {

    /*
    You are given an integer array cards where cards[i] represents the value of the ith card.
    A pair of cards are matching if the cards have the same value.
    Return the minimum number of consecutive cards you have to pick up to have a pair of matching cards among the picked cards.
    If it is impossible to have matching cards, return -1.
     */

    public static void main(String[] args) {
        int[] arr = {3,4,2,3,4,7};
        System.out.println(minimumCardPickup(arr));
    }

    // BEATS 96%
    public static int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = 100_001;
        for (int i = 0; i < cards.length; i++) {
            if (min == 2) return 2;
            if (map.containsKey(cards[i])) {
                min = Math.min(min, i - map.get(cards[i]) + 1);
            }
            map.put(cards[i], i);
        }
        return min == 100_001 ? -1 : min;
    }

    // BEATS 76%
    public static int minimumCardPickup1(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = 100_001;
        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i])) {
                min = Math.min(min, i - map.get(cards[i]) + 1);
            }
            map.put(cards[i], i);
        }
        return min == 100_001 ? -1 : min;
    }
}