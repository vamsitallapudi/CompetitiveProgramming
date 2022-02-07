import java.util.*;

public class LonelyNumber {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> sol = new ArrayList<>();
        int n = nums.length;
        if (n == 1) {
            sol.add(nums[0]);
            return sol;
        }
        Arrays.sort(nums);
        int prev = -1, next = 2, curr = 1;
        while (curr < n) {
            int i = nums[curr];
            if (prev < 0) {
                if (i < nums[next] + 1) {
                    sol.add(i);
                }
            } else if (next >= n) {
                if (i > nums[prev] + 1) {
                    sol.add(i);
                }
            } else (i > nums[prev] + 1 || i < nums[next] + 1) {
                sol.add(i);
            }
            prev++;
            next++;
            curr++;
        }
        return sol;
    }

    public static void main(String[] args) {
        LonelyNumber s = new LonelyNumber();
        List<Integer> sol = s.findLonely(new int[] { 10, 6, 5, 8 });
        for (Integer integer : sol) {
            System.out.println(integer);
        }
    }
}
