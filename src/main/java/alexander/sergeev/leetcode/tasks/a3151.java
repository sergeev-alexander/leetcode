package alexander.sergeev.leetcode.tasks;

// 3151. Special Array I
public class a3151 {

    /*
    An array is considered special if every pair of its adjacent elements contains two numbers with different parity.
    You are given an array of integers nums. Return true if nums is a special array, otherwise, return false.
     */

    public static void main(String[] args) {

        int[] arr = {4,3,1,6};
        System.out.println(isArraySpecial(arr));
    }

    public static boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        for (int i = 1; i < nums.length; i++) {
            if (!((nums[i - 1] % 2 == 0 && nums[i] % 2 != 0) || (nums[i] % 2 == 0 && nums[i - 1] % 2 != 0))) {
                return false;
            }
        }
        return true;
    }
}
