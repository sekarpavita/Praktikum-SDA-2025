# Graph di Java

## 1. Konsep Dasar Graph

**Graph** adalah suatu struktur data yang mendefinisikan hubungan antara suatu data dengan data lainnya. Suatu graf terdiri dari sekumpulan **simpul (node)** dan **sisi (edge)** yang menghubungkan antara simpul-simpul tersebut. 

### 1.1 Jenis Graph

* **Graf berarah (Directed Graph):** Setiap edge memiliki arah.
  ![Ilustrasi Graf Berarah](https://github.com/Alfurqon02/Praktikum-SDA-2023/blob/main/Bab7-GraphAndDisjointSet/img/directed-graph.png)
* **Graf tak berarah (Undirected Graph):** Edge tidak memiliki arah.
  ![Ilustrasi Graf Tidak Berarah](https://github.com/Alfurqon02/Praktikum-SDA-2023/blob/main/Bab7-GraphAndDisjointSet/img/undirected-graph.png)

## 2. Representasi Graph di Java

### 2.1 Adjacency Matrix (Matriks Ketetanggaan)

Pada dasarnya, matriks ketetanggaan memanfaatkan konsep yang mirip dengan array dua dimensi yang merepresentasikan simpul-simpul dalam suatu graf.

#### Contoh:

```java
public class GrafMatrix {
    public static void main(String[] args) {
        int jumlahTempat = Tempat.values().length;
        double[][] jarak = new double[jumlahTempat][jumlahTempat];

        // Inisialisasi jarak ke dirinya sendiri = 0
        for (int i = 0; i < jumlahTempat; i++) {
            for (int j = 0; j < jumlahTempat; j++) {
                jarak[i][j] = (i == j) ? 0.0 : -1.0; // -1 artinya tidak ada jalur langsung
            }
        }

        // Menambahkan beberapa koneksi
        jarak[Tempat.RUMAH.ordinal()][Tempat.UNIVERSITAS_SEBELAS_MARET.ordinal()] = 2.97;
        jarak[Tempat.UNIVERSITAS_SEBELAS_MARET.ordinal()][Tempat.RUMAH.ordinal()] = 2.97;

        jarak[Tempat.UNIVERSITAS_SEBELAS_MARET.ordinal()][Tempat.RUMAH_SAKIT_DR_MOEWARDI.ordinal()] = 2.86;
        jarak[Tempat.RUMAH_SAKIT_DR_MOEWARDI.ordinal()][Tempat.UNIVERSITAS_SEBELAS_MARET.ordinal()] = 2.86;

        jarak[Tempat.PECEL_MADIUN_PUCANGSAWIT.ordinal()][Tempat.SMA_NEGERI_3_SURAKARTA.ordinal()] = 2.28;
        jarak[Tempat.SMA_NEGERI_3_SURAKARTA.ordinal()][Tempat.PECEL_MADIUN_PUCANGSAWIT.ordinal()] = 2.28;
    }
}
```

### 2.2 Adjacency List (Daftar Ketetanggaan)

Daftar ketetanggaan adalah salah satu cara lain untuk merepresentasikan sebuah graf. Pada dasarnya, daftar ketetanggaan adalah sebuah array yang berisi semua simpul dalam graf, dan setiap elemennya berisi daftar tetangga serta sisi yang terhubung.

#### Contoh:

```java
import java.util.*;

class Jarak {
    int tujuan;
    double nilai;

    public Jarak(int tujuan, double nilai) {
        this.tujuan = tujuan;
        this.nilai = nilai;
    }
}

public class GrafList {
    public static void main(String[] args) {
        int jumlahTempat = Tempat.values().length;
        List<List<Jarak>> graf = new ArrayList<>();

        for (int i = 0; i < jumlahTempat; i++) {
            graf.add(new ArrayList<>());
        }

        graf.get(Tempat.RUMAH.ordinal()).add(new Jarak(Tempat.UNIVERSITAS_SEBELAS_MARET.ordinal(), 2.97));
        graf.get(Tempat.UNIVERSITAS_SEBELAS_MARET.ordinal()).add(new Jarak(Tempat.RUMAH.ordinal(), 2.97));

        graf.get(Tempat.UNIVERSITAS_SEBELAS_MARET.ordinal()).add(new Jarak(Tempat.RUMAH_SAKIT_DR_MOEWARDI.ordinal(), 2.86));
        graf.get(Tempat.RUMAH_SAKIT_DR_MOEWARDI.ordinal()).add(new Jarak(Tempat.UNIVERSITAS_SEBELAS_MARET.ordinal(), 2.86));

        graf.get(Tempat.PECEL_MADIUN_PUCANGSAWIT.ordinal()).add(new Jarak(Tempat.SMA_NEGERI_3_SURAKARTA.ordinal(), 2.28));
        graf.get(Tempat.SMA_NEGERI_3_SURAKARTA.ordinal()).add(new Jarak(Tempat.PECEL_MADIUN_PUCANGSAWIT.ordinal(), 2.28));
    }
}
```

### 2.3 Edge List (Daftar Sisi)

Daftar sisi juga dapat digunakan untuk merepresentasikan sebuah graf. Pada dasarnya, daftar sisi adalah sebuah list yang berisi semua sisi dalam graf.

#### Contoh:

```java
import java.util.*;

class Sisi {
    int asal;
    int tujuan;
    double jarak;

    public Sisi(int asal, int tujuan, double jarak) {
        this.asal = asal;
        this.tujuan = tujuan;
        this.jarak = jarak;
    }
}

public class GrafEdgeList {
    public static void main(String[] args) {
        List<Sisi> sisiList = new ArrayList<>();

        sisiList.add(new Sisi(Tempat.RUMAH.ordinal(), Tempat.UNIVERSITAS_SEBELAS_MARET.ordinal(), 2.97));
        sisiList.add(new Sisi(Tempat.UNIVERSITAS_SEBELAS_MARET.ordinal(), Tempat.RUMAH.ordinal(), 2.97));

        sisiList.add(new Sisi(Tempat.UNIVERSITAS_SEBELAS_MARET.ordinal(), Tempat.RUMAH_SAKIT_DR_MOEWARDI.ordinal(), 2.86));
        sisiList.add(new Sisi(Tempat.RUMAH_SAKIT_DR_MOEWARDI.ordinal(), Tempat.UNIVERSITAS_SEBELAS_MARET.ordinal(), 2.86));

        sisiList.add(new Sisi(Tempat.PECEL_MADIUN_PUCANGSAWIT.ordinal(), Tempat.SMA_NEGERI_3_SURAKARTA.ordinal(), 2.28));
        sisiList.add(new Sisi(Tempat.SMA_NEGERI_3_SURAKARTA.ordinal(), Tempat.PECEL_MADIUN_PUCANGSAWIT.ordinal(), 2.28));
    }
}
```

## 4. Perbandingan Kompleksitas

| Operasi               | Matriks | Daftar | Edge List |
| --------------------- | ------- | ------ | --------- |
| Tambah edge           | O(1)    | O(1)   | O(1)      |
| Hapus edge            | O(1)    | O(K)   | O(E)      |
| Periksa hubungan edge | O(1)    | O(K)   | O(E)      |
| Iterasi tetangga      | O(V)    | O(K)   | O(E)      |
| Memori                | O(V²)   | O(V+E) | O(E)      |

* **V** = jumlah simpul (vertex)
* **E** = jumlah sisi (edge)
* **K** = jumlah tetangga dari simpul tertentu

## 5. Kesimpulan

* Gunakan **Adjacency Matrix** jika jumlah simpul kecil dan sering mengecek koneksi antar node.
* Gunakan **Adjacency List** jika graf besar dan ingin efisien dalam memori serta fleksibel dalam traversal.
* Gunakan **Edge List** jika lebih fokus ke pemrosesan sisi seperti pengurutan bobot (misal pada algoritma Kruskal).
