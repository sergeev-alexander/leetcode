package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

// 137. Single Number II
public class a132 {

    /*
    Given an integer array nums where every element appears three times except for one, which appears exactly once.
    Find the single element and return it.
    You must implement a solution with a linear runtime complexity and use only constant extra space.
     */

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 2, 7};

        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), v -> 1, (oldValue, newValue) -> oldValue + 1))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .findFirst().get().getKey();
    }
}
