import java.util.*;

public class Solution {
    Map<Integer, String> map = new HashMap<>();

    public String greatestLetter(String s) {
        Set<Character> set = new HashSet<>();
        for (Character c : s.toCharArray()) {
            set.add(c);
        }
        for (Character c : s.toCharArray()) {
            int ascii = (int) c;
            if (ascii >= 65 && ascii <= 90) {
                if (set.contains(Character.toLowerCase(c))) {
                    map.put((int) c, Character.toString(c));
                }
            } else if (ascii >= 97 && ascii <= 122) {
                char uc = Character.toUpperCase(c);
                if (set.contains(uc)) {
                    map.put((int) uc, Character.toString(uc));
                }
            }
        }
        int max = -1;
        for (Integer entry : map.keySet()) {
            if (entry > max) {
                max = entry;
            }
        }
        if (max > -1) {
            return map.get(max);
        }
        return "";
    }

    public static void main(String[] args) {
        String s = new Solution().greatestLetter("arRAzFif");
        System.out.println(s);
    }
}
