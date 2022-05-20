import java.util.*;

public class Solution {

    private Map<Integer, List<Integer>> graph;
    private Map<Integer, Integer> rank;
    private Map<Pair<Integer, Integer>, Boolean> connDict;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        formGraph(n, connections);
        dfs(0, 0);
        List<List<Integer>> sol = new ArrayList<>();

        return sol;
    }

    private int dfs(int node, int discRank) {
        if (this.rank.get(node) != null) { // => node is already visited
            return this.rank.get(node);
        }
        // update the rank of this node
        this.rank.put(node, discRank);

        // this is the max we've seen till now
        int minRank = discRank + 1;
        for (int neighbour : this.graph.get(node)) {
            // skip the parent
            Integer neighRank = this.rank.get(neighbour);
            if (neighRank != null && neighRank == discRank - 1) {
                continue;
            }

            // recurse on the neighbour
            int recRank = dfs(neighbour, discRank + 1);

            // step 1 -> check if edge needs to be discarded
            if (recRank < discRank) {
                int sortedU = Math.min(node, neighbour), sortedV = Math.max(node, neighbour);
                this.connDict.remove(new Pair(sortedU, sortedV));
            }
            // step 2 -> update the min rank if needed
            minRank = Math.min(minRank, recRank);
        }
        return minRank;
    }

    private void formGraph(int n, List<List<Integer>> connections) {
        this.graph = new HashMap<>();
        this.rank = new HashMap<>();
        this.connDict = new HashMap<>();

        // Default rank for unvisited nodes is Null
        for (int i = 0; i < n; i++) {
            this.graph.put(i, new ArrayList<>());
            this.rank.put(i, null);
        }

        for (List<Integer> edge : connections) {
            // Bidirectional edges
            int u = edge.get(0), v = edge.get(1);
            this.graph.get(u).add(v);
            this.graph.get(v).add(u);

            int sortedU = Math.min(u, v), sortedV = Math.max(u, v);
            connDict.put(new Pair<Integer, Integer>(sortedU, sortedV), true);
        }

    }
}

private class Pair<K, V> {
    K key;
    V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
