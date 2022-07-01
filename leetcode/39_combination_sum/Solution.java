import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> sol = new ArrayList<>();
        rec(0, candidates, target, sol, new ArrayList<>());
        return sol;
    }

    private void rec(int i, int[] c, int t, List<List<Integer>> sol, List<Integer> curr) {
        if (t == 0) {
            sol.add(new ArrayList<>(curr));
            return;
        }
        if (i == c.length) {
            return;
        } // base case

        // pick
        if (c[i] <= t) {
            curr.add(c[i]);
            rec(i, c, t - c[i], sol, curr);
            curr.remove(curr.size() - 1);
        }

        // no pick
        rec(i + 1, c, t, sol, curr);
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new Solution().combinationSum(new int[] { 2, 3, 6, 7 }, 7);
        for (List<Integer> list : ans) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
