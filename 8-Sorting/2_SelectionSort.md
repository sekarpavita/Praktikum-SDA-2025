# 2. Selection Sort

Selection sort adalah algoritma pengurutan sederhana yang bekerja dengan mencari elemen terkecil dari daftar dan menukar elemen tersebut dengan elemen pertama. Kemudian, mencari elemen terkecil kedua dari daftar yang belum terurut dan menukar elemen tersebut dengan elemen kedua. Proses ini berlanjut hingga seluruh daftar terurut. Algoritma ini dinamakan "selection sort" karena pada setiap langkahnya, algoritma memilih elemen terkecil dari sisa daftar yang belum terurut dan memindahkannya ke posisi yang sesuai.

![Ilustrasi Selection Sort](https://github.com/Alfurqon02/Praktikum-SDA-2023/blob/main/Bab8-Sorting/img/selectionsort.png)

## Kelebihan
- Sederhana dan mudah dipahami
- Dapat menjaga urutan relatif dari elemen elemen yang sama

## Kekurangan
- Kompleksitas waktu yang tinggi "O(n^2)"
- Tidak efisien untuk data yang hampir terurut
- Penggunaan memori yang tidak efisien

## Contoh Penerapan

```java
static void selectionSort(int[] arr){
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
          
        int min_idx = i;

        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[min_idx]) {
                min_idx = j;
            }
        }

        int temp = arr[i];
        arr[i] = arr[min_idx];
        arr[min_idx] = temp;           
    }
}

static void printArray(int[] arr){
    for (int val : arr) {
        System.out.print(val + " ");
    }

    System.out.println();
}

public static void main(String[] args){
    int[] arr = { 7, 2, 8, 1, 4 };

    selectionSort(arr);
    System.out.print("Sorted array: ");
    printArray(arr);
}
```

Proses Selection Sort:
```
Iterasi 1:
[7  2  8  1  4]
 1  2  8  7  4

Iterasi 2:
 1 [2  8  7  4]
 1  2  8  7  4

Iterasi 3:
 1  2 [8  7  4]
 1  2  4  7  8

Iterasi 4:
 1  2  4 [7  8]
 1  2  4  7  8

Hasil akhir -> 1, 2, 4, 7, 8
```
