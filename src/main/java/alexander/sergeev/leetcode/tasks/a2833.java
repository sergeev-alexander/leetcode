package alexander.sergeev.leetcode.tasks;

// 2833. Furthest Point From Origin
public class a2833 {

    /*
    You are given a string moves of length n consisting only of characters 'L', 'R', and '_'.
    The string represents your movement on a number line starting from the origin 0.
    In the ith move, you can choose one of the following directions:
    move to the left if moves[i] = 'L' or moves[i] = '_'
    move to the right if moves[i] = 'R' or moves[i] = '_'
    Return the distance from the origin of the furthest point you can get to after n moves.
     */

    public static void main(String[] args) {
        String s = "_R__LL_";
        System.out.println(furthestDistanceFromOrigin(s));
    }

    // BEATS 100%
    public static int furthestDistanceFromOrigin(String moves) {
        int l = 0;
        int r = 0;
        int u = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'L' -> l++;
                case 'R' -> r++;
                case '_' -> u++;
                default -> throw new IllegalArgumentException();
            }
        }
        if (l > r) {
            return Math.abs(l + u - r);
        } else {
            return Math.abs(r + u - l);
        }
    }
}
