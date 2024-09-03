package alexander.sergeev.leetcode.tasks;

// 35. Search Insert Position
public class a35 {

    /*
    Given a sorted array of distinct integers and a target value,
    return the index if the target is found.
    If not, return the index where it would be if it were inserted in order.
    You must write an algorithm with O(log n) runtime complexity.
     */

    public static void main(String[] args) {

        int[] nums = {1, 3, 5};
        int target = 4;

        System.out.println(searchInsert(nums, target));

    }

    public static int searchInsertON(int[] nums, int target) {
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[0] > target)
                return 0;
            if (nums[i] == target)
                return i;
            if (i == nums.length - 1 && nums[i] < target || nums[i] < target && nums[i + 1] > target)
                return i + 1;
        }
        return result;
    }

    public static int searchInsert(int[] nums, int target) {
        int middle;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (nums[middle] == target) return middle;
            if (target < nums[middle]) right = middle - 1;
            else left = middle + 1;
        }
        return left;
    }
}
