import java.util.*;

public class Solution {
    public int minDeletions(String s) {
        int sol = 0;
        int prev = 0;
        // putting values by frequencies in a map
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        // sorting map by value
        List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());

        Collections.sort(list, (i, j) -> j.getValue() - i.getValue());
        LinkedHashMap<Character, Integer> m = new LinkedHashMap<>();

        for (Map.Entry<Character, Integer> e : list) {
            m.put(e.getKey(), e.getValue());
        }

        // iterating and counting values that can be reduced.
        for (Map.Entry<Character, Integer> e : m.entrySet()) {
            if (prev != 0 && e.getValue() >= prev) {
                sol += e.getValue() - (prev - 1);
                e.setValue(prev - 1);
            }
            prev = e.getValue();
        }
        return sol;
    }

    public static void main(String[] args) {
        int a = new Solution().minDeletions("ceabaacb");
        System.out.println(a);
    }
}