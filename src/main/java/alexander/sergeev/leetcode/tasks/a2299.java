package alexander.sergeev.leetcode.tasks;

// 2299. Strong Password Checker II
public class a2299 {

    /*
    A password is said to be strong if it satisfies all the following criteria:
    It has at least 8 characters.
    It contains at least one lowercase letter.
    It contains at least one uppercase letter.
    It contains at least one digit.
    It contains at least one special character.
    The special characters are the characters in the following string: "!@#$%^&*()-+".
    It does not contain 2 of the same character in adjacent positions (i.e., "aab" violates this condition, but "aba" does not).
    Given a string password, return true if it is a strong password. Otherwise, return false.
     */

    public static void main(String[] args) {
        String s = "IloveLe3tcode!";
        System.out.println(strongPasswordCheckerII(s));
    }

    // BEATS 100%
    public static boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;
        String spetial = "!@#$%^&*()-+";
        boolean hasDigit = false;
        boolean hasSpetial = false;
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        char prev = (char) -1;
        for (char ch : password.toCharArray()) {
            if (ch == prev) return false;
            prev = ch;
            if (ch >= '0' && ch <= '9') {
                hasDigit = true;
            } else if (spetial.indexOf(ch) >= 0) {
                hasSpetial = true;
            } else if (ch >= 'a' && ch <= 'z') {
                hasLowerCase = true;
            } else if (ch >= 'A' && ch <= 'Z') {
                hasUpperCase = true;
            }
        }
        return hasDigit && hasSpetial && hasLowerCase && hasUpperCase;
    }

    // BEATS 89%
    public static boolean strongPasswordCheckerII1(String password) {
        if (password.length() < 8) return false;
        String spetial = "!@#$%^&*()-+";
        boolean hasDigit = false;
        boolean hasSpetial = false;
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        char prev = (char) -1;
        for (char ch : password.toCharArray()) {
            if (ch == prev) return false;
            prev = ch;
            if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (spetial.contains(String.valueOf(ch))) {
                hasSpetial = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
            } else if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            }
        }
        return hasDigit && hasSpetial && hasLowerCase && hasUpperCase;
    }
}