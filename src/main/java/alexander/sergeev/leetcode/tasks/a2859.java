package alexander.sergeev.leetcode.tasks;

import java.util.List;

// 2859. Sum of Values at Indices With K Set Bits
public class a2859 {

    /*
    You are given a 0-indexed integer array nums and an integer k.
    Return an integer that denotes the sum of elements in nums whose corresponding indices have exactly k set bits
    in their binary representation.
    The set bits in an integer are the 1's present when it is written in binary.
    For example, the binary representation of 21 is 10101, which has 3 set bits.
     */

    public static void main(String[] args) {
        List<Integer> list = java.util.List.of(5,10,1,5,2);
        int k = 1;
        System.out.println(sumIndicesWithKSetBits(list, k));
    }

    // BEATS 100%
    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (Integer.bitCount(i) == k) {
                sum += nums.get(i);
            }
        }
        return sum;
    }
}