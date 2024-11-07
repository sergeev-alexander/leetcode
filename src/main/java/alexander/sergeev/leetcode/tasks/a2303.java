package alexander.sergeev.leetcode.tasks;

// 2303. Calculate Amount Paid in Taxes
public class a2303 {

    /*
    You are given a 0-indexed 2D integer array brackets where brackets[i] = [upperi, percenti] means
    that the ith tax bracket has an upper bound of upperi and is taxed at a rate of percenti.
    The brackets are sorted by upper bound (i.e. upperi-1 < upperi for 0 < i < brackets.length).
    Tax is calculated as follows:
    The first upper0 dollars earned are taxed at a rate of percent0.
    The next upper1 - upper0 dollars earned are taxed at a rate of percent1.
    The next upper2 - upper1 dollars earned are taxed at a rate of percent2.
    And so on.
    You are given an integer income representing the amount of money you earned.
    Return the amount of money that you have to pay in taxes.
    Answers within 10-5 of the actual answer will be accepted.
     */

    public static void main(String[] args) {
        int[][] brackets = {{3, 50}, {7, 10}, {12, 25}};
        int income = 10;
        System.out.println(calculateTax(brackets, income));
    }

    // BEATS 100%
    public static double calculateTax(int[][] brackets, int income) {
        if (income == 0) return 0.0;
        int count = 0;
        double tax = 0;
        int payed = 0;
        while (count < brackets.length) {
            int taxRate = brackets[count][1];
            int limit = brackets[count][0];
            if (income >= limit) {
                tax += (limit - payed) * (taxRate / 100.0);
            } else {
                tax += (income - payed) * (taxRate / 100.0);
                break;
            }
            payed += limit - payed;
            count++;
        }
        return tax;
    }
}