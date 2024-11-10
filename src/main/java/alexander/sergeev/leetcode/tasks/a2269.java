package alexander.sergeev.leetcode.tasks;

// 2269. Find the K-Beauty of a Number
public class a2269 {

    /*
    The k-beauty of an integer num is defined as the number of substrings of num when it is read as a string
    that meet the following conditions:
    It has a length of k.
    It is a divisor of num.
    Given integers num and k, return the k-beauty of num.
    Note:
    Leading zeros are allowed.
    0 is not a divisor of any value.
    A substring is a contiguous sequence of characters in a string.
     */

    public static void main(String[] args) {
        int num = 430043;
        int k = 2;
        System.out.println(divisorSubstrings(num, k));
    }

    // BEATS 100%
    public static int divisorSubstrings(int num, int k) {
        int count = 0;
        String s = String.valueOf(num);
        int start = 0;
        while (k <= s.length()) {
            int tempNum = Integer.parseInt(s.substring(start++, k++));
            if (tempNum != 0 && num % tempNum == 0) count++;
        }
        return count;
    }
}