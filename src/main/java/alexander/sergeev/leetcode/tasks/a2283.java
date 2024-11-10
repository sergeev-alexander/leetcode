package alexander.sergeev.leetcode.tasks;

// 2283. Check if Number Has Equal Digit Count and Digit Value
public class a2283 {

    /*
    You are given a 0-indexed string num of length n consisting of digits.
    Return true if for every index i in the range 0 <= i < n, the digit i occurs num[i] times in num,
    otherwise return false.
     */

    public static void main(String[] args) {
        String s = "1210";
        System.out.println(digitCount(s));
    }

    // BEATS 100%
    public static boolean digitCount(String num) {
        int[] freqArr = new int[10];
        char[] arr = num.toCharArray();
        for (char ch : num.toCharArray()) {
            freqArr[ch - 48]++;
        }
        for (int i = 0; i < num.length(); i++) {
            if (freqArr[i] != (int) arr[i] - 48) return false;
        }
        return true;
    }

    // BEATS 67%
    public static boolean digitCount1(String num) {
        int[] arr = new int[10];
        for (char ch : num.toCharArray()) {
            arr[ch - 48]++;
        }
        for (int i = 0; i < num.length(); i++) {
            int n = arr[num.charAt(i) - 48];
            if (arr[i] != Integer.parseInt(String.valueOf(num.charAt(i)))) return false;
        }
        return true;
    }
}