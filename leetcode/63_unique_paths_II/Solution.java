import java.util.*;

public class Solution {
    public static final int[][] dirs = { { 1, 0 }, { 0, 1 } };
    private int m, n, ans;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        ans = 0;
        // if the starting cell has obstacle, return as there would be no paths
        // to the destination
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        //

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(obstacleGrid, i, j);
            }
        }
        return ans;
    }

    private void dfs(int[][] mtrx, int i, int j) {

        if (i == m && j == n) {
            ans++;
            return;
        }
        if (mtrx[i][j] == 1) {
            return;
        }
        for (int[] d : dirs) {
            int x = i + d[0], y = i + d[1];
            if (0 <= x && x < m && 0 <= y && y < n) {
                dfs(mtrx, x, y);
            }
        }
    }
}
