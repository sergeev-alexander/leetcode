package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;
import java.util.Comparator;

// 1985. Find the Kth Largest Integer in the Array
public class a1985 {

    /*
    You are given an array of strings nums and an integer k.
    Each string in nums represents an integer without leading zeros.
    Return the string that represents the kth largest integer in nums.
    Note: Duplicate numbers should be counted distinctly. For example, if nums is ["1","2","2"],
    "2" is the first largest integer, "2" is the second-largest integer, and "1" is the third-largest integer.
     */

    public static void main(String[] args) {
        String[] arr = {"2","21","12","1"};
        int k = 3;
        System.out.println(kthLargestNumber(arr, k));
    }

    // BEATS 82%
    public static String kthLargestNumber(String[] nums, int k) {
        Comparator<String> comparator = (a, b) -> {
            if (a.length() > b.length()) return -1;
            if (b.length() > a.length()) return 1;
            int i = 0;
            int length = a.length() - 1;
            while (i < length & a.charAt(i) == b.charAt(i)) {
                i++;
            }
            return Character.compare(b.charAt(i), a.charAt(i));
        };
        Arrays.sort(nums, comparator);
        return nums[--k];
    }
}