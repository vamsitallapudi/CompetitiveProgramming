import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> sol = new ArrayList<>();
        Arrays.sort(candidates);
        rec(0, candidates, target, sol, new ArrayList<>());
        return sol;
    }

    private void rec(int i, int[] arr, int t, List<List<Integer>> sol, List<Integer> curr) {
        if (t == 0) {
            sol.add(new ArrayList<>(curr));
            return;
        }
        for (int j = i; j < arr.length; j++) {
            if (j > i && arr[j] == arr[j - 1])
                continue;
            if (arr[j] > t)
                break;
            curr.add(arr[j]);
            rec(j + 1, arr, t - arr[j], sol, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
