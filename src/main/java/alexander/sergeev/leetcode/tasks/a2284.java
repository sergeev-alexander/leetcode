package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 2284. Sender With Largest Word Count
public class a2284 {

    /*
    You have a chat log of n messages.
    You are given two string arrays messages and senders where messages[i] is a message sent by senders[i].
    A message is list of words that are separated by a single space with no leading or trailing spaces.
    The word count of a sender is the total number of words sent by the sender.
    Note that a sender may send more than one message.
    Return the sender with the largest word count. If there is more than one sender with the largest word count,
    return the one with the lexicographically largest name.
    Note:
    Uppercase letters come before lowercase letters in lexicographical order.
    "Alice" and "alice" are distinct.
     */

    public static void main(String[] args) {
        String[] m = {"How is leetcode for everyone","Leetcode is useful for practice"};
        String[] s = {"Bob","Charlie"};
        System.out.println(largestWordCount(m, s));
    }

    // BEATS 71%
    public static String largestWordCount(String[] messages, String[] senders) {
        int max = 0;
        String result = "";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            String sender = senders[i];
            int sum = map.merge(sender, messages[i].split(" ").length, Integer::sum);
            if (sum > max) {
                result = sender;
                max = sum;
            }
            if (sum == max) {
                if (sender.compareTo(result) > 0) {
                    result = sender;
                }
            }
        }
        return result;
    }

    // BEATS 24%
    public static String largestWordCount2(String[] messages, String[] senders) {
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            String sender = senders[i];
            map.merge(sender, messages[i].split(" ").length, Integer::sum);
            max = Math.max(max, map.get(sender));
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) list.add(entry.getKey());
        }
        list.sort(String::compareTo);
        return list.get(list.size() - 1);
    }

    // BEATS 23%
    public static String largestWordCount1(String[] messages, String[] senders) {
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            String sender = senders[i];
            map.merge(sender, messages[i].split(" ").length, Integer::sum);
            max = Math.max(max, map.get(sender));
        }
        int finalMax = max;
        return map.entrySet().stream()
                .filter(e -> e.getValue() == finalMax)
                .map(Map.Entry::getKey)
                .max(String::compareTo)
                .orElse("");
    }
}