import java.util.*;

public class L2Graphs {
    private class Vertex {
        HashMap<String, Integer> neighbours = new HashMap<>();
    }

    public class Pair<K, V> {
        K key;
        V value;
    }

    HashMap<String, Vertex> vertices;

    public L2Graphs() {
        vertices = new HashMap<>();
    }

    public void addVertex(String vname) {
        if (vertices.containsKey(vname)) {
            return;
        }
        Vertex vtx = new Vertex();
        vertices.put(vname, vtx);
    }

    public void addEdge(String vname1, String vname2, int cost) {
        Vertex vtx1 = vertices.get(vname1);
        Vertex vtx2 = vertices.get(vname2);
        if (vtx1 == null || vtx2 == null) {
            return;
        }
        if (!vtx1.neighbours.containsKey(vname2)) {
            vtx1.neighbours.put(vname2, cost);
        }
        if (!vtx2.neighbours.containsKey(vname1)) {
            vtx2.neighbours.put(vname1, cost);
        }
    }

    public void removeVertex(String vname) {
        Vertex vtx = vertices.get(vname);
        HashMap<String, Integer> neighbours = vtx.neighbours;
        List<String> keys = new ArrayList<>(neighbours.keySet());
        for (String key : keys) {
            // firstly removing the vertex node from the neighbours.
            Vertex neighbourVtx = vertices.get(key);
            neighbourVtx.neighbours.remove(vname);
        }
        vertices.remove(vname);
    }

    public void removeEdge(String vname1, String vname2) {

        Vertex vtx1 = vertices.get(vname1);
        Vertex vtx2 = vertices.get(vname2);
        if (vtx1 == null || vtx2 == null) {
            return;
        }
        if (vtx1.neighbours.containsKey(vname2)) {
            vtx1.neighbours.remove(vname2);
        }
        if (vtx2.neighbours.containsKey(vname1)) {
            vtx2.neighbours.remove(vname1);
        }
    }

    public void display() {
        System.out.println("############################");
        ArrayList<String> keys = new ArrayList<>(vertices.keySet());
        for (String key : keys) {
            String str = key + " => ";
            Vertex vtx = vertices.get(key);
            str += vtx.neighbours;
            System.out.println(str);
        }
        System.out.println("############################");
    }

    public void dfs() {
        HashMap<String, Boolean> processed = new HashMap<>();
        Stack<String> stack = new Stack<>();
        for (String key : vertices.keySet()) {
            if (processed.containsKey(key)) {
                continue;
            }
            stack.push(key);
            while (!stack.isEmpty()) {
                String myVal = stack.pop();
                if (processed.containsKey(myVal)) {
                    continue;
                }
                processed.put(myVal, true);
                System.out.println(myVal + " ");

                Vertex vertex = vertices.get(myVal);
                List<String> nbrs = new ArrayList<>(vertex.neighbours.keySet());
                for (String nbr : nbrs) {
                    if (!processed.containsKey(nbr)) {
                        stack.push(nbr);
                    }
                }
            }
        }
    }

    public void bfs() {
        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<String> queue = new LinkedList<>();

        for (String key : vertices.keySet()) {

            if (processed.containsKey(key)) {
                continue;
            }

            queue.add(key);

            while (!queue.isEmpty()) {

                String myEle = queue.removeFirst();

                if (processed.containsKey(myEle)) {
                    continue;
                }
                processed.put(myEle, true);
                System.out.println(myEle + " ");

                List<String> nbrs = new ArrayList<>(vertices.get(myEle).neighbours.keySet());
                for (String nbr : nbrs) {
                    if (!processed.containsKey(nbr)) {
                        queue.addLast(nbr);
                    }
                }
            }
        }
    }

