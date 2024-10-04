package alexander.sergeev.leetcode.tasks;

import java.util.*;

// 30. Substring with Concatenation of All Words
public class a30 {

    /*
    You are given a string s and an array of strings words. All the strings of words are of the same length.
    A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
     */

    public static void main(String[] args) {

        String s = "aaaaaa";
        String[] arr = {"aa", "aa"};

        System.out.println(findSubstring(s, arr));

    }

    public static List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String w : words) {
            cnt.merge(w, 1, Integer::sum);
        }
        int m = s.length(), n = words.length;
        int k = words[0].length();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            Map<String, Integer> cnt1 = new HashMap<>();
            int l = i, r = i;
            int t = 0;
            while (r + k <= m) {
                String w = s.substring(r, r + k);
                r += k;
                if (!cnt.containsKey(w)) {
                    cnt1.clear();
                    l = r;
                    t = 0;
                    continue;
                }
                cnt1.merge(w, 1, Integer::sum);
                ++t;
                while (cnt1.get(w) > cnt.get(w)) {
                    String remove = s.substring(l, l + k);
                    l += k;
                    cnt1.merge(remove, -1, Integer::sum);
                    --t;
                }
                if (t == n) {
                    ans.add(l);
                }
            }
        }
        return ans;
    }

    public static List<String[]> list = new ArrayList<>();

    public static List<Integer> findSubstring_VERY_SLOW(String s, String[] words) {
        permute(words.length, words);
        List<Integer> indexes = new ArrayList<>();
        for (String[] arr : list) {
            String str = String.join("", arr);
            if (s.contains(str)) {
                if (s.indexOf(str) != s.lastIndexOf(str)) {
                    int pos = 0;
                    while (s.substring(pos).contains(str)) {
                        int index = s.substring(pos).indexOf(str);
                        indexes.add(index + pos);
                        pos++;
                    }
                } else indexes.add(s.indexOf(str));
            }
        }
        return indexes.stream()
                .distinct()
                .toList();
    }

    public static void permute(int n, String[] elements) {
        String[] arr = Arrays.copyOf(elements, elements.length);
        if (n == 1) {
            list.add(arr);
        } else {
            for (int i = 0; i < n - 1; i++) {
                permute(n - 1, elements);
                if (n % 2 == 0) {
                    swap(elements, i, n - 1);
                } else {
                    swap(elements, 0, n - 1);
                }
            }
            permute(n - 1, elements);
        }
    }

    private static void swap(String[] elements, int a, int b) {
        String tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
    }
}