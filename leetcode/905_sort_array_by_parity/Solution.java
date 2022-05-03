import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int[] sortArrayByParity(int[] nums) {
        int[] sol = new int[nums.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i : nums) {
            if (i % 2 == 0)
                deque.push(i);
            else
                deque.add(i);
        }
        int i = 0;
        while (deque.size() > 0) {
            sol[i++] = deque.pop();
        }
        return sol;
    }
}
