# 1. Konsep Rekursi

**Rekursi** adalah sebuah cara untuk mendefinisikan sebuah permasalahan menggunakan _versi permasalahan itu sendiri yang lebih simpel_. Dalam dunia pemrograman, paradigma rekursi biasanya diterapkan dalam pembuatan **Fungsi Rekursif**. **Fungsi Rekursif** adalah sebuah fungsi yang memanggil dirinya sendiri.

Perhatikan gambar berikut.

![Ilustrasi Rekursi](https://media.geeksforgeeks.org/wp-content/uploads/20230417232220/Recursion-in-Java-1-768.webp)

Pada fungsi `recurse()` terdapat pemanggilan ke fungsi `recurse()` itu sendiri. Alhasil, jika fungsi `recurse()` kita panggil dari `main()` maka akan memanggil dirinya sendiri tanpa henti, yang akan menimbulkan **infinite loop**.

## Bagian-bagian Algoritma Rekursif

> Disclaimer: Ada banyak opini pakar mengenai pembagian dari algoritma rekursif. Materi yang diberikan di bawah mungkin berbeda dengan opini beberapa pakar, namun kami nilai cukup untuk membentuk pemahaman mengenai fungsi rekursif.

### 1. Base Case

Base Case merupakan batasan yang **harus dibuat setiap kali kita membuat sebuah fungsi rekursif** supaya fungsi yang baru saja kita buat tidak menjadi _infinite loop_ atau perulangan infinit yang disebabkan oleh perulangan/rekursi yang tidak dibatasi.

Jika penjelasan di atas kurang dapat dimengerti, perhatikan potongan kode di bawah ini.

```Java
// Potongan 1
while (true) {
    doSomething();
}

// Potongan 2
Integer i = 0;
while (i < 5) {
    doSomething();
    i++;
}
```

Pada potongan pertama, perulangan `while` akan terus dieksekusi karena tidak terdapat batasan. Alhasil, apapun yang berada dalam blok perulangan `while` tersebut akan dieksekusi tanpa henti. Namun, pada potongan kedua, perulangan yang sama dieksekusi dengan batas, yaitu `i < 5`, sehingga perulangan tersebut hanya dilakukan 5 kali. Ini merupakan sebuah konsep yang cukup mirip dengan Base Case di fungsi rekursif, tetapi dengan detail yang sedikit berbeda. Perhatikan contoh di bawah ini.

```
f(n) = n + f(n-1)   untuk n > 1
f(n) = 1            untuk n = 1   <- Base Case
```

Seperti yang dapat kita lihat di atas, definisi `f(n) = 1` pada `n = 1` merupakan batas yang kita buat supaya fungsi rekursif kita dapat berhenti di sebuah titik `n`. 

### 2. Simplifikasi Permasalahan

Komponen simplifikasi permasalahan pada fungsi rekursif dapat didefinisikan sebagai pengurangan panjang statement yang harus dieksekusi komputer. Dengan menggunakan rumus `f` yang sama, komputer yang menghitung `f(3)` secara langsung (bukan rekursif), maka komputer akan mengeksekusi 3 suku penambahan `(1 + 2 + 3)`, sedangkan komputer yang menghitung `f(3)` secara rekursif akan mengeksekusi 2 suku penambahan 2 kali, beserta 1 base case. Konsep simplifikasi/pemecahan masalah ini akan dipelajari lebih lanjut pada algoritma _divide and conquer_.

## Kegunaan Rekursi dan Interpretasi Matematis

> Mengapa rekursi merupakan paradigma yang penting dan pantas untuk kita pelajari?

Perhatikan contoh di bawah, di mana kita ingin menjumlahkan `n` buah bilangan asli.

```
Pendekatan 1:
    f(n) = 1 + 2 + 3 + 4 + ... + n

Pendekatan 2:
    f(n) = 1            untuk n = 1   <- Base Case
    f(n) = n + f(n-1)   untuk n > 1
```

Apa perbedaan di antara 2 pendekatan di atas? Pendekatan pertama menggunakan metode sekuensial, di mana fungsi hanya menambah-nambahkan angka satu-persatu, sedangkan pendekatan kedua menggunakan konsep rekursi, di mana fungsi `f(n)` memanggil dirinya sendiri dengan parameter yang berbeda. Mari kita lihat bagaimana kedua pendekatan berjalan dengan diberikan `n = 5`.

```
Pendekatan 1:
    f(5) = 1 + 2 + 3 + 4 + 5
    f(5) = 15


Pendekatan 2:
    f(5) = 5 + f(4)
        f(4) = 4 + f(3)
            f(3) = 3 + f(2)
                f(2) = 2 + f(1)
                    f(1) = 1    <- Perhatikan Base Case
                f(2) = 2 + 1 = 3
            f(3) = 3 + 3 = 6
        f(4) = 4 + 6 = 10
    f(5) = 5 + 10 = 15
```

Bisa kita lihat di atas bahwa **pendekatan pertama** bekerja seperti penambahan pada umumnya, yaitu menambahkan elemen bilangan real satu persatu.

Pada **pendekatan kedua**, pada masing-masing `n`, fungsi akan memanggil dirinya sendiri dengan parameter `n - 1`. Kita dapat mendefinisikan dua bagian eksekusi program pada pendekatan kedua di atas. Pertama adalah bagian sebelum base case, di mana pemanggilan fungsi kepada dirinya sendiri terjadi, kedua adalah bagian setelah base case, di mana sudah ditemukan jawaban dari `f(1)`, sehingga nilai `f(1)` tersebut dipropagasikan naik. Dalam kalimat yang lebih sederhana, ekspresi `f(2) = 2 + f(1)` akhirnya dapat dievaluasi karena `f(1)` diketahui, ekspresi `f(3) = 3 + f(2)` dapat dievaluasi karena `f(2)` diketahui, dan seterusnya.

## Kelebihan dan Kekurangan

| Kelebihan                                                                                                                        | Kekurangan                                                                                                                      |
| -------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
| Rekursi menyediakan cara yang bersih dan sederhana untuk menulis kode.                                                           | Program rekursif memiliki kebutuhan ruang yang besar karena semua fungsi akan tetap berada di stack sampai kasus dasar tercapai.|
| Beberapa masalah pada dasarnya bersifat rekursif, untuk itu lebih baik menulis kode rekursif.                                    | Program rekursif juga memiliki kebutuhan waktu yang lebih besar karena pemanggilan fungsi dan pengembalian overhead.            |

## Selengkapnya

- [Materi tentang Rekursi](https://github.com/salsarizkii/Praktikum-Dasar-Pemrograman-2024/blob/main/Bab%203-CFunction/4-Rekursi.md)
- [GeeksForGeeks](https://www.geeksforgeeks.org/recursion/)
