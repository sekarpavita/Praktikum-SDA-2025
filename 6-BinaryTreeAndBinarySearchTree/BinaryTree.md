
# 1 - Binary Tree

## Konsep Binary Tree
Tree adalah struktur data non-linier di mana setiap node dapat memiliki anak (child). Binary Tree adalah jenis tree yang setiap nodenya memiliki maksimal dua anak, yaitu left child dan right child.

![Gambar Binary Tree](https://www.geeksforgeeks.org/wp-content/uploads/binary-tree-to-DLL.png)

## Implementasi Binary Tree dalam Java

### Struktur Node
Setiap node memiliki:
- Data
- Pointer ke anak kiri (left)
- Pointer ke anak kanan (right)

### Kode Inisialisasi
```java
Node root = new Node(1);
root.left = new Node(2);
root.right = new Node(3);
root.left.left = new Node(4);
```

### Insertion
Menambahkan node baru dilakukan dengan traversal level-order menggunakan queue. Node baru ditempatkan di anak kiri/kanan pertama yang kosong.

![Insertion](https://media.geeksforgeeks.org/wp-content/uploads/binary-tree-insertion.png)

### Deletion
Penghapusan node dilakukan dengan:
1. Mencari node terdalam dan paling kanan.
2. Menyalin nilainya ke node yang ingin dihapus.
3. Menghapus node terdalam.

![Deletion](https://media.geeksforgeeks.org/wp-content/uploads/deletion-in-binary-tree.png)

### Contoh Output
```
Inorder traversal before insertion: 7 11 12 10 15 9 8 
Inorder traversal after insertion: 7 11 12 12 10 15 9 8 
Inorder traversal after deletion: 7 8 12 12 10 15 9 
```
