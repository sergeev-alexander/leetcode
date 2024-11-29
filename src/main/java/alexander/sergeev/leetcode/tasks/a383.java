package alexander.sergeev.leetcode.tasks;

// 383. Ransom Note
public class a383 {

    /*
    Given two strings ransomNote and magazine,
    return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
    Each letter in magazine can only be used once in ransomNote.
     */

    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "aab";
        System.out.println(canConstruct(s1, s2));
    }

    // BEATS 99%
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (char ch : magazine.toCharArray()) {
            arr[ch - 'a']++;
        }
        for (char ch : ransomNote.toCharArray()) {
            if (--arr[ch - 'a'] < 0) return false;
        }
        return true;
    }
}