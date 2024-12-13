package alexander.sergeev.leetcode.tasks;

// 686. Repeated String Match
public class a686 {

    /*
    Given two strings a and b, return the minimum number of times you should repeat string a
    so that string b is a substring of it.
    If it is impossible for b to be a substring of a after repeating it, return -1.
    Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".
     */

    public static void main(String[] args) {
        String a = "abcbc";
        String b = "cabcbca";
        System.out.println(repeatedStringMatch(a, b));
    }

    // BEATS 89%
    public static int repeatedStringMatch(String a, String b) {
        if (b.isEmpty()) return 0;
        if (a.contains(b)) return 1;
        int[] arr = new int[120];
        for (char ch : a.toCharArray()) {
            arr[ch]++;
        }
        for (char ch : b.toCharArray()) {
            if (arr[ch] == 0) return -1;
        }
        int count = 1;
        int maxLength = Math.max(a.length(), b.length()) * 3;
        StringBuilder stringBuilder = new StringBuilder(a);
        while (stringBuilder.length() <= maxLength) {
            if (stringBuilder.toString().contains(b)) return count;
            stringBuilder.append(a);
            count++;
        }
        return -1;
    }

    // BEATS 89%
    public static int repeatedStringMatch2(String a, String b) {
        if (b.isEmpty()) return 0;
        if (a.contains(b)) return 1;
        int[] arr = new int[26];
        for (char ch : a.toCharArray()) {
            arr[ch - 'a']++;
        }
        for (char ch : b.toCharArray()) {
            if (arr[ch - 'a'] == 0) return -1;
        }
        int count = 1;
        int maxLength = Math.max(a.length(), b.length()) * 3;
        StringBuilder stringBuilder = new StringBuilder(a);
        while (stringBuilder.length() <= maxLength) {
            if (stringBuilder.toString().contains(b)) return count;
            stringBuilder.append(a);
            count++;
        }
        return -1;
    }

    // BEATS 86%
    public static int repeatedStringMatch1(String a, String b) {
        if (b.isEmpty()) return 0;
        if (a.contains(b)) return 1;
        for (char ch : b.toCharArray()) {
            if (!a.contains(String.valueOf(ch))) return -1;
        }
        int count = 1;
        int maxLength = Math.max(a.length(), b.length()) * 3;
        StringBuilder stringBuilder = new StringBuilder(a);
        while (stringBuilder.length() <= maxLength) {
            if (stringBuilder.toString().contains(b)) return count;
            stringBuilder.append(a);
            count++;
        }
        return -1;
    }
}