package miscellaneous.innerClass;

import java.util.Arrays;

public class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return rec(n, dp, heights);
    }

    private static int rec(int n, int[] dp, int[] h) {
        if (n == 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        int option1 = rec(n - 1, dp, h) + Math.abs(h[n] - h[n - 1]);
        int option2 = Integer.MAX_VALUE;
        if (n > 1)
            option2 = rec(n - 2, dp, h) + Math.abs(h[n] - h[n - 2]);
        return dp[n] = Math.min(option1, option2);
    }

    public static void main(String[] args) {
        int[] i = { 10, 20, 30, 10 };
        System.out.println(Solution.frogJump(1, i));
    }
}