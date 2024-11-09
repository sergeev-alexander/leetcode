package alexander.sergeev.leetcode.tasks;

// 2288. Apply Discount to Prices
public class a2288 {

    /*
    A sentence is a string of single-space separated words where each word can contain digits, lowercase letters,
    and the dollar sign '$'. A word represents a price if it is a sequence of digits preceded by a dollar sign.
    For example, "$100", "$23", and "$6" represent prices while "100", "$", and "$1e5" do not.
    You are given a string sentence representing a sentence and an integer discount. For each word representing a price,
    apply a discount of discount% on the price and update the word in the sentence.
    All updated prices should be represented with exactly two decimal places.
    Return a string representing the modified sentence.
    Note that all prices will contain at most 10 digits.
     */

    public static void main(String[] args) {
        String s = "there are $1 $2 and 5$ candies in the shop";
        int disc = 50;
        System.out.println(discountPrices(s, disc));
    }

    // BEATS 74%
    public static String discountPrices(String sentence, int discount) {
        String[] arr = sentence.split(" ");
        MARK:
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].startsWith("$") && arr[i].length() > 1) {
                for(char ch : arr[i].substring(1).toCharArray()) {
                    if (!Character.isDigit(ch)) continue MARK;
                }
                double sum = Double.parseDouble(arr[i].substring(1));
                arr[i] = String.format("$%.2f", (sum - (sum * (discount / 100.0))));
            }
        }
        return String.join(" ", arr);
    }
}