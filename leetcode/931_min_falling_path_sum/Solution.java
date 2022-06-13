public class Solution {
    int n;
    int[][] m;
    Integer[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        n = matrix.length;
        this.m = matrix;
        memo = new Integer[m.length][m[0].length];

        int minFallingSum = Integer.MAX_VALUE;
        for (int col = 0; col < matrix.length; col++) {
            minFallingSum = Math.min(minFallingSum, recHelper(0, col));
        }
        return minFallingSum;
    }

    private int recHelper(int i, int j) {
        if (j < 0 || j == n) {
            return Integer.MAX_VALUE;
        }
        if (i == n - 1) {
            return m[i][j];
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int val = Math.min(
                recHelper(i + 1, j - 1),
                recHelper(i + 1, j));

        memo[i][j] = m[i][j] + Math.min(val, recHelper(i + 1, j + 1));
        return memo[i][j];
    }

    public static void main(String[] args) {
        // [[-80,-13,22],[83,94,-5],[73,-48,61]]
        int[][] m = { { -80, -13, 22 }, { 83, 94, -5 }, { 73, -48, 61 } };
        int a = new Solution().minFallingPathSum(m);
        System.out.println(a);
    }
}
