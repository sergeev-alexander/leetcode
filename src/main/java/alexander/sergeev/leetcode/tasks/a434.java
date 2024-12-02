package alexander.sergeev.leetcode.tasks;

// 434. Number of Segments in a String
public class a434 {

    /*
    Given a string s, return the number of segments in the string.
    A segment is defined to be a contiguous sequence of non-space characters.
     */

    public static void main(String[] args) {
        String s = ", , , ,        a, eaefa";
        System.out.println(countSegments(s));
    }

    // BEATS 100%
    public static int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }
        return count;
    }
}