import java.util.HashMap;
import java.util.Map;

/**
 * 【前缀树】
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，
 * 用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 */
public class LC_208_Trie {

    static class TrieNode {
        public boolean beWord = false;
        public Map<Character, TrieNode> next = new HashMap<>();
    }

    private final TrieNode root;

    public LC_208_Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        int n = word.length();
        int i = 0;

        TrieNode node = root;

        while (i < n) {
            char a = word.charAt(i);

            if (!node.next.containsKey(a)) {
                TrieNode newNode = new TrieNode();
                newNode.beWord = false;
                node.next.put(a, newNode);
            }
            node = node.next.get(a);

            i++;
        }
        node.beWord = true;
    }

    public boolean search(String word) {
        int n = word.length();
        int i = 0;

        TrieNode node = root;
        while (i < n) {
            char a = word.charAt(i);
            if (!node.next.containsKey(a)) {
                return false;
            }
            node = node.next.get(a);
            i++;
        }

        return node.beWord;
    }

    public boolean startsWith(String prefix) {
        int n = prefix.length();
        int i = 0;

        TrieNode node = root;
        while (i < n) {
            char a = prefix.charAt(i);
            if (!node.next.containsKey(a)) {
                return false;
            }
            node = node.next.get(a);
            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        LC_208_Trie trie = new LC_208_Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
