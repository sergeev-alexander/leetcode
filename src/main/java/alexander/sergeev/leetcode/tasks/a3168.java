package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Set;
import java.util.TreeSet;

// 3168. Minimum Number of Chairs in a Waiting Room
public class a3168 {

    /*
    You are given a string s. Simulate events at each second i:
    If s[i] == 'E', a person enters the waiting room and takes one of the chairs in it.
    If s[i] == 'L', a person leaves the waiting room, freeing up a chair.
    Return the minimum number of chairs needed so that a chair is available
    for every person who enters the waiting room given that it is initially empty.
     */

    public static void main(String[] args) {

        String s = "ELEELEELLL";
        System.out.println(minimumChairs(s));
    }

    // SLOW...
    public static int minimumChairs(String s) {
        int[] arr = new int[s.length() + 1];
        arr[s.length()] = 0;
        int curr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E') {
                curr++;
            } else {
                curr--;
            }
            arr[i] = curr;
        }
        Arrays.sort(arr);
        return arr[arr.length - 1] - arr[0];
    }

    public static int minimumChairs_SLOW(String s) {
        Set<Integer> set  = new TreeSet<>();
        set.add(0);
        int curr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E') {
                curr++;
            } else {
                curr--;
            }
            set.add(curr);
        }
        IntSummaryStatistics stat = set.stream().mapToInt(Integer::intValue).summaryStatistics();
        return stat.getMax() - stat.getMin();
    }
}
