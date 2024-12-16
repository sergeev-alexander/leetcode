package alexander.sergeev.leetcode.tasks;

// 744. Find Smallest Letter Greater Than Target
public class a744 {

    /*
    You are given an array of characters letters that is sorted in non-decreasing order, and a character target.
    There are at least two different characters in letters.
    Return the smallest character in letters that is lexicographically greater than target.
    If such a character does not exist, return the first character in letters.
     */

    public static void main(String[] args) {
        char[] arr = {'c', 'f', 'j'};
        char ch = 'c';
    }

    // BEATS 100%
    public char nextGreatestLetter(char[] letters, char target) {
        for (char ch : letters) {
            if (ch > target) return ch;
        }
        return letters[0];
    }
}