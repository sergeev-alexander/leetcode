package alexander.sergeev;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Temp {

    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 1, 0};

        System.out.println(Arrays.toString(nums));
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int p0 = 0, curr = 0;
        int p2 = nums.length - 1;
        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            } else if (nums[curr] == 2) {
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            } else {
                curr++;
            }
        }
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

