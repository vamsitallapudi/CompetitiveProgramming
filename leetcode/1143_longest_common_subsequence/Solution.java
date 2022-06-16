import java.util.Arrays;

public class Solution {
    int[][] memo;
    private String text1;
    private String text2;

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.isEmpty() || text2.isEmpty())
            return 0;

        this.text1 = text1;
        this.text2 = text2;
        memo = new int[text1.length() + 1][text2.length() + 1];
        // filling array with -1
        for (int i = 0; i < memo.length - 1; i++) {
            Arrays.fill(memo[i], 0, memo[0].length - 1, -1);
        }
        return solve(0, 0);
    }

    private int solve(int i, int j) {
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // option 1 -> skip this char
        int option1 = solve(i + 1, j);
        // option 2 -> consider this char
        int option2 = 0;
        int firstOccurence = text2.indexOf(text1.charAt(i), j);
        if (firstOccurence != -1) {
            option2 = 1 + solve(i + 1, firstOccurence + 1);
        }
        memo[i][j] = Math.max(option1, option2);
        return memo[i][j];
    }

    public static void main(String[] args) {
        int a = new Solution().longestCommonSubsequence("abcde", "ace");
        System.out.println(a);
    }
}
