package alexander.sergeev.leetcode.tasks;

// 1945. Sum of Digits of String After Convert
public class a1945 {

    /*
    You are given a string s consisting of lowercase English letters, and an integer k.
    Your task is to convert the string into an integer by a special process,
    and then transform it by summing its digits repeatedly k times. More specifically, perform the following steps:
    Convert s into an integer by replacing each letter with its position in the alphabet
    (i.e. replace 'a' with 1, 'b' with 2, ..., 'z' with 26).
    Transform the integer by replacing it with the sum of its digits.
    Repeat the transform operation (step 2) k times in total.
    For example, if s = "zbax" and k = 2, then the resulting integer would be 8 by the following operations:
    Convert: "zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
    Transform #1: 262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
    Transform #2: 17 ➝ 1 + 7 ➝ 8
    Return the resulting integer after performing the operations described above.
     */

    public static void main(String[] args) {
        String s = "leetcode";
        int k = 2;
        System.out.println(getLucky(s, k));
    }

    // BEATS 89%
    public static int getLucky(String s, int k) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a' + 1;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
        }
        k--;
        while (k > 0) {
            String str = String.valueOf(sum);
            sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            k--;
        }
        return sum;
    }
}