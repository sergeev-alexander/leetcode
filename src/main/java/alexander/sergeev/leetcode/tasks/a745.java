package alexander.sergeev.leetcode.tasks;


import java.util.ArrayList;
import java.util.List;

// 745. Prefix and Suffix Search
public class a745 {

    /*
    Design a special dictionary that searches the words in it by a prefix and a suffix.
    Implement the WordFilter class:
    WordFilter(string[] words) Initializes the object with the words in the dictionary.
    f(string pref, string suff) Returns the index of the word in the dictionary,
    which has the prefix pref and the suffix suff. If there is more than one valid index, return the largest of them.
    If there is no such word in the dictionary, return -1.
     */

    // BEATS 98%
    private final TrieNode prefixRoot;
    private final TrieNode suffixRoot;

    public a745(String[] words) {
        prefixRoot = new TrieNode();
        suffixRoot = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            insert(words[i], i);
        }
    }

    private void insert(String word, int index) {
        char[] arr = word.toCharArray();
        int n = arr.length;
        TrieNode currentPref = prefixRoot;
        TrieNode currentSuff = suffixRoot;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (currentPref.childrenArr[arr[i] - 'a'] == null) {
                currentPref.childrenArr[arr[i] - 'a'] = new TrieNode();
            }
            currentPref = currentPref.childrenArr[arr[i] - 'a'];
            currentPref.indexList.add(index);
            if (currentSuff.childrenArr[arr[j] - 'a'] == null) {
                currentSuff.childrenArr[arr[j] - 'a'] = new TrieNode();
            }
            currentSuff = currentSuff.childrenArr[arr[j] - 'a'];
            currentSuff.indexList.add(index);
        }
    }

    public int f(String pref, String suff) {
        TrieNode currentPref = prefixRoot;
        char[] prefArr = pref.toCharArray();
        for (char ch : prefArr) {
            if (currentPref.childrenArr[ch - 'a'] == null) return -1;
            currentPref = currentPref.childrenArr[ch - 'a'];
        }
        List<Integer> prefList = currentPref.indexList;
        if (prefList.isEmpty()) return -1;
        TrieNode currentSuff = suffixRoot;
        char[] suffArr = suff.toCharArray();
        for (int i = suffArr.length - 1; i >= 0; i--) {
            if (currentSuff.childrenArr[suffArr[i] - 'a'] == null) return -1;
            currentSuff = currentSuff.childrenArr[suffArr[i] - 'a'];
        }
        List<Integer> suffList = currentSuff.indexList;
        if (suffList.isEmpty()) return -1;
        int prefIndexPos = prefList.size() - 1;
        int suffIndexPos = suffList.size() - 1;
        while (prefIndexPos >= 0 && suffIndexPos >= 0) {
            int a = prefList.get(prefIndexPos);
            int b = suffList.get(suffIndexPos);
            if (a == b) return a;
            if (a > b) prefIndexPos--;
            else suffIndexPos--;
        }
        return -1;
    }

    static class TrieNode {

        TrieNode[] childrenArr;
        List<Integer> indexList;

        public TrieNode() {
            indexList = new ArrayList<>();
            childrenArr = new TrieNode[26];
        }
    }
}