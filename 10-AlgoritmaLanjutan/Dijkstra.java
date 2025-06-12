import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        private java.util.ArrayList<Edge>[] adjacencylist;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new java.util.ArrayList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencylist[i] = new java.util.ArrayList<>();
            }
        }

        public void addEdge(int source, int destination, int weight) {
            adjacencylist[source].add(new Edge(destination, weight));
            adjacencylist[destination].add(new Edge(source, weight));
        }
    }

    // kelas untuk menyimpan informasi tentang vertex saat diproses oleh Dijkstra
    static class Node implements Comparable<Node> {
        int vertex;
        int distance; // Jarak dari sumber ke vertex ini

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        // implementasi Comparable untuk PriorityQueue (mengurutkan berdasarkan jarak)
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public int[] dijkstra(Graph graph, int sourceVertex) {
        int vertices = graph.vertices;
        int[] distance = new int[vertices]; // array untuk menyimpan jarak terpendek dari sumber
        int[] parent = new int[vertices];   // array untuk merekonstruksi jalur

        // inisialisasi jarak ke tak hingga dan parent ke -1
        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1; // -1 menunjukkan tidak ada parent (atau tidak dapat dijangkau)
        }

        // jarak dari simpul sumber ke dirinya sendiri adalah 0
        distance[sourceVertex] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(sourceVertex, 0));

        while (!pq.isEmpty()) {
            // mengambil Node dengan jarak terkecil dari priority queue
            int u = pq.poll().vertex;

            // iterasi melalui semua tetangga dari simpul u
            for (Edge edge : graph.adjacencylist[u]) {
                int v = edge.destination;
                int weight = edge.weight;

                // jika ditemukan jalur yang lebih pendek ke simpul v melalui u
                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight; // perbarui jarak ke v
                    parent[v] = u; // set u sebagai parent dari v dalam jalur terpendek
                    pq.add(new Node(v, distance[v])); // menambahkan/perbarui v di priority queue
                }
            }
        }
      
        System.out.println("Jarak terpendek dari simpul " + sourceVertex + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.print("Ke simpul " + i + ": " + (distance[i] == Integer.MAX_VALUE ? "Tak Terjangkau" : distance[i]));
            if (distance[i] != Integer.MAX_VALUE) {
                System.out.print(" (Jalur: ");
                printPath(parent, i);
                System.out.print(")");
            }
            System.out.println();
        }
        return distance;
    }
  
    private void printPath(int[] parent, int i) {
        if (parent[i] == -1) {
            System.out.print(i);
            return;
        }
        printPath(parent, parent[i]);
        System.out.print(" -> " + i);
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph2.addEdge(0, 1, 4);
        graph2.adjacencylist[1].add(new Edge(0, 4));
        graph2.addEdge(0, 2, 2);
        graph2.adjacencylist[2].add(new Edge(0, 2));
        graph2.addEdge(1, 2, 5);
        graph2.adjacencylist[2].add(new Edge(1, 5));
        graph2.addEdge(1, 3, 10);
        graph2.adjacencylist[3].add(new Edge(1, 10));
        graph2.addEdge(2, 3, 8);
        graph2.adjacencylist[3].add(new Edge(2, 8));
        graph2.addEdge(2, 4, 3);
        graph2.adjacencylist[4].add(new Edge(2, 3));
        graph2.addEdge(3, 4, 6);
        graph2.adjacencylist[4].add(new Edge(3, 6));
        graph2.addEdge(4, 5, 1);
        graph2.adjacencylist[5].add(new Edge(4, 1));

        int sourceNode = 0;
        dijkstra.dijkstra(graph, sourceNode);
    }
}
