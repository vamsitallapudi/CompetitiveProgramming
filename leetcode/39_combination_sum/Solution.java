import java.util.ArrayList;
import java.util.List;

public class Solution {
    int[] a;
    List<List<Integer>> sol = new ArrayList<>();;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        a = candidates;
        recHelper(0, target, new ArrayList<>());
        return sol;
    }

    private void recHelper(int i, int target, List<Integer> curr) {
        if (i == a.length) {
            if (target == 0) {
                sol.add(new ArrayList<>(curr));
            }
            return;
        }
        // pick
        if (a[i] <= target) {
            curr.add(a[i]);
            recHelper(i, target - a[i], curr);
            curr.remove(curr.size() - 1);
        }
        // non pick
        recHelper(i + 1, target, curr);
    }

    public static void main(String[] args) {
        int[] c = { 2, 3, 6, 7 };
        List<List<Integer>> sol = new Solution().combinationSum(c, 7);
        sol.forEach(System.out::println);
    }
}
