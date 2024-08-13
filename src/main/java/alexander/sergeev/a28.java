package alexander.sergeev;

// 28. Find the Index of the First Occurrence in a String
public class a28 {

    /*
    Given two strings needle and haystack,
    return the index of the first occurrence of needle in haystack,
    or -1 if needle is not part of haystack.
     */

    public static void main(String[] args) {

        System.out.println(strStr("hello", "ll"));

    }

    public static int strStr(String haystack, String needle) {
        if (haystack.contains(needle))
            return haystack.indexOf(needle);
        else return -1;
    }

    public static int strStr1(String haystack, String needle) {
        if (haystack.length() < needle.length())
            return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
                if (j == needle.length())
                    return i;
            }
        }
        return -1;
    }

}

