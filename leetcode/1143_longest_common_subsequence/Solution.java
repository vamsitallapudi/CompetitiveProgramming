import java.util.Arrays;

public class Solution {

    String t1, t2;
    int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }
        t1 = text1;
        t2 = text2;
        memo = new int[t1.length()][t2.length()];
        for (int[] i : memo) {
            Arrays.fill(i, -1);
        }
        return lcs(0, 0);
    }

    private int lcs(int a, int b) {
        if (a == t1.length() || b == t2.length()) {
            return 0;
        }
        if (memo[a][b] != -1) {
            return memo[a][b];
        }
        // option 1 -> no pick
        int o1 = lcs(a + 1, b);
        // option 2 -> pick
        int o2 = 0;
        // first occurance
        int fo = t2.indexOf(t1.charAt(a), b);
        if (fo != -1) {
            o2 = 1 + lcs(a + 1, fo + 1);
        }
        memo[a][b] = Math.max(o1, o2);
        return memo[a][b];
    }

    public static void main(String[] args) {
        int a = new Solution().longestCommonSubsequence("abcde", "ace");
        System.out.println(a);
    }
}
