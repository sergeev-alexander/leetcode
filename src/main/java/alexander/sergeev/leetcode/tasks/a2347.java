package alexander.sergeev.leetcode.tasks;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// 2347. Best Poker Hand
public class a2347 {

    /*
    You are given an integer array ranks and a character array suits. You have 5 cards
    where the ith card has a rank of ranks[i] and a suit of suits[i].
    The following are the types of poker hands you can make from best to worst:
    "Flush": Five cards of the same suit.
    "Three of a Kind": Three cards of the same rank.
    "Pair": Two cards of the same rank.
    "High Card": Any single card.
    Return a string representing the best type of poker hand you can make with the given cards.
    Note that the return values are case-sensitive.
     */

    public static void main(String[] args) {
        int[] ranks = {4, 4, 2, 4, 4};
        char[] suits = {'d', 'a', 'a', 'b', 'c'};
        System.out.println(bestHand(ranks, suits));
    }

    // BEATS 100%
    public static String bestHand(int[] ranks, char[] suits) {
        int[] suitArr = new int[4];
        int[] rankArr = new int[14];
        for (int i = 0; i < 5; i++) rankArr[ranks[i]]++;
        for (int i = 0; i < 5; i++) suitArr[suits[i] - 'a']++;
        int rankCount = 0;
        int suitsCount = 0;
        for (int i = 1; i < 14; i++) rankCount = Math.max(rankCount, rankArr[i]);
        for (int i = 0; i < 4; i++) suitsCount = Math.max(suitsCount, suitArr[i]);
        if (suitsCount == 5) {
            return "Flush";
        } else if (rankCount >= 3) {
            return "Three of a Kind";
        } else if (rankCount == 2) {
            return "Pair";
        } else return "High Card";
    }

    // BEATS 53%
    public static String bestHand1(int[] ranks, char[] suits) {
        Set<Character> suitsSet = new HashSet<>();
        for (char ch : suits) suitsSet.add(ch);
        if (suitsSet.size() == 1) return "Flush";
        Map<Integer, Integer> map = new TreeMap<>();
        for (int rank : ranks) {
            map.merge(rank, 1, Integer::sum);
        }
        if (map.size() == 5) return "High Card";
        int maxCount = 0;
        for (int counts : map.values()) maxCount = Math.max(maxCount, counts);
        return maxCount >= 3 ? "Three of a Kind" : "Pair";
    }
}