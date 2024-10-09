package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// 1748. Sum of Unique Elements
public class a1748 {

    /*
    You are given an integer array nums.
    The unique elements of an array are the elements that appear exactly once in the array.
    Return the sum of all the unique elements of nums.
     */

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5};
        System.out.println(sumOfUnique(nums));
    }

    // faster, but could be better
    public static int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else map.put(nums[i], 1);
            if (i != j) {
                if (map.containsKey(nums[j])) {
                    map.put(nums[j], map.get(nums[j]) + 1);
                } else map.put(nums[j], 1);
            }
        }
        int sum = 0;
        for (Integer num : map.keySet()) {
            if (map.get(num) == 1) {
                sum += num;
            }
        }
        return sum;
    }

    public static int sumOfUnique_SLOW(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), v -> 1, (o, n) -> o + 1, HashMap::new))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .mapToInt(Map.Entry::getKey)
                .sum();
    }
}
