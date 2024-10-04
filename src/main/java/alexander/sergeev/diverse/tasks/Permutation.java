package alexander.sergeev.diverse.tasks;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    /**
     * List permutations of a string.
     *
     * @param s the input string
     * @return the list of permutations
     */
    public List<String> permutation(String s) {
        // The result
        List<String> res = new ArrayList<>();
        // If input string length is 1, return {s}
        if (s.length() == 1) {
            res.add(s);
        } else if (s.length() > 1) {
            int lastIndex = s.length() - 1;
            // Find out the last character
            String last = s.substring(lastIndex);
            // Rest of the string
            String rest = s.substring(0, lastIndex);
            // Perform permutation on the rest string and
            // merge with the last character
            res = merge(permutation(rest), last);
        }
        return res;
    }

    /**
     * @param list a result of permutation, e.g. {"ab", "ba"}
     * @param c    the last character
     * @return a merged new list, e.g. {"cab", "acb" ... }
     */
    public List<String> merge(List<String> list, String c) {
        List<String> res = new ArrayList<>();
        // Loop through all the string in the list
        for (String s : list) {
            // For each string, insert the last character to all possible positions
            // and add them to the new list
            for (int i = 0; i <= s.length(); i++) {
                String ps = new StringBuffer(s).insert(i, c).toString();
                res.add(ps);
            }
        }
        return res;
    }
}
