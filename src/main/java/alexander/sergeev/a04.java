package alexander.sergeev;

import java.util.Arrays;

// 4. Median of Two Sorted Arrays
public class a04 {

    /*
    Given two sorted arrays nums1 and nums2 of size m and n respectively,
    return the median of the two sorted arrays.
    The overall run time complexity should be O(log (m+n)).
     */

    public static void main(String[] args) {

        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] resultArr = new int[nums1.length + nums2.length];

        for (int i = 0; i < nums1.length; i++)
            resultArr[i] = nums1[i];

        for (int i = nums1.length, j = 0; i < resultArr.length; i++, j++)
            resultArr[i] = nums2[j];

        Arrays.sort(resultArr);

        if (resultArr.length % 2 == 1)
            return resultArr[resultArr.length / 2];
        else
            return (resultArr[resultArr.length / 2 - 1] + resultArr[resultArr.length / 2]) / 2.0;
    }

    public static double findMedianSortedArraysFASTER(int[] nums1, int[] nums2) {
        double[] arr = new double[nums1.length + nums2.length];
        int j = 0;
        for (int i : nums1) arr[j++] = i;
        for (int i : nums2) arr[j++] = i;

        Arrays.sort(arr);

        if (arr.length % 2 == 0)
            return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
        else return arr[arr.length / 2];
    }
}

