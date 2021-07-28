import java.util.*;

public class Graphs {

    HashMap<String, Vertex> vertices;

    class Vertex {
        List<String> neighbours = new ArrayList<>();
    }

    Graphs() {
        vertices = new HashMap<>();
    }

    void addVertex(String vname) {
        if (vertices.containsKey(vname)) {
            return;
        }
        Vertex v = new Vertex();
        vertices.put(vname, v);
    }

    void addEdge(String vname1, String vname2) {
        Vertex v1 = vertices.get(vname1);
        Vertex v2 = vertices.get(vname2);
        if (v1 == null || v2 == null) {
            return;
        }
        if (!v1.neighbours.contains(vname2)) {
            v1.neighbours.add(vname2);
        }
        if (!v2.neighbours.contains(vname1)) {
            v2.neighbours.add(vname1);
        }
    }

    void removeVertex(String vname) {
        Vertex v = vertices.get(vname);
        if (v == null) {
            return;
        }
        for (String nbr : v.neighbours) {
            Vertex nbrVtx = vertices.get(nbr);
            if (nbrVtx.neighbours.contains(vname)) {
                nbrVtx.neighbours.remove(vname);
            }
        }
        vertices.remove(vname);
    }

    void removeEdge(String vname1, String vname2) {
        Vertex v1 = vertices.get(vname1);
        Vertex v2 = vertices.get(vname2);
        if (v1 == null || v2 == null) {
            return;
        }
        v1.neighbours.remove(vname2);
        v2.neighbours.remove(vname1);
    }

    void print() {
        for (Map.Entry<String, Vertex> entry : vertices.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue().neighbours);
        }
    }

    public static void main(String[] args) {
        Graphs graphs = new Graphs();
        graphs.addVertex("A");
        graphs.addVertex("B");
        graphs.addVertex("C");
        graphs.addVertex("D");
        graphs.addVertex("E");
        graphs.addEdge("A", "B");
        graphs.addEdge("B", "D");
        graphs.addEdge("C", "E");
        graphs.addEdge("A", "D");
        graphs.addEdge("E", "B");
        graphs.print();
        System.out.println("---- Removing Vertex E ----");
        graphs.removeVertex("E");
        graphs.print();
        System.out.println("---- Removing Edge from B to D----");
        graphs.removeEdge("B", "D");
        graphs.print();
    }
}
