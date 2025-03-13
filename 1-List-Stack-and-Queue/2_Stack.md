# 2 Konsep Stack

Stack adalah struktur data linear yang digunakan untuk menyimpan koleksi objek. Struktur ini didasarkan pada Last-In-First-Out (LIFO). Struktur data stack memiliki
dua operasi yang paling penting, yaitu push dan pop. Operasi push menyisipkan elemen ke dalam stack dan operasi pop menghapus elemen dari bagian atas stack.

![Ilustrasi Stack](https://cdn1.byjus.com/wp-content/uploads/2022/01/stack.png)

## 2.1. Deklarasi

Contoh:
```Java
import java.util.Stack; // import kelas Stack

public class main {     
  public static void main (String[] args) {   
    Stack namaStack = new Stack(); // membuat object dari kelas Stack
  }
}
```

## 2.2. Operasi

### Push

Menambahkan item ke bagian atas stack

Contoh:
```Java
Stack<Integer> number = new Stack<Integer>();

number.push(5);
number.push(24);
number.push(50);
```

### Pop

Menghapus objek di bagian atas stack dan mengembalikan objek yang sama. Ini akan melempar EmptyStackException jika stack kosong.

Contoh:
```Java
number.pop();
```

### Empty

Memeriksa apakah stack kosong atau tidak. Jika tumpukan kosong, ia mengembalikan nilai true jika stack tidak berisi elemen, ia akan mengembalikan nilai false.

Contoh:
```Java
number.empty();
```

### Size

Mengembalikan jumlah total elemen pada sebuah stack.

Contoh:
```Java
number.size();
```

### Peek

Mengembalikan elemen teratas dari tumpukan tanpa menghapusnya. Ia juga akan melempar EmptyStackException jika tumpukan kosong.

Contoh:
```Java
number.peek();
```

## Selengkapnya

- [Java Stack](https://www.tpointtech.com/java-stack)
