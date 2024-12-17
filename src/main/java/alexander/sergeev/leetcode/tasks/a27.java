package alexander.sergeev.leetcode.tasks;

// 27. Remove Element
public class a27 {

    /*
    Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
    The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
    Consider the number of elements in nums which are not equal to val be k, to get accepted,
    you need to do the following things:
    Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
    The remaining elements of nums are not important as well as the size of nums.
    Return k.
     */

    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(arr, val));
    }

    // BEATS 100%
    public static int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (left <= right) {
            while (left < nums.length && nums[left] != val) {
                left++;
                count++;
            }
            while (right >= 0 && nums[right] == val) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return count;
    }
}