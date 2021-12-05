import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean word = false;
}

public class StreamOfChars {

    TrieNode trie = new TrieNode();
    Deque<Character> stream = new ArrayDeque<>();

    public StreamOfChars(String[] words) {
        for (String word : words) {
            TrieNode node = trie;
            String revWord = new StringBuilder(word).reverse().toString();
            for (char key : revWord.toCharArray()) {
                if (!node.children.containsKey(key)) {
                    node.children.put(key, new TrieNode());
                }
                node = node.children.get(key);
            }
            node.word = true;
        }
    }

    public boolean query(char letter) {
        stream.addFirst(letter);
        TrieNode node = trie;
        for (char ch : stream) {
            if (node.word) {
                return true;
            }
            if (!node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }
        return node.word;
    }

    public static void main(String[] args) {
        String[] words = new String[] {
                "cde", "f", "kl", "c"
        };
        StreamOfChars obj = new StreamOfChars(words);
        System.out.println(obj.query('k'));
        System.out.println(obj.query('l'));
    }
}