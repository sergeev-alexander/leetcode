package alexander.sergeev.leetcode.tasks;

// 520. Detect Capital
public class a520 {

    /*
    We define the usage of capitals in a word to be right when one of the following cases holds:
    All letters in this word are capitals, like "USA".
    All letters in this word are not capitals, like "leetcode".
    Only the first letter in this word is capital, like "Google".
    Given a string word, return true if the usage of capitals in it is right.
     */

    public static void main(String[] args) {

        String s = "EEE";
        System.out.println(detectCapitalUse(s));

    }

    public static boolean detectCapitalUse(String word) {
        boolean startsWithUpper = Character.isUpperCase(word.charAt(0));
        int lowerCount = 0;
        int upperCount = 0;
        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) upperCount++;
            else lowerCount++;
        }
        return startsWithUpper
                ? lowerCount == word.length() - 1 || upperCount == word.length() - 1
                : lowerCount == word.length() - 1;
    }

    public static boolean detectCapitalUse_SLOW(String word) {
        if (Character.isUpperCase(word.charAt(0))) {
            return word.chars()
                    .allMatch(Character::isUpperCase)
                    || word.substring(1).chars()
                    .allMatch(Character::isLowerCase);
        } else return word.chars()
                .allMatch(Character::isLowerCase);
    }
}
