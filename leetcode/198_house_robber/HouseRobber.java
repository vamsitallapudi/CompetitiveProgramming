import java.util.Arrays;

/**
 * HouseRobber
 */
public class HouseRobber {
    // using memoization technique for repetitive parts
    private int[] memo;

    public int rob(int[] nums) {
        this.memo = new int[100];
        Arrays.fill(this.memo, -1);
        return robFrom(0, nums);
    }

    private int robFrom(int i, int[] houses) {
        // edge case
        // check if any houses left
        if (i >= houses.length) {
            return 0;
        }
        // check if value is already calculated (if its present in memo)
        if (memo[i] > -1) {
            return memo[i];
        }

        int ans = Math.max(robFrom(i + 1, houses), robFrom(i + 2, houses) + houses[i]);
        this.memo[i] = ans;
        return ans;
    }
}
