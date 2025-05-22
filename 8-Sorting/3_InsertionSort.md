# 3. Insertion Sort

Insertion sort adalah algoritma pengurutan sederhana yang bekerja dengan membagi daftar menjadi dua bagian: bagian terurut dan bagian belum terurut. Algoritma ini memproses satu elemen pada satu waktu dan memasukkannya ke posisi yang tepat dalam bagian terurut. Algoritma ini lebih efisien daripada bubble sort dan selection sort dalam beberapa kasus.

![Ilustrasi Insertion Sort](https://github.com/Alfurqon02/Praktikum-SDA-2023/blob/main/Bab8-Sorting/img/insertionsort.jpg)

## Kelebihan
- Sederhana dan mudah dipahami
- Efisien untuk jumlah data yang hampir terurut
- Dapat menjaga urutan relatif dari elemen yang bernilai sama

## Kekurangan
- Kompleksitas waktu yang tinggi "O(n^2)"
- Tidak efisien untuk reverse sorting (pengurutan terbalik)
- Penggunaan memori yang tidak efisien

## Contoh Penerapan
```java
static void insertionSort(int[] arr) {
    int n = arr.length;

    for (int i = 1; i < n; ++i) {
        int key = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        
        arr[j + 1] = key;
    }
}

static void printArray(int[] arr){
    for (int val : arr) {
        System.out.print(val + " ");
    }

    System.out.println();
}

public static void main(String[] args) {
    int arr[] = { 23, 56, 9, 103, 77 };

    insertionSort(arr);
    System.out.print("Sorted array: ");
    printArray(arr);
}
```

Proses Insertion Sort:
```
Iterasi 1:
[23  56] 9  103  77

| Sorted |  Unsorted  |
| ------ | ---------- |
| 23  56 | 9  103  77 |

Iterasi 2:
 23 [56 9]  103  77
[23  9] 56  103  77

|  Sorted | Unsorted |
| ------- | -------- |
| 9 23 56 |  103  77 |

Iterasi 3:
 9  23 [56  103] 77

|     Sorted     | Unsorted |
| -------------- | -------- |
| 9  23  56  103 |    77    |

Iterasi 4:
 9  23  56 [103  77]
 9  23 [56  77] 103

|       Sorted       | Unsorted |
| ------------------ | -------- |
| 9  23  56  77  103 |          |

Hasil akhir -> 9, 23, 56, 77, 103
```
