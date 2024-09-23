package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

// 136. Single Number
public class a131 {

    /*
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
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

    public static int singleNumber_VERY_SLOW(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (list.contains(i)) {
                list.remove(Integer.valueOf(i));
            } else {
                list.add(i);
            }
        }
        return list.get(0);
    }
}
