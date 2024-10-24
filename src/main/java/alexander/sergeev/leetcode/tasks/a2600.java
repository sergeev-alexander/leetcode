package alexander.sergeev.leetcode.tasks;

// 2600. K Items With the Maximum Sum
public class a2600 {

    /*
    There is a bag that consists of items, each item has a number 1, 0, or -1 written on it.
    You are given four non-negative integers numOnes, numZeros, numNegOnes, and k.
    The bag initially contains:
    numOnes items with 1s written on them.
    numZeroes items with 0s written on them.
    numNegOnes items with -1s written on them.
    We want to pick exactly k items among the available items.
    Return the maximum possible sum of numbers written on the items.
     */

    public static void main(String[] args) {
        int ones = 3;
        int zeroes = 2;
        int negs = 0;
        int k = 4;
        System.out.println(kItemsWithMaximumSum(ones, zeroes, negs, k));
    }

    // BEATS 100%
    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int result = 0;
        if (k > numOnes) {
            result += numOnes;
            k -= numOnes;
        } else return k;
        k -= numZeros;
        if (k < 0) {
            return result;
        } else return result - k;

    }

    // BEATS 87%
    public static int kItemsWithMaximumSum1(int numOnes, int numZeros, int numNegOnes, int k) {
        int result = 0;
        while (k > 0) {
            if (numOnes > 0) {
                result++;
                numOnes--;
                k--;
                continue;
            }
            if (numZeros > 0) {
                numZeros--;
                k--;
                continue;
            }
            if (numNegOnes > 0) {
                result--;
                numNegOnes--;
                k--;
            }
        }
        return result;
    }
}