package alexander.sergeev.diverse.tasks;

public class SumOfTwoNumericStrings {

    public static void main(String[] args) {

        String a = "1111";
        String b = "11";

        System.out.println(sumStrings(a, b));
    }

    public static String sumStrings(String a, String b) {
        if (a.isBlank()) return b;
        if (b.isBlank()) return a;
        String big = a.length() >= b.length() ? a : b;
        String small = a.length() < b.length() ? a : b;
        int overTen = 0;
        int currentSmallPos = small.length() - 1;
        int currentBigPos = big.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (currentSmallPos >= 0) {
            int i = Integer.parseInt(String.valueOf(big.charAt(currentBigPos))) + Integer.parseInt(String.valueOf(small.charAt(currentSmallPos)));
            i += overTen;
            if (i < 9) {
                sb.append(i);
                overTen = 0;
            } else {
                sb.append(i % 10);
                overTen = i / 10;
            }
            currentSmallPos--;
            currentBigPos--;
        }
        while (currentBigPos >= 0) {
            int i = Integer.parseInt(String.valueOf(big.charAt(currentBigPos))) + overTen;
            if (i < 9) {
                sb.append(i);
                overTen = 0;
            } else {
                sb.append(i % 10);
                overTen = i / 10;
            }
            currentBigPos--;
        }
        if (overTen > 0) {
            sb.append(overTen);
        }
        sb.reverse();
        while (true) {
            if (sb.charAt(0) == '0') {
                sb = new StringBuilder(sb.substring(1));
            } else return sb.toString();
        }
    }
}
