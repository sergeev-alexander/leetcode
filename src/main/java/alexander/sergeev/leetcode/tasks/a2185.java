package alexander.sergeev.leetcode.tasks;

// 2185. Counting Words With a Given Prefix
public class a2185 {

    /*
    You are given an array of strings words and a string pref.
    Return the number of strings in words that contain pref as a prefix.
    A prefix of a string s is any leading contiguous substring of s.
     */

    public static void main(String[] args) {
        String[] arr = {"pay","attention","practice","attend"};
        String prefix = "at";
        System.out.println(prefixCount(arr, prefix));
    }

    // BEATS 100%
    public static int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) count++;
        }
        return count;
    }
}