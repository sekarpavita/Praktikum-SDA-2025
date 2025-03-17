# Tugas Praktikum List, Stack, & Queue

NOTE

1. Gunakan bahasa **Java**
2. Kumpulkan semua source code pada assignment Google Classroom **(tidak usah di-ZIP)**, diberi format: 
PSDA01_L0122190_JohnDoe-1.java 9 (untuk list)
PSDA01_L0122190_JohnDoe-2.java 9 (untuk stack)
PSDA01_L0122190_JohnDoe-3.java 9 (untuk queue)
3. Kumpulkan pdf berisi penjelasan setiap code *(1 pdf saja)* pada assignment Google Classroom, diberi format:
PSDA01_L0122190_JohnDoe.pdf
4. Jika ada pertanyaan, silakan bertanya kepada asisten
5. Deadline: 24 Maret 2025
8. Anda dapat menggunakan library Java yang sudah ada (seperti ArrayList, LinkedList, Stack, Queue)
9. Format laporan sudah terlampir di google classroom

## No. 1 - List

Ikuti langkah-langkah berikut **(bobot: 40%)**:

1. Buatlah list untuk menyimpan data berupa sekumpulan string: **Rambutan**, **Jambu**, **Jeruk**, **Melon**, **Semangka**, **Durian**
2. Bagi list menjadi 2 bagian (list1 dan list2), dengan isi list1 : **Rambutan**, **Jambu**, **Jeruk** dan isi list2 : **Melon**, **Semangka**, **Durian**
3. Lalu hapus **Jambu** dari list1 dan **Durian** dari list2
4. Setelah itu, tampilkan isi dari kedua list tersebut

Contoh Output: 
```
Seluruh List:
Rambutan
Jambu
Jeruk
Melon
Semangka
Durian
List 1:
Rambutan
Jeruk
List 2:
Melon
Semangka
```

Anda boleh menggunakan array list ataupun linked list bawaan dari java

## No. 2 - Stack

Selesaikan permasalahan di bawah menggunakan stack **(bobot: 30%)**:

Piyu berusia 5 tahun dan memiliki tumpukan kaset kartun anak kecil sebagai berikut (urut dari posisi teratas):

Berikut adalah urutan contoh kaset kartun anak kecil yang dimiliki piyu:  


- **Dora the Explorer** 
- **Paw Patrol**
- **Peppa Pig**  
- **Thomas & Friends**
- **Masha and the Bear**
- **SpongeBob SquarePants**  
- **Shinchan**
- **Doraemon**
- **Upin & Ipin** 
- **BoBoiBoy**

Suatu saat Piyu ingin mengurutkan tumpukan buku tersebut agar terurut dan mengambil kaset kartun kesukaannya yaitu **Peppa Pig** untuk di mainkan, sehingga tumpukan kaset kartunnya tersebut menjadi seperti berikut:

- **BoBoiBoy**
- **Dora the Explorer** 
- **Doraemon**
- **Masha and the Bear**
- **Paw Patrol**
- **Shinchan**
- **SpongeBob SquarePants**  
- **Thomas & Friends**
- **Upin & Ipin** 


Buatlah program yang mensimulasikan permasalahan tersebut menggunakan stack! Program tidak harus menampilkan isi stack ke layar ataupun menerima input. Asisten akan menilai ketepatan dari source code dan penjelasan pada laporan yang dibuat.

**DILARANG KERAS MEMBUAT ULANG STACK**

## No. 3 - Queue

Selesaikan permasalahan di bawah menggunakan queue (dan stack) **(bobot: 30%)**:

Komputer Pak Daisuke memiliki berbagai macam perintah:

|Perintah|Deskripsi|
|--|--|
|PUSH 0|Memasukkan angka 0 ke atas stack|
|PUSH 1|Memasukkan angka 1 ke atas stack|
|TOP|Menampilkan angka yang berada di atas stack|
|POP|Mengeluarkan angka yang berada di atas stack|

Komputer tersebut bekerja dengan cara menerima input kemudian memasukkannya ke dalam queue, lalu dieksekusi oleh mesin dengan cara membaca isi queue tersebut. Dengan demikian, apabila komputer pak dengklek menerima perintah (urut):

- PUSH 0
- PUSH 0
- TOP
- PUSH 1
- TOP
- POP
- POP
- TOP

Maka akan menampilkan output berupa:
```
010
```

Buatlah program yang mensimulasikan permasalahan tersebut menggunakan queue (dan stack)! Anda bebas memasukkan perintah apapun ke dalam queue dan melalui manapun (melalui source code atau user input atau file input).
