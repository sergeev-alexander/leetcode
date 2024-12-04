package alexander.sergeev.leetcode.tasks;

// 451. Sort Characters By Frequency
public class a451 {

    /*
    Given a string s, sort it in decreasing order based on the frequency of the characters.
    The frequency of a character is the number of times it appears in the string.
    Return the sorted string. If there are multiple answers, return any of them.
     */

    public static void main(String[] args) {
        String s = "2a554442f544asfasssffffasss";
        System.out.println(frequencySort(s));
    }

    // BEATS 98%
    public static String frequencySort(String s) {
        int[] arr1 = new int[131];
        for (char ch : s.toCharArray()) {
            arr1[ch - '0']++;
        }
        int[] arr2 = new int[131];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i;
        }
        quickSort(arr1, arr2, 0, arr1.length - 1);
        int pos = arr1.length - 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (arr1[pos] != 0) {
            stringBuilder.append(String.valueOf(Character.valueOf((char) (arr2[pos] + '0'))).repeat(arr1[pos--]));
        }
        return stringBuilder.toString();
    }

    private static void quickSort(int[] arr1, int[] arr2, int leftIndex, int rightIndex) {
        if (arr1.length == 0 || leftIndex >= rightIndex) return;
        int pivot = arr1[(leftIndex + rightIndex) / 2];
        int leftMarkerIndex = leftIndex;
        int rightMarkerIndex = rightIndex;
        while (leftMarkerIndex <= rightMarkerIndex) {
            while (arr1[leftMarkerIndex] < pivot) leftMarkerIndex++;
            while (arr1[rightMarkerIndex] > pivot) rightMarkerIndex--;
            if (leftMarkerIndex <= rightMarkerIndex) {
                int temp = arr1[leftMarkerIndex];
                arr1[leftMarkerIndex] = arr1[rightMarkerIndex];
                arr1[rightMarkerIndex] = temp;
                int temp2 = arr2[leftMarkerIndex];
                arr2[leftMarkerIndex] = arr2[rightMarkerIndex];
                arr2[rightMarkerIndex] = temp2;
                leftMarkerIndex++;
                rightMarkerIndex--;
            }
        }
        if (leftIndex < rightMarkerIndex) quickSort(arr1, arr2, leftIndex, rightMarkerIndex);
        if (rightIndex > leftMarkerIndex) quickSort(arr1, arr2, leftMarkerIndex, rightIndex);
    }
}