package alexander.sergeev;

import java.util.*;


public class Temp1 {

    public static void main(String[] args) {
        int[] arr = {31,25,72,79,74};
        System.out.println(countBeautifulPairs(arr));
    }

    // BEATS 77%
    public static int countBeautifulPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int first = (int) (nums[i] / Math.pow(10, (int) (Math.log10(nums[i]))));
            for (int j = i + 1; j < nums.length; j++) {
                int second = nums[j] % 10;
                if (getGcd(first, second) == 1) count++;
            }
        }
        return count;
    }

    // remove static!
    private static int getGcd(int a, int b) {
        while (true) {
            if (a == 0) return b;
            if (b == 0) return a;
            if (a >= b) {
                a %= b;
            } else {
                b %= a;
            }
        }
    }
}
