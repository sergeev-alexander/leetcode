package alexander.sergeev.leetcode.tasks;

import java.util.Arrays;

// 2706. Buy Two Chocolates
public class a2706 {

    /*
    You are given an integer array prices representing the prices of various chocolates in a store.
    You are also given a single integer money, which represents your initial amount of money.
    You must buy exactly two chocolates in such a way that you still have some non-negative leftover money.
    You would like to minimize the sum of the prices of the two chocolates you buy.
    Return the amount of money you will have leftover after buying the two chocolates.
    If there is no way for you to buy two chocolates without ending up in debt, return money.
    Note that the leftover must be non-negative.
     */

    public static void main(String[] args) {
        int[] arr = {98,54,6,34,66,63,52,39};
        int money = 62;
        System.out.println(buyChoco(arr, money)); // 22
    }

    // BEATS 100%
    public static int buyChoco(int[] prices, int money) {
        int maxRest = -1;
        int minPrise = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (money - minPrise - prices[i] >= 0) {
                maxRest = Math.max(maxRest, money - minPrise - prices[i]);
            }
            minPrise = Math.min(minPrise, prices[i]);
        }
        return maxRest >= 0 ? maxRest : money;
    }

    // BEATS 72%
    public static int buyChoco1(int[] prices, int money) {
        Arrays.sort(prices);
        int count = 0;
        int wasMoney = money;
        while (money >= 0 && count < 2) {
            money -= prices[count++];
        }
        return money >= 0 ? money : wasMoney;
    }
}