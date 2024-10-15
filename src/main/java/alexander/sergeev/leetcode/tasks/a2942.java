package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// 2942. Find Words Containing Character
public class a2942 {

    /*
    You are given a 0-indexed array of strings words and a character x.
    Return an array of indices representing the words that contain the character x.
    Note that the returned array may be in any order.
     */

    public static void main(String[] args) {

        String[] s = {"abc", "bcd", "aaaa", "cbc"};
        char x = 'a';
        System.out.println(findWordsContaining(s, x));
    }

    // BEATS 100%
    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            if (words[i].indexOf(x) > -1) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static List<Integer> findWordsContaining_BEATS_90_PERCENT(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].charAt(j) == x) {
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }

    public static List<Integer> findWordsContaining_BEATS_58_PERCENT(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(String.valueOf(x))) list.add(i);
        }
        return list;
    }

    public static List<Integer> findWordsContaining_BEATS_6_PERCENT(String[] words, char x) {
        return Stream.iterate(0, i -> i < words.length, i -> ++i)
                .filter(i -> words[i].contains(String.valueOf(x)))
                .toList();
    }
}
