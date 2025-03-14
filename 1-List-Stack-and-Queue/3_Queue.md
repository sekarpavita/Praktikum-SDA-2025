# 3 Konsep Queue

Queue merupakan proses menyimpan dan memproses data dalam urutan FIFO (First-In-First-Out). Queue adalah daftar objek yang diurutkan secara terbatas untuk menyisipkan elemen di akhir daftar dan menghapus elemen dari awal daftar.

![Ilustrasi Queue](https://jenkov.com/images/java-collections/java-queue.png)

## 3.1. Deklarasi

Dikarenakan Queue pada Java merupakan Interface, bukan sebuah Class, sehingga pembuatan object Queue membutuhkan kelas yang mengimplementasikan interface Queue.

Contoh:

```Java
import java.util.LinkedList;
import java.util.Queue;

public class main {     
  public static void main (String[] args) {   
    Queue<Integer> namaQueue = new LinkedList<>(); // membuat object dari kelas Linked List yang mengimplementasikan interface Queue
  }
}
```

## 3.2. Operasi

### Add

Menambahkan item ke queue

Contoh:
```Java
Queue<String> queue = new LinkedList<>();

queue.add("A");
```

### Peek

Mengembalikan elemen teratas dari tumpukan tanpa menghapusnya.

Contoh:
```Java
queue.peek();
```

### Remove

Menghapus elemen sebuah indeks queue.

Contoh:
```Java
queue.remove();
```

### Clear

Menghapus seluruh elemen queue.

Contoh:
```Java
queue.clear();
```

### Size

Mengembalikan jumlah total elemen pada sebuah queue.

Contoh:
```Java
queue.size();
```

## Selengkapnya

- [Java Queue](https://jenkov.com/tutorials/java-collections/queue.html)
