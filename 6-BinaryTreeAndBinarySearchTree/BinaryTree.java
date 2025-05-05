
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class BinaryTree {

    // Inorder traversal
    public void inorder(Node temp) {
        if (temp == null) return;

        inorder(temp.left);
        System.out.print(temp.data + " ");
        inorder(temp.right);
    }

    // Insert a node
    public Node insert(Node root, int data) {
        if (root == null) return new Node(data);

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp.left == null) {
                temp.left = new Node(data);
                break;
            } else {
                q.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new Node(data);
                break;
            } else {
                q.add(temp.right);
            }
        }

        return root;
    }

    // Delete the deepest node
    private void deleteDeepest(Node root, Node d_node) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp == d_node) {
                temp = null;
                return;
            }

            if (temp.right != null) {
                if (temp.right == d_node) {
                    temp.right = null;
                    return;
                } else {
                    q.add(temp.right);
                }
            }

            if (temp.left != null) {
                if (temp.left == d_node) {
                    temp.left = null;
                    return;
                } else {
                    q.add(temp.left);
                }
            }
        }
    }

    // Delete a node
    public Node delete(Node root, int key) {
        if (root == null) return null;

        if (root.left == null && root.right == null) {
            if (root.data == key) return null;
            else return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node temp = null, keyNode = null;

        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp.data == key) keyNode = temp;

            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }

        if (keyNode != null) {
            int x = temp.data;
            deleteDeepest(root, temp);
            keyNode.data = x;
        }

        return root;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        Node root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.left.right = new Node(12);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print("Inorder traversal before insertion: ");
        tree.inorder(root);
        System.out.println();

        root = tree.insert(root, 12);
        System.out.print("Inorder traversal after insertion: ");
        tree.inorder(root);
        System.out.println();

        root = tree.delete(root, 11);
        System.out.print("Inorder traversal after deletion: ");
        tree.inorder(root);
    }
}
