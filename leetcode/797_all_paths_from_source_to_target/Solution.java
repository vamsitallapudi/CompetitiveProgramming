import java.util.*;

public class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, path, sol, graph);
        return sol;
    }

    private void dfs(int i, List<Integer> path, List<List<Integer>> sol, int[][] graph) {
        if (i == graph.length - 1) {
            sol.add(path);
            return;
        }
        for (int child : graph[i]) {
            path.add(child);
            List<Integer> temp = path;
            dfs(child, temp, sol, graph);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String args[]) {
        int[][] graph = { { 1, 2 }, { 3 }, { 3 }, {} };

        Solution obj = new Solution();
        List<List<Integer>> sol = obj.allPathsSourceTarget(graph);
        for (List<Integer> list : sol) {
            list.stream().forEach(System.out::print);
            System.out.println();
        }

    }
}
