import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimAlgorithm {

    // kelas untuk merepresentasikan sebuah sisi (edge) dalam graf
    static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    // kelas untuk merepresentasikan sebuah graf
    static class Graph {
        int vertices;
        // Adjacency list untuk menyimpan graf dan ArrayList<Edge> untuk setiap vertex
        // graph[i] akan berisi daftar sisi yang terhubung dari vertex i
        private java.util.ArrayList<Edge>[] adjacencylist;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new java.util.ArrayList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencylist[i] = new java.util.ArrayList<>();
            }
        }

        public void addEdge(int source, int destination, int weight) {
            // untuk graf tidak berarah, tambahkan sisi di kedua arah
            Edge edge = new Edge(destination, weight);
            adjacencylist[source].add(edge);

            Edge reverseEdge = new Edge(source, weight);
            adjacencylist[destination].add(reverseEdge);
        }
    }

    // kelas untuk menyimpan informasi tentang vertex saat diproses oleh Prim
    static class Node {
        int vertex;
        int key;

        public Node(int vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }
    }

    public int[] primMST(Graph graph) {
        int vertices = graph.vertices;
        int[] parent = new int[vertices];
        int[] key = new int[vertices];   
        boolean[] inMST = new boolean[vertices];

        // inisialisasi key dengan nilai tak hingga dan inMST dengan false
        for (int i = 0; i < vertices; i++) {
            key[i] = Integer.MAX_VALUE;
            inMST[i] = false;
        }

        // PriorityQueue untuk menyimpan Node berdasarkan key (bobot) terkecil
        // memerlukan Comparator karena Node adalah objek kustom
        PriorityQueue<Node> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(node -> node.key));

        key[0] = 0; // bobot ke vertex awal adalah 0
        parent[0] = -1; // vertex awal tidak punya parent (akar MST)
        pq.add(new Node(0, key[0]));

        // loop sampai priority queue kosong atau kita sudah menambahkan V-1 sisi ke MST
        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;

            // jika vertex sudah ada di MST, lewati
            if (inMST[u]) {
                continue;
            }

            inMST[u] = true;

            // iterasi melalui semua tetangga dari vertex u
            for (Edge edge : graph.adjacencylist[u]) {
                int v = edge.destination;
                int weight = edge.weight;

                // jika v belum ada di MST dan bobot sisi (u,v) lebih kecil dari key[v] saat ini
                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                    pq.add(new Node(v, key[v]));
                }
            }
        }
        return parent;
    }

    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        PrimAlgorithm prim = new PrimAlgorithm();
        int[] parent = prim.primMST(graph);

        System.out.println("Sisi-sisi dalam Minimum Spanning Tree (MST):");
        int totalWeight = 0;
      
        for (int i = 1; i < vertices; i++) {
            for (Edge edge : graph.adjacencylist[parent[i]]) {
                if (edge.destination == i) {
                    System.out.println(parent[i] + " -- " + i + " : " + edge.weight);
                    totalWeight += edge.weight;
                    break; // Sisi ditemukan, keluar dari loop
                }
            }
        }
        System.out.println("Total bobot MST: " + totalWeight);
    }
}
