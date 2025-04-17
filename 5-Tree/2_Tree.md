[<< Stack dan Queue](2-StackQueue.md)

# Tree

## Pengertian Tree

Tree adalah sebuah struktur data non linear yang memiliki dua atau lebih "link" dan sering divisualisasikan sebagai sebuah pohon.
Komponen dari Tree ialah **node** yang berisi data dan pointer atau link untuk node berikutnya.
Tree yang memiliki _maksimal_ dua link (child kiri dan child kanan) disebut **Binary Tree**. 
Binary Tree yang mana sudah ditentukan jika child kiri memiliki nilai yang lebih kecil daripada nilai root
dan child kanan memiliki nilai yang lebih besar daripada nilai root disebut **Binary Search Tree (BST)**. Kali ini kita akan mempelajari BST

### Contoh Tree
```
        100
      /  |  \
    30  23   46
   / \       |
  10  6      2 
```
### Contoh Binary Tree
```
        100
        /  \
       32  12
      / \    \
     1  4     8
```
### Contoh Binary Search Tree
```
         50
        /  \
       12   62
      /  \  / \ 
     1  20 61 63 
```

## Insersi BST

Insersi (insertion) BST adalah proses penambahan node baru ke dalam suatu binary search tree.

Algoritma:
- Apabila nilai lebih besar dari root, maka pointer bergerak ke node kanan
- Apabila nilai lebih kecil dari root, maka pointer bergerak ke node kiri
- Apabila pointer menunjuk ke NULL, maka buat node baru dan simpan nilai di lokasi tersebut

