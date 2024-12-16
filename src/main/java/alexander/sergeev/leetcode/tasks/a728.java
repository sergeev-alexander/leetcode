package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.List;

// 728. Self Dividing Numbers
public class a728 {

    /*
    A self-dividing number is a number that is divisible by every digit it contains.
    For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
    A self-dividing number is not allowed to contain the digit zero.
    Given two integers left and right,
    return a list of all the self-dividing numbers in the range [left, right] (both inclusive).
     */

    public static void main(String[] args) {
        int left = 1;
        int right = 22;
        System.out.println(selfDividingNumbers(left, right));
    }

    // BEATS 78%
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        MARK:
        for (int i = left; i <= right; i++) {
            int num = i;
            while (num > 0) {
                int divisor = num % 10;
                if (divisor == 0 || i % divisor != 0) continue MARK;
                num /= 10;
            }
            list.add(i);
        }
        return list;
    }
}