package alexander.sergeev.leetcode.tasks;

import java.util.HashSet;
import java.util.Set;

// 575. Distribute Candies
public class a575 {

    /*
    Alice has n candies, where the ith candy is of type candyType[i].
    Alice noticed that she started to gain weight, so she visited a doctor.
    The doctor advised Alice to only eat n / 2 of the candies she has (n is always even).
    Alice likes her candies very much, and she wants to eat the maximum number of different types of candies
    while still following the doctor's advice.
    Given the integer array candyType of length n, return the maximum number of different types of candies
    she can eat if she only eats n / 2 of them.
     */

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3};
        System.out.println(distributeCandies(arr));
    }

    // BEATS 97%
    public static int distributeCandies(int[] candyType) {
        boolean[] arr = new boolean[200_001];
        int count = 0;
        for (int num : candyType) {
            if (count >= candyType.length / 2) return count;
            if (!arr[num + 100_000]) count++;
            arr[num + 100_000] = true;
        }
        return count;
    }

    // BEATS 93%
    public static int distributeCandies1(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int num : candyType) {
            if (count >= candyType.length / 2) {
                break;
            }
            if (set.add(num)) count++;
        }
        return count;
    }
}