package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

// 414. Third Maximum Number
public class a414 {

    /*
    Given an integer array nums, return the third distinct maximum number in this array.
    If the third maximum does not exist, return the maximum number.
     */

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        System.out.println(thirdMax(arr));
    }

    // BEATS 97%
    public static int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = num;
            }
            if (num < max && num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            }
            if (num < secondMax && num > thirdMax) {
                thirdMax = num;
            }
        }
        return thirdMax == Long.MIN_VALUE ? (int) max : (int) thirdMax;
    }

    // BEATS 83%
    public static int thirdMax3(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                continue;
            }
            if (num > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = num;
            }
            if (num != max && num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            }
            if (num != max && num != secondMax && num >= thirdMax) {
                thirdMax = num;
            }
        }
        return set.size() > 2 ? thirdMax : max;
    }

    // BEATS 83%
    public static int thirdMax2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (++count == 3) return nums[i];
        }
        return nums[nums.length - 1];
    }

    // BEATS 6%
    public static int thirdMax1(int[] nums) {
        return Arrays.stream(nums)
                .distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(2L)
                .findFirst()
                .orElse(Arrays.stream(nums)
                        .max()
                        .getAsInt());
    }
}