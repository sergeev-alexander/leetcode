package alexander.sergeev.leetcode.tasks;

// 2287. Rearrange Characters to Make Target String
public class a2287 {

    /*
    You are given two 0-indexed strings s and target. You can take some letters from s and rearrange them to form new strings.
    Return the maximum number of copies of target that can be formed by taking letters from s and rearranging them.
     */

    public static void main(String[] args) {
        String s = "ilovecodingonleetcode";
        String target = "code";
        System.out.println(rearrangeCharacters(s, target));
    }

    // BEATS 100%
    public static int rearrangeCharacters(String s, String target) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        int count = 0;
        while (true) {
            for (int i = 0; i < target.length(); i++) {
                if (--arr[target.charAt(i) - 'a'] < 0) return count;
            }
            count++;
        }
    }
}