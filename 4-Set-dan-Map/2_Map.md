# 2. Konsep Map

Map (atau **pemetaan**) adalah struktur data yang *memetakan* suatu nilai ke nilai lain. Sederhananya, suatu nilai yang berada dalam dalam map berkorespondensi dengan nilai lain (bisa dengan tipe data yang berbeda).

Dalam praktiknya, map sering digunakan sebagai solusi pengganti indeks berbasis integer pada array (misalnya diganti menjadi indeks berbasis string).

Seperti halnya set, map juga umumnya direpresentasikan dalam bentuk binary search tree (TreeMap) supaya proses menambah, menghapus, dan mencari elemen bisa dilakukan seefisien mungkin dengan kompleksitas O(log N).

![Map pada Java](https://d2jdgazzki9vjm.cloudfront.net/images/core/java-map-hierarchy.png)

## 2.1. Deklarasi

Sebagai contoh:
```Java
import java.util.Map;
import java.util.HashMap;

public class main {
  public static void main (String[] args) {
    Map<String, String> dataMhs = new HashMap<>();
  }
}
```

## 2.2. Operasi

### Put

Menambahkan mahasiswa ke map:
```Java
dataMhs.put("M0525025", "Bella Aster Kevia");
```

Untuk memaninpulasi obyek mahasiswa dengan indeks **M0525025** dalam map `dataMhs`:
```c++
dataMhs.put("M0525025", "Bella"); // overwrite nama lama
```

### Get

Mengambil nama berdasarkan NIM:
```Java
dataMhs.get("M0525025");
```

### Contains Key
Mengecek apakah mahasiswa dengan indeks **M0525025** berada dalam `dataMhs`:
```Java
if (dataMhs.containsKey("M0525025")) {
    System.out.println("M0525025 merupakan mahasiswa UNS.");
} else {
    System.out.println("M0525025 bukan merupakan mahasiswa UNS.");
}
```

### Remove

Menghapus **M0525025** dari `dataMhs`:
```Java
dataMhs.remove("M0525025");
```

### Clear

Menghapus seluruh isi pada map `dataMhs`:
```Java
dataMhs.clear();
```

### Iteration

Iterasi seluruh kunci (NIM) pada `dataMhs`:
```Java
for (String i : dataMhs.keySet()) {
  System.out.println(i);
}
```

Iterasi seluruh value (nama) pada `dataMhs`:
```Java
for (String i : dataMhs.values()) {
  System.out.println(i);
}
```

Iterasi seluruh NIM beserta nama yang terdapat pada pada `dataMhs`:
```Java
for (String i : dataMhs.keySet()) {
  System.out.println("NIM: " + i + " Nama: " + dataMhs.get(i));
}
```

## Selengkapnya

- [Java HashMap](https://www.w3schools.com/java/java_hashmap.asp)
- [Java LinkedHashMap](https://www.tpointtech.com/java-linkedhashmap)
- [Java TreeMap](https://www.tpointtech.com/java-treemap)
