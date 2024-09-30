package alexander.sergeev.leetcode.tasks;

// 14. Longest Common Prefix
public class a14 {

    /*
    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".
     */

    public static void main(String[] args) {

        String[] s = {"flower","flower","flower"};

        System.out.println(longestCommonPrefix(s));
    }

    // Could be faster...
    public static String longestCommonPrefix(String[] strs) {
        int length =  strs[0].length();
        String result = "";
        for (int i = 0; i <= length; i++) {
            String prefix = strs[0].substring(0, i);
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(prefix)) {
                    return result;
                }
            }
            result = prefix;
        }
        return result;
    }
}


