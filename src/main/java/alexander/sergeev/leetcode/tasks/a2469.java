package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 2469. Convert the Temperature
public class a2469 {

    /*
    You are given a non-negative floating point number rounded to two decimal places celsius,
    that denotes the temperature in Celsius.
    You should convert Celsius into Kelvin and Fahrenheit and return it as an array ans = [kelvin, fahrenheit].
    Return the array ans. Answers within 10-5 of the actual answer will be accepted.
    Note that:
    Kelvin = Celsius + 273.15
    Fahrenheit = Celsius * 1.80 + 32.00
     */

    public static void main(String[] args) {
        double c = 122.11;
        System.out.println(Arrays.toString(convertTemperature(c)));
    }

    // BEATS 100%
    public static double[] convertTemperature(double celsius) {
        double[] arr = new double[2];
        arr[0] = celsius + 273.15;
        arr[1] = celsius * 1.80 + 32.00;
        return arr;
    }
}