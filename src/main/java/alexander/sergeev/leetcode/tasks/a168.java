package alexander.sergeev.leetcode.tasks;

// 168. Excel Sheet Column Title
public class a168 {

    /*
    Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
     */

    public static void main(String[] args) {

        int num = 27;

        System.out.println(convertToTitle(num)); // AA
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) (((columnNumber) % 26) + 'A'));
            columnNumber = (columnNumber) / 26;
        }
        return sb.reverse().toString();
    }
}
