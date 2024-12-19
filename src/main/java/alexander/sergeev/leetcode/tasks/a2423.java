package alexander.sergeev.leetcode.tasks;

// 2423. Remove Letter To Equalize Frequency
public class a2423 {

    /*
    You are given a 0-indexed string word, consisting of lowercase English letters.
    You need to select one index and remove the letter at that index from word
    so that the frequency of every letter present in word is equal.
    Return true if it is possible to remove one letter so that the frequency of all letters in word are equal,
    and false otherwise.
    Note:
    The frequency of a letter x is the number of times it occurs in the string.
    You must remove exactly one letter and cannot choose to do nothing.
     */

    public static void main(String[] args) {
        String s = "ddaccb";
        System.out.println(equalFrequency(s));
    }

    // BEATS 100%
    public static boolean equalFrequency(String word) {
        int[] arr = new int[26];
        for (char ch : word.toCharArray()) {
            arr[ch - 'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                arr[i]--;
                boolean isValid = true;
                int target = 0;
                for (int freq : arr) {
                    if (freq == 0) continue;
                    if (target > 0 && freq != target) {
                        isValid = false;
                        break;
                    }
                    target = freq;
                }
                arr[i]++;
                if (isValid) return true;
            }
        }
        return false;
    }
}