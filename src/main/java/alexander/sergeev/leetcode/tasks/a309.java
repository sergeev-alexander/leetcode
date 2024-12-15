package alexander.sergeev.leetcode.tasks;

// 709. To Lower Case
public class a309 {

   /*
   Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
    */

    public static void main(String[] args) {
        String s = "al&phaBET";
        System.out.println(toLowerCase(s));

    }

    // BEATS 100%
    public static String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return new String(chars);
    }

    // BEATS 100%
    public static String toLowerCase1(String s) {
        return s.toLowerCase();
    }
}