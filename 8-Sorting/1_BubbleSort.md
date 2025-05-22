# 1. Bubble Sort

Bubble sort adalah algoritma pengurutan sederhana yang bekerja dengan membandingkan pasangan elemen bersebelahan dalam daftar dan menukar mereka jika urutan mereka salah. Ini berulang kali melintasi data hingga tidak ada lagi pertukaran yang perlu dilakukan, sehingga elemen-elemen terurut secara bertahap naik ke posisi yang tepat. Algoritma ini dinamakan "bubble sort" karena elemen-elemen yang lebih kecil "naik ke permukaan" seperti gelembung air saat diurutkan. Meskipun bubble sort mudah dipahami, namun biasanya kurang efisien untuk daftar yang besar karena kompleksitas waktu yang lebih tinggi daripada algoritma pengurutan lainnya.

![Ilustrasi Bubblesort](https://github.com/Alfurqon02/Praktikum-SDA-2023/blob/main/Bab8-Sorting/img/bubblesort.jpg)

## Kelebihan
- Implementasi dan pemahaman yang sederhana.
- Cocok untuk data yang hampir terurut

## Kekurangan
- Kompleksitas waktu yang buruk "O(n^2)" 
- Penggunaan memori yang tidak efisien
- Jika ada elemen dengan nilai yang sama, posisi dapat berubah setelah dilakukan sorting

## Contoh Penerapan
berikut source code untuk menerapkan bubble sort pada array [4, 1, 2, 3]

```java
static void bubbleSort(int arr[], int n){
    int i, j, temp;

    for (i = 0; i < n - 1; i++) {
        for (j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {        
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

static void printArray(int[] arr){
    for (int val : arr) {
        System.out.print(val + " ");
    }

    System.out.println();
}

public static void main(String args[]){
    int arr[] = { 4, 1, 2, 3 };
    int n = arr.length;

    bubbleSort(arr, n);
    System.out.println("Sorted array: ");
    printArray(arr);
}
```

Proses Bubble Sort:
```
Iterasi 1:
[4  2] 3  1
 2 [4  3] 1
 2  3 [4  1]
 2  3  1  4

Iterasi 2:
[2  3] 1  4
 2 [3  1] 4
 2  1 [3  4]
 2  1  3  4

Iterasi 3:
[2  1] 3  4
 1 [2  3] 4
 1  2 [3  4]
 1  2  3  4

Iterasi 4:
[1  2] 3  4
 1 [2  3] 4
 1  2 [3  4]
 1  2  3  4

Hasil akhir -> 1, 2, 3, 4
```
