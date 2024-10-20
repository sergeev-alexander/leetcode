package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 2798. Number of Employees Who Met the Target
public class a2798 {

    /*
    There are n employees in a company, numbered from 0 to n - 1. Each employee i has worked for hours[i] hours in the company.
    The company requires each employee to work for at least target hours.
    You are given a 0-indexed array of non-negative integers hours of length n and a non-negative integer target.
    Return the integer denoting the number of employees who worked at least target hours.
     */

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int target = 3;
        System.out.println(numberOfEmployeesWhoMetTarget(arr, target));
    }

    // BEATS 100%
    public static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for(int num : hours) {
            if (num >= target) count++;
        }
        return count;
    }

    public static int numberOfEmployeesWhoMetTarget_BEATS_17_PECENT(int[] hours, int target) {
        return (int) Arrays.stream(hours)
                .filter(i -> i >= target)
                .count();
    }
}