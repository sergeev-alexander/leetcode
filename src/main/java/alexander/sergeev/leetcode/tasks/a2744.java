package alexander.sergeev.leetcode.tasks;

// 2744. Find Maximum Number of String Pairs
public class a2744 {

    /*
    You are given a 0-indexed array words consisting of distinct strings.
    The string words[i] can be paired with the string words[j] if:
    The string words[i] is equal to the reversed string of words[j].
    0 <= i < j < words.length.
    Return the maximum number of pairs that can be formed from the array words.
    Note that each string can belong in at most one pair.
     */

    public static void main(String[] args) {
        String[] words = {"cd","ac","dc","ca","zz"};
        System.out.println(maximumNumberOfStringPairs(words));
    }

    // BEATS 86%
    public static int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i] == null) continue;
            StringBuilder sb = new StringBuilder(words[i]).reverse();
            for (int j = i + 1; j < words.length; j++) {
                if (words[j] == null) continue;
                if (String.valueOf(sb).equals(words[j])) {
                    count++;
                    words[j] = null;
                    break;
                }
            }
        }
        return count;
    }
}