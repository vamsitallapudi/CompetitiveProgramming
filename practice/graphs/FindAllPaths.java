import java.util.*;

public class FindAllPaths {
    public static void main(String[] args) {

    }

    // Another problem - All paths from start to end
    public List<List<Integer>> allPaths(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, ans, path);
        return ans;
    }

    private void dfs(int[][] graph, int node, List<List<Integer>> ans, List<Integer> path) {
        if (node == graph.length - 1) {
            ans.add(path);
            return;
        }
        // list of neighbours are present in the row.
        // We will be iterating through them
        for (int nbr : graph[node]) {
            // backtracking
            // do
            path.add(nbr);
            // recurse
            dfs(graph, nbr, ans, path);
            // undo
            path.remove(path.size() - 1);
        }
    }
}