    public boolean isConnected() {
        int flag = 0;
        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<String> queue = new LinkedList<>();
        for (String key : vertices.keySet()) {

            if (processed.containsKey(key)) {
                continue;
            }
            flag++;
            queue.add(key);
            while (!queue.isEmpty()) {
                String myEle = queue.removeFirst();
                if (processed.containsKey(myEle)) {
                    continue;
                }
                processed.put(myEle, true);
                List<String> nbrs = new ArrayList<>(vertices.get(myEle).neighbours.keySet());
                for (String nbr : nbrs) {
                    if (!processed.containsKey(nbr)) {
                        queue.addLast(nbr);
                    }
                }
            }
        }
        if (flag >= 2) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isCyclic() {
        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<String> queue = new LinkedList<>();

        for (String key : vertices.keySet()) {

            if (processed.containsKey(key)) {
                continue;
            }
            queue.add(key);
            while (!queue.isEmpty()) {
                String myEle = queue.removeFirst();
                if (processed.containsKey(myEle)) {
                    return true;
                }
                processed.put(myEle, true);
                System.out.println(myEle + " ");
                List<String> nbrs = new ArrayList<>(vertices.get(myEle).neighbours.keySet());
                for (String nbr : nbrs) {
                    if (!processed.containsKey(nbr)) {
                        queue.addLast(nbr);
                    }
                }
            }
        }
        return false;
    }

    public ArrayList<ArrayList<String>> getConnectedComponents() {
        // <A,B,C,D>, <E,F>
        ArrayList<ArrayList<String>> myAL = new ArrayList<>();
        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<String> queue = new LinkedList<>();

        for (String key : vertices.keySet()) {

            if (processed.containsKey(key)) {
                continue;
            }
            ArrayList<String> connList = new ArrayList<>();
            queue.add(key);
            while (!queue.isEmpty()) {
                String myEle = queue.removeFirst();
                if (processed.containsKey(myEle)) {
                    continue;
                }
                processed.put(myEle, true);
                connList.add(myEle);
                List<String> nbrs = new ArrayList<>(vertices.get(myEle).neighbours.keySet());
                for (String nbr : nbrs) {
                    if (!processed.containsKey(nbr)) {
                        queue.addLast(nbr);
                    }
                }
            }
            myAL.add(connList);
        }
        return myAL;
    }

    public boolean isTree() {
        return isConnected() && !isCyclic();
    }

    public boolean isBipartite() {
        // <node name, color>
        HashMap<String, String> processed = new HashMap<>();
        LinkedList<Pair<String, String>> queue = new LinkedList<>();

        for (String key : vertices.keySet()) {
            if (processed.containsKey(key)) {
                continue;
            }
            Pair<String, String> pair = new Pair<>();
            pair.key = key;
            pair.value = "red";
            queue.add(pair);

            while (!queue.isEmpty()) {

                // current pair
                Pair<String, String> cp = queue.removeFirst();

                if (processed.containsKey(cp.key)) {
                    String newColor = cp.value;
                    String obtainedColor = processed.get(cp.key);
                    if (!newColor.equals(obtainedColor))
                        return false;
                    continue;
                }
                processed.put(cp.key, cp.value);

                List<String> nbrs = new ArrayList<>(vertices.get(cp.key).neighbours.keySet());
                for (String nbr : nbrs) {
                    if (!processed.containsKey(nbr)) {
                        // neighbour pair
                        Pair<String, String> np = new Pair<>();
                        np.key = nbr;
                        // assigning opp. color to neighbours
                        np.value = cp.value.equals("red") ? "green" : "red";
                        queue.addLast(np);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        L2Graphs graphs = new L2Graphs();
        graphs.addVertex("A");
        graphs.addVertex("B");
        graphs.addVertex("C");
        graphs.addVertex("D");
        graphs.addVertex("E");
        graphs.addEdge("A", "B", 8);
        graphs.addEdge("B", "D", 2);
        graphs.addEdge("C", "E", 3);
        graphs.addEdge("A", "D", 1);
        graphs.addEdge("E", "B", 5);
        graphs.display();
        // graphs.dfs();
        graphs.bfs();
        System.out.println("Is Graph Connected ? " + graphs.isConnected());
        System.out.println("Is Graph Cyclic ? " + graphs.isCyclic());
        graphs.getConnectedComponents().stream().forEach(System.out::println);
    }
}
