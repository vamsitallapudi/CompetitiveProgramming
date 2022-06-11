import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        Deque<Character> q = new ArrayDeque<>();
        int max = 0;
        for (char c : s.toCharArray()) {
            if (q.contains(c)) {
                while (!q.isEmpty()) {
                    char ch = q.removeFirst();
                    if (ch == c) {
                        break;
                    }
                }
            }
            q.add(c);
            max = Math.max(max, q.size());
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("bbb"));

    }
}
