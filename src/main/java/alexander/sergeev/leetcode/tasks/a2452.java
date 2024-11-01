package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 2452. Words Within Two Edits of Dictionary
public class a2452 {

    /*
    You are given two string arrays, queries and dictionary. All words in each array
    comprise of lowercase English letters and have the same length.
    In one edit you can take a word from queries, and change any letter in it to any other letter.
    Find all words from queries that, after a maximum of two edits, equal some word from dictionary.
    Return a list of all words from queries, that match with some word from dictionary after a maximum of two edits.
    Return the words in the same order they appear in queries.
     */

    public static void main(String[] args) {
        String[] queries = {"yes"};
        String[] dictionary = {"not"};
        System.out.println(twoEditWords(queries, dictionary));
    }


    // BEATS 72%
    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        ArrayList<String> result = new ArrayList<>();
        if (queries[0].length() <= 2) {
            Collections.addAll(result, queries);
            return result;
        }
        MARK:
        for (String query : queries) {
            MARK2:
            for (String word : dictionary) {
                int count = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) != query.charAt(i)) count++;
                    if (count > 2) continue MARK2;
                }
                result.add(query);
                continue MARK;
            }
        }
        return result;
    }
}