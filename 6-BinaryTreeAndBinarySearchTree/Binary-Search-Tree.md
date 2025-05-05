# 2 - Binary Search Tree

## Konsep Binary Search Tree
Binary Search Tree adalah struktur data Binary Tree berbasis node yang memiliki aturan:

- Subtree kiri hanya berisi node dengan key lebih kecil dari node induk.
- Subtree kanan hanya berisi node dengan key lebih besar dari node induk.
- Tidak ada key yang sama dalam tree.

![Gambar BST](https://media.geeksforgeeks.org/wp-content/uploads/BSTSearch.png)

---

## Operasi dalam Binary Search Tree

### Searching
Mencari nilai di BST dilakukan dengan membandingkan nilai pencarian terhadap node saat ini, lalu berpindah ke subtree kiri atau kanan sesuai perbandingan.

```java
Node search(Node root, int key) {
    if (root == null || root.key == key)
        return root;

    if (key < root.key)
        return search(root.left, key);

    return search(root.right);
}
```

---

### Insertion
Proses menambahkan nilai baru dengan cara rekursif menuju posisi yang sesuai berdasarkan perbandingan key.

```java
Node insert(Node root, int key) {
    if (root == null)
        return new Node(key);

    if (key < root.key)
        root.left = insert(root.left, key);
    else
        root.right = insert(root.right, key);

    return root;
}
```

---

### Deletion
Tiga kasus penghapusan node dalam BST:
1. Node adalah daun → langsung hapus.
2. Node punya satu anak → ganti dengan anaknya.
3. Node punya dua anak → ganti dengan inorder successor.

```java
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
```

---

### Inorder Traversal
Traversal inorder menghasilkan urutan nilai yang terurut dari BST.

```java
void inorder(Node root) {
    if (root != null) {
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }
}
```

---

### Contoh Output
```
Inorder traversal: 20 30 40 50 60 70 80

Delete 20
30 40 50 60 70 80

Delete 30
40 50 60 70 80

Delete 50
40 60 70 80
```