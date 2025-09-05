import java.util.*;

public class MaxSumOfNonAdjEle {
    public int nonAdj(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return rec(dp,nums.length-1, nums);
    }
    private int rec(int[] dp, int i, int[] n) {
        //base cases
        if(i ==0) return n[0];
        if(i<0) return 0;
        // check if dp[i] is already computed and return
        if(dp[i] != -1) return dp[i];
        //picking current element
        int pick = n[i] + rec(dp, i-2, n);
        // skipping current element
        int nonPick = rec(dp, i-1, n);
        // memoizing current index max value by storing in dp
        return dp[i] = Math.max(pick, nonPick);
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String line = sc.nextLine();
            // split by spaces and parse
            String[] parts = line.trim().split(" ");
            int n = parts.length;
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            System.out.println(new MaxSumOfNonAdjEle().nonAdj(arr));
        }
    }
}
