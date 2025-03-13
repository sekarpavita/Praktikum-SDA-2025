# 1 - Konsep List

List adalah struktur data yang berguna untuk menampung banyak elemen. Terdapat dua contoh implementasinya, yaitu **array list** dan **linked list**. Array list adalah implementasi list yang menggunakan array sebagai penampungnya, kemudian linked list menggunakan self-referential structure dan pointer sebagai penampungnya.

- Array list memiliki kelebihan yaitu elemen di suatu posisi dapat diakses dengan cepat (kompleksitas O(1)), namun memiliki kekurangan yaitu proses memasukkan dan mengeluarkan elemen dalam list membutuhkan waktu yang lebih lama (kompleksitas O(N)) serta mekanisme alokasi memori yang lebih banyak (kompeksitas O(K) di mana K >= N dan K adalah kapasitas maksimum array) apabila ingin menghemat waktu saat memasukkan elemen di masa mendatang.
- Lalu linked list memiliki kelebihan yaitu proses memasukkan dan mengeluarkan elemen membutuhkan waktu yang singkat (kompleksitas O(1)) dan dapat menggunakan memori seefisien mungkin (kompleksitas O(N)), namun untuk mengakses elemen di posisi tertentu membutuhkan waktu yang lebih lama (kompleksitas O(N)).

Dalam hal ini berlaku N adalah jumlah seluruh elemen yang tertampung dalam list.

## 1.1. Array List

### Deklarasi

Contoh:

```Java
import java.util.ArrayList; // import kelas ArrayList

public class Main {
  public static void main(String[] args) {
    ArrayList<String> namaArrayList = new ArrayList<String>(); // Membuat object dari kelas ArrayList
  }
}
```

### Operasi

Menambahkan elemen di akhir:

```Java
ArrayList<String> cats = new ArrayList<String>();

cats.add("Persia");
```

Menambahkan elemen di suatu indeks:

```Java
cats.add("Munchkin");
cats.add(1, "Angora");
```

Merubah elemen di suatu indeks:

```Java
cats.set(0, "Spinx");
```

Menghapus elemen sebuah indeks:

```Java
cats.remove(0);
```

Menghapus seluruh elemen:

```Java
cats.clear();
```

Mengakses elemen di suatu indeks:

```Java
cats.get(0);
```

Iterasi seluruh elemen:

```Java
for (int i = 0; i < cats.size(); i++) {
      System.out.println(cats.get(i));
    }
```

## 1.2. Linked List

### Deklarasi

Contoh:

```Java
import java.util.LinkedList; // import kelas LinkedList

public class Main {
  public static void main(String[] args) {
    LinkedList<String> namaLinkedList = new LinkedList<String>(); // Membuat object dari kelas LinkedList
  }
}
```

### Operasi

| Methods       | Deskripsi                                         |
| ------------- | ------------------------------------------------- |
| addFirst()    | Menambahkan elemen di awal                        |
| addLast()     | Menambahkan elemen di akhir                       |
| removeFirst() | Menghapus elemen di indeks pertama (indeks ke- 0) |
| removeLast()  | Menghapus elemen di indeks terakhir               |
| getFirst()    | Mengakses elemen di indeks pertama (indeks ke- 0) |
| getLast()     | Mengakses elemen di indeks                        |

## Selengkapnya

- [Java Array List](https://www.tpointtech.com/java-arraylist)
- [Java Linked List](https://www.tpointtech.com/java-linkedlist)
