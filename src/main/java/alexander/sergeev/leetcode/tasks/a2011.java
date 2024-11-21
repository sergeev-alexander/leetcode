package alexander.sergeev.leetcode.tasks;

// 2011. Final Value of Variable After Performing Operations
public class a2011 {

    /*
    There is a programming language with only four operations and one variable X:
    ++X and X++ increments the value of the variable X by 1.
    --X and X-- decrements the value of the variable X by 1.
    Initially, the value of X is 0.
    Given an array of strings operations containing a list of operations,
    return the final value of X after performing all the operations.
     */

    public static void main(String[] args) {
        String[] ops = {"X++", "++X", "--X", "X--"};
        System.out.println(finalValueAfterOperations(ops));
    }

    // BEATS 100%
    public static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String s : operations) {
            if (s.contains("+")) x++;
            else x--;
        }
        return x;
    }
}