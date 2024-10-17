package alexander.sergeev.leetcode.tasks;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

// 2848. Points That Intersect With Cars
public class a2848 {

    /*
    You are given a 0-indexed 2D integer array nums representing the coordinates of the cars parking on a number line.
    For any index i, nums[i] = [start i, end i] where start i is the starting point of the ith car and end i is the
    ending point of the ith car.
    Return the number of integer points on the line that are covered with any part of a car.
     */

    public static void main(String[] args) {
        List<List<Integer>> list = List.of(
                List.of(1, 5),
                List.of(3, 8));
        System.out.println(numberOfPoints(list));
    }

    // BEATS 100%
    public static int numberOfPoints(List<List<Integer>> nums) {
        final int maxLine = 100;
        int[] count = new int[maxLine + 2];
        for (List<Integer> num : nums) {
            final int start = num.get(0);
            final int end = num.get(1);
            ++count[start];
            --count[end + 1];
        }
        int ans = 0;
        int runningSum = 0;
        for (int i = 1; i <= maxLine; i++) {
            runningSum += count[i];
            if (runningSum > 0) {
                ++ans;
            }
        }
        return ans;
    }

    public static int numberOfPoints_BEATS_45_PERCENT(List<List<Integer>> nums) {
        Set<Integer> set = new HashSet<>();
        for (List<Integer> num : nums) {
            for (int j = num.get(0); j <= num.get(1); j++) {
                set.add(j);
            }
        }
        return set.size();
    }

    public static int numberOfPoints_BEATS_5_PERSET(List<List<Integer>> nums) {
        return (int) nums.stream()
                .flatMapToInt(list -> IntStream.range(list.get(0), list.get(1) + 1))
                .distinct()
                .count();
    }
}
