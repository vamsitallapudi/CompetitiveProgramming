import java.util.*;

public class Solution {
    public int longestStrChain(String[] words) {
        Set<String> wordsSet = new HashSet<>();
        Arrays.stream(words).forEach(w -> wordsSet.add(w));
        Map<String, Integer> memo = new HashMap<>();
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            max = Math.max(max, chain(wordsSet, memo, words[i]));
        }
        return max;
    }

    public int chain(Set<String> words, Map<String, Integer> memo, String currWord) {
        if (memo.get(currWord) != null) {
            return memo.get(currWord);
        }
        int max = 1;
        StringBuilder sb = new StringBuilder(currWord);
        for (int i = 0; i < sb.length(); i++) {
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            if (words.contains(newWord)) {
                max = Math.max(max, 1 + chain(words, memo, newWord));
            }
            sb.insert(i, currWord.charAt(i));
        }
        return max;
    }

    public static void main(String[] args) {
        int a = new Solution().longestStrChain(new String[] { "bdca", "bca" });
        System.out.println(a);
    }
}