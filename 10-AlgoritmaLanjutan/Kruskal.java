import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalAlgorithm {

    // kelas untuk merepresentasikan sebuah sisi (edge) dalam graf
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + source + " -- " + destination + " : " + weight + ")";
        }
    }

    // kelas untuk merepresentasikan sebuah graf
    static class Graph {
        int vertices;
        List<Edge> allEdges;

        public Graph(int vertices) {
            this.vertices = vertices;
            allEdges = new ArrayList<>();
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            allEdges.add(edge);
        }
    }

    // kelas Union-Find (Disjoint Set Union) untuk mendeteksi siklus
    static class DisjointSet {
        int[] parent;

        public DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; // pada awalnya setiap elemen adalah parent dari dirinya sendiri
            }
        }
      
        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]); 
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootJ] = rootI;
            }
        }
    }

    public List<Edge> kruskalMST(Graph graph) {
        List<Edge> resultMST = new ArrayList<>();
        // mengurutkan semua sisi berdasarkan bobotnya secara menaik
        Collections.sort(graph.allEdges, Comparator.comparingInt(edge -> edge.weight));

        DisjointSet disjointSet = new DisjointSet(graph.vertices);

        int edgeCount = 0;
        int i = 0;
        // menambahkan V-1 sisi ke MST
        while (edgeCount < graph.vertices - 1 && i < graph.allEdges.size()) {
            Edge edge = graph.allEdges.get(i++);
            int rootSource = disjointSet.find(edge.source);
            int rootDestination = disjointSet.find(edge.destination);

            // jika menambahkan sisi tersebut tidak membentuk siklus
            if (rootSource != rootDestination) {
                resultMST.add(edge);
                disjointSet.union(rootSource, rootDestination);
                edgeCount++;
            }
        }
        return resultMST;
    }

    public static void main(String[] args) {
        int vertices = 4;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);

        KruskalAlgorithm kruskal = new KruskalAlgorithm();
        List<Edge> mst = kruskal.kruskalMST(graph);

        System.out.println("Sisi-sisi dalam Minimum Spanning Tree (MST):");
        int totalWeight = 0;
        for (Edge edge : mst) {
            System.out.println(edge);
            totalWeight += edge.weight;
        }
        System.out.println("Total bobot MST: " + totalWeight);
    }
}
