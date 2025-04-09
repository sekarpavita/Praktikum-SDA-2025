# 1. Konsep Set

Set (atau himpunan) adalah struktur data yang digunakan untuk mengecek keberadaan suatu data tertentu. Konsep ini mirip seperti dalam matematika, tetapi elemen-elemen dalam Set di Java memiliki jumlah yang terbatas dan bersifat unik (tidak boleh ada duplikat).

Himpunan pada matematika juga memiliki operasi untuk mengecek suatu keanggotaan pada himpunan (misalkan, apakah angka 36 merupakan anggota himpunan bilangan bulat?). Begitu juga himpunan sebagai struktur data program komputer, ia dapat mengecek keanggotaan (keberadaan) suatu data dalam himpunan tersebut, dengan kompleksitas yang relatif singkat.

Pada umumnya, himpunan direpresentasikan dalam bentuk binary search tree (TreeSet) supaya proses menambah, menghapus, dan mencari elemen bisa dilakukan seefisien mungkin dangan kompleksitas O(log N).

![Set pada Java](https://www.webskittersacademy.in/wp-content/uploads/2017/06/Java-Set-Interface-hierarchy.png)

## 1.1. Deklarasi

Sebagai contoh:
```Java
import java.util.Set;
import java.util.HashSet;

public class main {
  public static void main (String[] args) {
    Set<Integer> favNumbers = new HashSet<>();
  }
}
```
Mendeklarasikan himpunan `fav_numbers` dengan tipe anggota elemen berupa `Integer`.

## 1.2. Operasi

### Add

Memasukkan elemen angka `36` ke dalam himpunan `fav_numbers`:
```Java
favNumbers.add(36);
```

### Contains

Mengecek apakah angka `36` ada dalam himpunan `fav_numbers`:
```Java
favNumbers.contains(36);
```

### Remove

Menghapus keanggotaan angka `36` dari himpunan `fav_numbers`:
```Java
favNumbers.remove(36);
```

### Clear

Menghapus seluruh anggota himpunan `fav_numbers`:
```Java
favNumbers.clear();
```

### Iteration

Iterasi seluruh anggota elemen pada himpunan `fav_numbers`:
```Java
for (String i : favNumbers) {
  System.out.println(i);
}
```

## 1.3 Implementasi Set
| Implementasi  | Ciri Khas                                               |
| ------------- | ------------------------------------------------------- |
| HashSet       | Tidak menjamin urutan elemen, paling cepat performanya. |
| LinkedHashSet | Menjaga urutan penambahan elemen.                       |
| TreeSet       | Menyimpan elemen dalam urutan naik (sorted).            |

## Selengkapnya

- [Java HashSet](https://www.w3schools.com/java/java_hashset.asp)
- [Java LinkedHashSet](https://www.tpointtech.com/java-linkedhashset)
- [Java TreeSet](https://www.tpointtech.com/java-treeset)
