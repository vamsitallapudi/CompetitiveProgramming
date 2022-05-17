import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();
        this.backtrack(k, results, comb, 0, n);
        return results;
    }

    private void backtrack(int k, List<List<Integer>> sol, LinkedList<Integer> curr, int nextInd, int remain) {
        if (remain == 0 && curr.size() == k) {
            sol.add(new ArrayList<>(curr));
            return;
        } else if (curr.size() == k) {
            return;
        }
        for (int i = nextInd; i < 9; i++) {
            curr.add(i + 1);
            backtrack(k, sol, curr, i + 1, remain - (i + 1));
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> sol = new Solution().combinationSum3(3, 7);
        sol.forEach(System.out::println);
    }
}
