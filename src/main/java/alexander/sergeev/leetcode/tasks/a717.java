package alexander.sergeev.leetcode.tasks;

// 717. 1-bit and 2-bit Characters
public class a717 {

    /*
    We have two special characters:
    The first character can be represented by one bit 0.
    The second character can be represented by two bits (10 or 11).
    Given a binary array bits that ends with 0, return true if the last character must be a one-bit character.
     */

    public static void main(String[] args) {
        int[] arr = {1,1,1,0};
        System.out.println(isOneBitCharacter(arr));
    }

    // BEATS 100%
    public static boolean isOneBitCharacter(int[] bits) {
        boolean isOneBitChar = true;
        for (int i = 0; i < bits.length - 1; i++) {
            if (bits[i] == 1) {
                isOneBitChar = !isOneBitChar;
            } else {
                isOneBitChar = true;
            }
        }
        return isOneBitChar;
    }
}