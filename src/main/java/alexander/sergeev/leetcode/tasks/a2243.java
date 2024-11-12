package alexander.sergeev.leetcode.tasks;

// 2243. Calculate Digit Sum of a String
public class a2243 {

    /*
    You are given a string s consisting of digits and an integer k.
    A round can be completed if the length of s is greater than k. In one round, do the following:
    Divide s into consecutive groups of size k such that the first k characters are in the first group,
    the next k characters are in the second group, and so on.
    Note that the size of the last group can be smaller than k.
    Replace each group of s with a string representing the sum of all its digits. For example,
    "346" is replaced with "13" because 3 + 4 + 6 = 13.
    Merge consecutive groups together to form a new string. If the length of the string is greater than k,
    repeat from step 1.
    Return s after all rounds have been completed.
     */

    public static void main(String[] args) {
        String s = "11111222223";
        int k = 3;
        System.out.println(digitSum(s,k));
    }

    // BEATS 84%
    public static String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < s.length()) {
                int sum = 0;
                for (int j = i, l = 0; l < k && j < s.length(); j++, l++) {
                    sum += s.charAt(j) - '0';
                    i++;
                }
                sb.append(sum);
            }
            s = sb.toString();
            sb = new StringBuilder();
        }
        return s;
    }

    // BEATS 84%
    public static String digitSum1(String s, int k) {
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < s.length()) {
                int sum = 0;
                for (int j = i, l = 0; l < k && j < s.length(); j++, l++) {
                    sum += Integer.parseInt(String.valueOf(s.charAt(j)));
                    i++;
                }
                sb.append(sum);
            }
            s = sb.toString();
            sb = new StringBuilder();
        }
        return s;
    }
}