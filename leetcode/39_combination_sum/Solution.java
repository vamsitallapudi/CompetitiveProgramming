import java.util.ArrayList;
import java.util.List;

public class Solution {
    int[] a;
    int t;
    List<List<Integer>> sol = new ArrayList<>();;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.t = target;
        a = candidates;
        recHelper(0, new ArrayList<>());
        return sol;
    }

    private void recHelper(int i, List<Integer> curr) {
        int sum = curr.stream().reduce(0, (x, y) -> x + y);
        if (i == a.length || sum >= t) {
            if (sum == t) {
                sol.add(new ArrayList<>(curr));
            }
            return;
        }
        curr.add(a[i]);
        recHelper(i, curr);
        recHelper(i + 1, curr);
        curr.remove(curr.size() - 1);
        recHelper(i + 1, curr);
    }

    public static void main(String[] args) {
        int[] c = { 2, 3, 6, 7 };
        List<List<Integer>> sol = new Solution().combinationSum(c, 7);
        sol.forEach(System.out::println);
    }
}
