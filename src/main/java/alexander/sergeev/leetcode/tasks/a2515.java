package alexander.sergeev.leetcode.tasks;

// 2515. Shortest Distance to Target String in a Circular Array
public class a2515 {

    /*
    You are given a 0-indexed circular string array words and a string target.
    A circular array means that the array's end connects to the array's beginning.
    Formally, the next element of words[i] is words[(i + 1) % n] and the previous element of words[i] is words[(i - 1 + n) % n], where n is the length of words.
    Starting from startIndex, you can move to either the next word or the previous word with 1 step at a time.
    Return the shortest distance needed to reach the string target. If the string target does not exist in words, return -1.
     */

    public static void main(String[] args) {
        String[] arr = {"s", "hello", "r", "i", "am", "leetcode", "hello"};
        String target = "s";
        int start = 5;
        System.out.println(closetTarget(arr, target, start));
    }

    // BEATS 100%
    public static int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        for (int i = startIndex, j = startIndex, count = 0;
             count < n; count++, i = (i + 1) % n, j = (j - 1 + n) % n) {
            if (words[i].equals(target) || words[j].equals(target)) {
                return count;
            }
        }
        return -1;
    }
}