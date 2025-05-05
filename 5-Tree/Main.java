import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    List<Node> children;

    public Node(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void insert(Node child) {
        children.add(child);
    }

    public boolean deleteNodeIndex(int index) {
        if (children.isEmpty() || index >= children.size()) {
            return false;
        } else {
            children.remove(index);
            return true;
        }
    }

    private void _preOrder(int depth) {
        System.out.println("--".repeat(depth) + "> " + data);
        for (Node child : children) {
            child._preOrder(depth + 1);
        }
    }

    void preOrder() {
        System.out.println("Preorder Traversal:");
        _preOrder(0);
    }

    private void _postOrder(int depth) {
        for (Node child : children) {
            child._postOrder(depth + 1);
        }
        System.out.println("--".repeat(depth) + "> " + data);
    }

    void postOrder() {
        System.out.println("Postorder Traversal:");
        _postOrder(0);
    }
}

public class Main {
    public static void main(String[] args) {
        // Membuat node
        Node root = new Node(5);
        Node child_0 = new Node(7);
        Node child_1 = new Node(5);
        Node child_2 = new Node(2);
        Node child_3 = new Node(10);
        Node child_4 = new Node(6);

        // Insert anak-anak ke node yang sesuai
        child_0.insert(child_2);
        child_0.insert(child_3);
        child_1.insert(child_4);
        root.insert(child_0);
        root.insert(child_1);

        // Traversal
        root.preOrder();
        System.out.println();
        root.postOrder();

        // Deletion contoh
        System.out.println("\nSetelah delete child ke-1 dari root:");
        root.deleteNodeIndex(1); // menghapus child_1
        root.preOrder();
    }
}
