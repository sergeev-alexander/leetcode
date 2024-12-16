package alexander.sergeev.leetcode.tasks;

// 208. Implement Trie (Prefix Tree)
public class a208 {

    /*
    A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve
    keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
    Implement the Trie class:
    Trie() Initializes the trie object.
    void insert(String word) Inserts the string word into the trie.
    boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before),
    and false otherwise.
    boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix,
    and false otherwise.
     */

    // BEATS 94%
    private final TireNode root;

    public a208() {
        root = new TireNode();
    }

    public void insert(String word) {
        TireNode current = root;
        for (char ch : word.toCharArray()) {
            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new TireNode();
            }
            current = current.children[ch - 'a'];
        }
        current.isLeaf = true;
    }

    public boolean search(String word) {
        TireNode current = root;
        for (char ch : word.toCharArray()) {
            if (current.children[ch - 'a'] == null) return false;
            current = current.children[ch - 'a'];
        }
        return current.isLeaf;
    }

    public boolean startsWith(String prefix) {
        TireNode current = root;
        for (char ch : prefix.toCharArray()) {
            if (current.children[ch - 'a'] == null) return false;
            current = current.children[ch - 'a'];
        }
        return true;
    }

    static class TireNode {

        TireNode[] children;
        boolean isLeaf;

        public TireNode() {
            this.children = new TireNode[26];
            this.isLeaf = false;
        }
    }
}
