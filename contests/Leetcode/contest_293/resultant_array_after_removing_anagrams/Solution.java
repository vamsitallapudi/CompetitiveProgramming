import java.util.*;

public class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> sol = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String word : words) {
            String sw = sort(word);
            if (!set.contains(sw)) {
                set.add(sw);
                sol.add(word);
            }
        }
        return sol;
    }

    private String sort(String s) {
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        return new String(ca);
    }

    public static void main(String[] args) {
        String[] words = { "abba", "baba", "bbaa", "cd", "cd" };
        List<String> list = new Solution().removeAnagrams(words);
        list.forEach(System.out::println);
    }
}
