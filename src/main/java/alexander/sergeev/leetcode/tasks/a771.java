package alexander.sergeev.leetcode.tasks;

// 771. Jewels and Stones
public class a771 {

    /*
    You're given strings jewels representing the types of stones that are jewels,
    and stones representing the stones you have. Each character in stones is a type of stone you have.
    You want to know how many of the stones you have are also jewels.
    Letters are case sensitive, so "a" is considered a different type of stone from "A".
     */

    public static void main(String[] args) {
        String j = "aA";
        String s = "aAAbbbb";
        System.out.println(numJewelsInStones(j, s));
    }

    // BEATS 100%
    public static int numJewelsInStones(String jewels, String stones) {
        boolean[] arr = new boolean[123];
        for (char ch : jewels.toCharArray()) {
            arr[ch] = true;
        }
        int count = 0;
        for (char ch : stones.toCharArray()) {
            if (arr[ch]) count++;
        }
        return count;
    }
}