import java.util.*;

public class Solution {
    public int[] findPermutation(String s) {
        int n = s.length() + 1;
        Stack<Integer> stack = new Stack<>();
        int[] sol = new int[n];
        int count = 0;
        int ind = 0;
        for (char a : s.toCharArray()) {
            if (a == 'D') {
                stack.push(++ind);
            } else {
                stack.push(++ind);
                while (!stack.isEmpty()) {
                    sol[count++] = stack.pop();
                }
            }
        }
        stack.push(n);
        while (!stack.isEmpty())
            sol[count++] = stack.pop();
        return sol;
    }
}