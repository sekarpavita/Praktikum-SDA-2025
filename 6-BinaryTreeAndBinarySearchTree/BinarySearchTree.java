class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // SEARCH
    Node search(Node root, int key) {
        if (root == null || root.key == key)
            return root;

        if (key < root.key)
            return search(root.left, key);

        return search(root.right);
    }

    // INSERT
    Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);

        return root;
    }

    // INORDER
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    // FIND MINIMUM VALUE NODE
    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // DELETE
    Node deleteNode(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteNode(root.left, key);
        else if (key > root.key)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            Node temp = minValueNode(root.right);
            root.key = temp.key;
            root.right = deleteNode(root.right, temp.key);
        }

        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        int[] keys = {50, 30, 20, 40, 70, 60, 80};
        for (int key : keys)
            tree.root = tree.insert(tree.root, key);

        System.out.print("Inorder traversal: ");
        tree.inorder(tree.root);

        System.out.println("\n\nDelete 20");
        tree.root = tree.deleteNode(tree.root, 20);
        tree.inorder(tree.root);

        System.out.println("\n\nDelete 30");
        tree.root = tree.deleteNode(tree.root, 30);
        tree.inorder(tree.root);

        System.out.println("\n\nDelete 50");
        tree.root = tree.deleteNode(tree.root, 50);
        tree.inorder(tree.root);
    }
}