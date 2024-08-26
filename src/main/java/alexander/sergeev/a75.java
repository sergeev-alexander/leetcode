package alexander.sergeev;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

// 75. Sort Colors
public class a75 {

    /*
    Given an array nums with n objects colored red, white, or blue,
    sort them in-place so that objects of the same color are adjacent,
    with the colors in the order red, white, and blue.
    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
    You must solve this problem without using the library's sort function.
     */

    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 1, 0};

        System.out.println(Arrays.toString(nums));
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    public static void sortColorsSLOW(int[] nums) {
        Map<Integer, Integer> map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), v -> 0, (o, n) -> o + 1, TreeMap::new));
        int numCount;
        int cellCount = 0;
        for (int number : map.keySet()) {
            numCount = map.get(number);
            while (numCount >= 0) {
                nums[cellCount] = number;
                numCount--;
                cellCount++;
            }
        }
    }
}
