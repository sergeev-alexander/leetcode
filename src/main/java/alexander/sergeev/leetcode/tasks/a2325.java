package alexander.sergeev.leetcode.tasks;

import java.util.HashMap;
import java.util.Map;

// 2325. Decode the Message
public class a2325 {

    /*
    You are given the strings key and message, which represent a cipher key and a secret message, respectively.
    The steps to decode message are as follows:
    Use the first appearance of all 26 lowercase English letters in key as the order of the substitution table.
    Align the substitution table with the regular English alphabet.
    Each letter in message is then substituted using the table.
    Spaces ' ' are transformed to themselves.
    For example, given key = "happy boy" (actual key would have at least one instance of each letter in the alphabet),
    we have the partial substitution table of ('h' -> 'a', 'a' -> 'b', 'p' -> 'c', 'y' -> 'd', 'b' -> 'e', 'o' -> 'f').
    Return the decoded message.
     */

    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        System.out.println(decodeMessage(key, message));
    }

    // BEATS 86%
    public static String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (ch == ' ' || map.containsKey(ch)) continue;
            map.put(ch, (char) ('a' + (char) count++));
            if (map.size() == 26) break;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch == ' ') {
                sb.append(ch);
                continue;
            }
            sb.append(map.get(ch));
        }
        return sb.toString();
    }
}