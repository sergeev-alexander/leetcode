package alexander.sergeev.leetcode.tasks;

// 670. Maximum Swap
public class a670 {

    /*
    You are given an integer num. You can swap two digits at most once to get the maximum valued number.
    Return the maximum valued number you can get.
     */

    public static void main(String[] args) {
        int num = 1993;
        System.out.println(maximumSwap(num));
    }

    // BEATS 100%
    public static int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int size = arr.length;
        int pos = 0;
        while (pos < size - 1) {
            int maxDigit = arr[pos];
            int maxPos = pos;
            for (int i = pos + 1; i < size; i++) {
                if (arr[i] >= maxDigit) {
                    maxDigit = arr[i];
                    maxPos = i;
                }
            }
            if (arr[pos] < maxDigit) {
                int temp = arr[pos];
                arr[pos] = arr[maxPos];
                arr[maxPos] = (char) temp;
                break;
            }
            pos++;
        }
        return Integer.parseInt(new String(arr));
    }

    // BEATS 100%
    public static int maximumSwap1(int num) {
        int size = (int) Math.log10(num) + 1;
        int copy = num;
        int[] arr = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            int digit = copy % 10;
            arr[i] = digit;
            copy /= 10;
        }
        int pos = 0;
        boolean is = false;
        while (pos < size - 1) {
            int maxDigit = arr[pos];
            int maxPos = pos;
            for (int i = pos + 1; i < size; i++) {
                if (arr[i] >= maxDigit) {
                    maxDigit = arr[i];
                    maxPos = i;
                }
            }
            if (arr[pos] < maxDigit) {
                int temp = arr[pos];
                arr[pos] = arr[maxPos];
                arr[maxPos] = temp;
                is = true;
                break;
            }
            pos++;
        }
        if (is) {
            int result = 0;
            for (int i : arr) {
                result += (int) (i * Math.pow(10, --size));
            }
            return result;
        } else return num;
    }
}