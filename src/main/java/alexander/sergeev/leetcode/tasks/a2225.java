package alexander.sergeev.leetcode.tasks;

import java.util.*;

// 2225. Find Players With Zero or One Losses
public class a2225 {

    /*
    You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri
    defeated player loseri in a match.
    Return a list answer of size 2 where:
    answer[0] is a list of all players that have not lost any matches.
    answer[1] is a list of all players that have lost exactly one match.
    The values in the two lists should be returned in increasing order.
    Note:
    You should only consider the players that have played at least one match.
    The testcases will be generated such that no two matches will have the same outcome.
    */

    public static void main(String[] args) {
        int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        System.out.println(findWinners(matches));
    }

    // BEATS 91%
    public static List<List<Integer>> findWinners(int[][] matches) {
        List<Integer> winners = new ArrayList<>();
        List<Integer> almostWinners = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            map.merge(match[0], 0, Integer::sum);
            map.merge(match[1], -1, (o, n) -> o - 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int score = entry.getValue();
            if (score < -1) continue;
            if (score == 0) {
                winners.add(entry.getKey());
                continue;
            }
            if (score == -1) almostWinners.add(entry.getKey());
        }
        winners.sort(Comparator.naturalOrder());
        almostWinners.sort(Comparator.naturalOrder());
        return List.of(winners, almostWinners);
    }

    // BEATS 9%
    public static List<List<Integer>> findWinners1(int[][] matches) {
        List<Integer> winners = new ArrayList<>();
        List<Integer> almostWinners = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] match : matches) {
            map.merge(match[0], 0, Integer::sum);
            map.merge(match[1], -1, (o, n) -> o - 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                winners.add(entry.getKey());
                continue;
            }
            if (entry.getValue() == -1) almostWinners.add(entry.getKey());
        }
        return List.of(winners, almostWinners);
    }
}