### Contoh kasus
```
         20
        /  \
       12   32
      /     / \ 
     1     21  63 
```
BST di atas didapat dengan memasukan angka secara urut yaitu ``20, 12, 32, 1, 21, 63``.
Kalian dapat melihat proses insersi pada [link ini](https://www.cs.usfca.edu/~galles/visualization/BST.html)

## Traversal
Traversal adalah teknik untuk mengunjungi node-node pada tree. Saat melakukan traversal, anggap tree hanya memiliki 3 bagian yaitu root, subtree kiri, dan subtree kanan. 
Terdapat 3 jenis traversal yaitu:
- Pre Order: root, left, right
- In Order: left, root, right
- Post Order: left, right, root

### Contoh 
```
         50
        /  \
       12   62
      /  \  / \ 
     1  20 61 63 
```
Hasil PreOrder  : 50, 12, 1, 20, 62, 61, 63 \
Hasil InOrder   : 1, 12, 20, 50, 61, 62, 63 \
Hasil PostOrder : 1, 20, 12, 61, 63, 62, 50

#### Tips menghafal
root menjadi titik fokus. Cara yang menjadi _patokan_ ialah In Order dengan root di tengah.
_Pre_ artinya sebelum berarti root berada di awal.
_Post_ artinya sesudah berarti root berada di akhir.

## Source Code BST

Lihatlah dan pahami contoh source code implementasi binary search tree sederhana (insertion dan traversal) pada slides yang telah diberikan dosen pada kuliah teori.

## Contoh Penerapan BST

Berikut adalah contoh implementasinya:


```java
import java.util.*;

class Mahasiswa {
    String nama;
    String prodi;
    int angkatan;

    Mahasiswa(String nama, String prodi, int angkatan) {
        this.nama = nama;
        this.prodi = prodi;
        this.angkatan = angkatan;
    }
}

class MahasiswaNode {
    String key; // NIM
    Mahasiswa value;
    MahasiswaNode leftChild, rightChild;

    MahasiswaNode(String key, Mahasiswa value) {
        this.key = key;
        this.value = value;
    }
}

public class BSTMahasiswa {
    private MahasiswaNode root = null;

    public void tambahMahasiswa(String key, Mahasiswa value) {
        root = tambahRekursif(root, key, value);
    }

    private MahasiswaNode tambahRekursif(MahasiswaNode node, String key, Mahasiswa value) {
        if (node == null) return new MahasiswaNode(key, value);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.leftChild = tambahRekursif(node.leftChild, key, value);
        else if (cmp > 0) node.rightChild = tambahRekursif(node.rightChild, key, value);
        else System.out.println("Mahasiswa dengan NIM " + key + " sudah ada sebelumnya");

        return node;
    }

    public void tampilkanDataMahasiswa() {
        inorderTraversal(root);
    }

    private void inorderTraversal(MahasiswaNode node) {
        if (node != null) {
            inorderTraversal(node.leftChild);
            System.out.printf("%s: %s, Prodi %s, Angkatan %d\n", node.key, node.value.nama, node.value.prodi, node.value.angkatan);
            inorderTraversal(node.rightChild);
        }
    }

    public MahasiswaNode cariMahasiswa(String key) {
        return cariRekursif(root, key);
    }

    private MahasiswaNode cariRekursif(MahasiswaNode node, String key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) return cariRekursif(node.leftChild, key);
        else if (cmp > 0) return cariRekursif(node.rightChild, key);
        else return node;
    }

    public void hapusSemuaMahasiswa() {
        root = null;
    }

    public static void main(String[] args) {
        BSTMahasiswa tree = new BSTMahasiswa();

        tree.tambahMahasiswa("M0520015", new Mahasiswa("Budi Setiawan", "Informatika", 2020));
        tree.tambahMahasiswa("M0519064", new Mahasiswa("Rizal Setiabudi", "Informatika", 2019));
        tree.tambahMahasiswa("M0521079", new Mahasiswa("Yusuf Hendrawan", "Informatika", 2021));
        tree.tambahMahasiswa("M0520041", new Mahasiswa("Joko Susilo", "Informatika", 2020));

        System.out.println("Menampilkan semua data ...");
        tree.tampilkanDataMahasiswa();
        System.out.println();

        System.out.println("Mencari nama dari M0519064 ...");
        MahasiswaNode found = tree.cariMahasiswa("M0519064");
        if (found != null) {
            System.out.println("Nama: " + found.value.nama);
        } else {
            System.out.println("Tidak ketemu :(");
        }
        System.out.println();

        System.out.println("Mencari nama dari M0519065 ...");
        found = tree.cariMahasiswa("M0519065");
        if (found != null) {
            System.out.println("Nama: " + found.value.nama);
        } else {
            System.out.println("Tidak ketemu :(");
        }
        System.out.println();

        System.out.println("Mengganti nama dari M0519064 ...");
        found = tree.cariMahasiswa("M0519064");
        if (found != null) {
            found.value.nama = "Rizal Setiaji";
        }
        tree.tampilkanDataMahasiswa();
        System.out.println();

        System.out.println("Menambahkan M0520015 lagi ...");
        tree.tambahMahasiswa("M0520015", new Mahasiswa("Bagus Haryono", "Informatika", 2020));
        System.out.println();

        System.out.println("Menghapus semua mahasiswa ...");
        tree.hapusSemuaMahasiswa();
        tree.tampilkanDataMahasiswa(); // tidak tampil apa-apa
        System.out.println();
    }
}
```

/*
Output:

Menampilkan semua data ...
M0519064: Rizal Setiabudi, Prodi Informatika, Angkatan 2019
M0520015: Budi Setiawan, Prodi Informatika, Angkatan 2020
M0520041: Joko Susilo, Prodi Informatika, Angkatan 2020
M0521079: Yusuf Hendrawan, Prodi Informatika, Angkatan 2021

Mencari nama dari M0519064 ...
Nama: Rizal Setiabudi

Mencari nama dari M0519065 ...
Tidak ketemu :(

Mengganti nama dari M0519064 ...
M0519064: Rizal Setiaji, Prodi Informatika, Angkatan 2019
M0520015: Budi Setiawan, Prodi Informatika, Angkatan 2020
M0520041: Joko Susilo, Prodi Informatika, Angkatan 2020
M0521079: Yusuf Hendrawan, Prodi Informatika, Angkatan 2021

Menghapus M0520041 ...
M0519064: Rizal Setiaji, Prodi Informatika, Angkatan 2019
M0520015: Budi Setiawan, Prodi Informatika, Angkatan 2020
M0521079: Yusuf Hendrawan, Prodi Informatika, Angkatan 2021

Menambahkan M0520015 ...
Mahasiswa dengan NIM M0520015 sudah ada sebelumnya

Menghapus semua mahasiswa ...

*/
```

[Silabus >>](../silabus.md)
