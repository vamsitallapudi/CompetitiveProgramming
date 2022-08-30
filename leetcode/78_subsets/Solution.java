import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        rec(0, nums, sol, new ArrayList<>());
        return sol;
    }

    private void rec(int i, int[] nums, List<List<Integer>> sol, List<Integer> curr) {
        if (i == nums.length) {
            sol.add(new ArrayList<>(curr));
            return;
        }

        // pick
        curr.add(nums[i]);
        rec(i + 1, nums, sol, curr);

        // no pick
        curr.remove(curr.size() - 1);
        rec(i + 1, nums, sol, curr);
    }

    public static void main(String[] args) {
        List<List<Integer>> sol = new Solution().subsets(new int[] { 1, 2, 3 });
        for (List<Integer> l : sol) {
            l.stream().forEach(System.out::print);
            System.out.println();
        }
    }
}
