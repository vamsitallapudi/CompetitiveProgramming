
import java.util.Arrays;




public class ClimbingStairs {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        if(n <= 1) return 1;
        int first = dp[n-1] !=-1 ? dp[n-1] : climbStairs(n-1);
        int second = dp[n-2] != -1 ? dp[n-2] : climbStairs(n-2);
        return dp[n] = first + second;
    }
    public static void main(String[] args) {
        System.out.println("" + new ClimbingStairs().climbStairs(1));
    }
}
