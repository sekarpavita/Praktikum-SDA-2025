# 1. Tree

## 1.1 Konsep Tree

Tree adalah sebuah struktur data abstrak (implementasinya sesuai dengan keinginan pengguna) yang merepresentasikan pohon/hirarki yang tersusun atas `node` - `node` yang saling tersambung. Untuk dianggap sebagai sebuah tree, masing-masing `node` harus memiliki tepat satu orang tua (untuk selanjutnya disebut `parent`), kecuali `root node`, atau `node` yang pertama. Setiap `node` dapat memiliki berapapun anak (untuk selanjutnya disebut `child`), termasuk 0.

Ilustrasi di bawah ini merupakan salah satu contoh struktur data Tree.

<div align="center">

![](https://upload.wikimedia.org/wikipedia/commons/thumb/5/5f/Tree_%28computer_science%29.svg/421px-Tree_%28computer_science%29.svg.png)

</div>

Kita bisa melihat bahwa root dari Tree di atas adalah node 2 yang paling atas, yang tidak memiliki `parent`

> Pertanyaan tantangan: Ada banyak jenis struktur data Tree yang mungkin memiliki peraturan yang berbeda-beda dalam pembuatan `node`nya. Apa sajakah contohnya?
> Contoh implementasi dari struktur data Tree adalah direktori simbolis untuk berkas yang kalian simpan pada sistem operasi kalian. Untuk masing-masing folder, `root` adalah folder yang kalian buka, dan `children` dari root tersebut adalah semua isi dari folder yang kalian buka.

## 1.2 Operasi Tree

Sebagai sebuah struktur data, Tree memiliki beberapa operasi yang dapat digunakan untuk memanipulasi data yang disimpan didalamnya. Operasi-operasi tersebut adalah `insertion`, `deletion`, dan `traversal`

Sebelum membuat operasi-operasi tersebut, kita harus membuat struktur data Tree kita terlebih dahulu, karena java sudah menyediakan functionnya, kita bisa langsung pakai saja

```Java
import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    List<Node> children;

    public Node(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
}
```

Lalu, kita dapat mendefinisikan `node` - `node` yang akan kita gunakan pada main seperti di bawah ini.

```Java
public static void main (String[] args) {
    Node Root = new Node(5);
    Node child_0 = new Node(7);
    Node child_1 = new Node(5);
    Node child_2 = new Node(2);
    Node child_3 = new Node(10);
    Node child_4 = new Node(6);
  }
```

### 1.2.1 Insertion

Insertion adalah operasi yang didefinisikan sebagai aksi memasukkan nilai untuk disimpan pada sebuah Tree. Tergantung dari jenisnya, akan ada banyak aturan mengenai insertion pada Tree. Namun untuk sekarang, kita akan belajar menggunakan Tree yang sederhana.

```Java
// ...
public void insert(Node child) {
        children.add(child);
}
// ...

public static void main (String[] args) {
    // ...
    child_0.insert(child_2);
    child_0.insert(child_3);
    child_1.insert(child_4); 

    root.insert(child_0);
    root.insert(child_1);
    // ...
}
```

Sehingga struktur Tree-nya menjadi berikut:
        5
      /   \
     7     5
   /  \     \
  2   10     6

### 1.2.2 Deletion

Operasi penghapusan pada struktur data tree dilakukan dengan cara menghapus node sesuai dengan urutan yang kita inginkan. Kita dapat membuat metode delete kita seperti di bawah ini.

```Java
// ...
public boolean deleteNodeIndex(int index) {
    if (children.isEmpty() || index >= children.size()) {
        return false;
    } else {
        children.remove(index);
        return true;
    }
}
// ...
```

### 1.2.3 Traversal

Traversal dalam struktur data Tree dapat didefinisikan dengan "mengunjungi tiap-tiap `node` tepat satu kali". Ada beberapa jenis Tree traversal yang ada, seperti `postorder`, `preorder`, dan `inorder`. Kita tidak akan menggunakan `inorder` pada praktikum ini karena jenis traversal itu hanya digunakan untuk binary tree. Tree traversal `postorder` dan `preorder` memiliki pseudocode seperti di bawah ini.

```
Preorder
  1. Datangi salah satu node sebagai parent
  2. Proses node tersebut
  3. Iterasi seluruh children dari node tersebut, untuk setiap iterasi mengulangi
     langkah 1 dengan node yang sedang dijelajahi sebagai parentnya

Postorder
  1. Datangi salah satu node sebagai parent
  2. Iterasi seluruh children dari node tersebut, untuk setiap iterasi mengulangi
     langkah 1 dengan node yang sedang dijelajahi sebagai parentnya
  3. Proses node tersebut
```

Kita dapat membuat metode traversal kita seperti potongan di bawah ini. Perhatikan bagaimana kita menggunakan `depth` untuk memberikan _style_ ke kode kita supaya lebih mudah dipahami hubungannya dengan `node` lainnya (apakah ancestor, sibling, atau descendant).

```Java
// ...
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
// ...
```

## 1.3 Tree pada Java

### 1.3.1 TreeSet

| Methods    | Deskripsi                            |
| ---------- | ------------------------------------ |
| add()      | Menambahkan elemen                   |
| remove()   | Menggapus elemen tertentu            |
| contains() | Mengecek apakah elemen ada           |
| isEmpty()  | Mengecek apakah set kosong           |
| size()     | Mengembalikan jumlah elemen          |
| clear()    | Menghapus semua elemen               |
| first()    | Mendapatkan elemen terkecil          |
| last()     | Mendapatkan elemen terbesar          |

### 1.3.2 TreeMap

| Methods         | Deskripsi                                        |
| --------------- | ------------------------------------------------ |
| put()           | Menambahkan pasangan key-value                   |
| get()           | Mengambil value berdasarkan key                  |
| remove()        | Menghapus pasangan berdasarkan key               |
| containsKey()   | Mengecek apakah key ada                          |
| containsValue() | Mengecek apakah value ada                        |
| size()          | Mengembalikan jumlah pasangan key-value pada map |
| firstKey()      | Mendapatkan key terkecil                         |
| lastKey()       | Mendapatkan key terbesar                         |
