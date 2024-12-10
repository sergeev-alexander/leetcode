package alexander.sergeev.leetcode.tasks;

// 605. Can Place Flowers
public class a605 {

    /*
    You have a long flowerbed in which some of the plots are planted, and some are not. However,
    flowers cannot be planted in adjacent plots.
    Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
    return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule
    and false otherwise.
     */

    public static void main(String[] args) {
        int[] arr = {1,0,0,0,1};
        int n = 2;
        System.out.println(canPlaceFlowers(arr, n));
    }

    // BEATS 96%
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int placeCount = 0;
        int zeroesCount = 0;
        if (flowerbed[0] == 0) zeroesCount++;
        for (int num : flowerbed) {
            if (zeroesCount == 3) {
                placeCount++;
                zeroesCount = 1;
            }
            if (num == 0) {
                zeroesCount++;
            } else zeroesCount = 0;
        }
        if (flowerbed[flowerbed.length - 1] == 0 && zeroesCount >= 2) placeCount++;
        return  placeCount >= n;
    }
}