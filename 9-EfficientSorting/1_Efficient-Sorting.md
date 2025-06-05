# Efficient Sorting

Pada praktikum sebelumnya, teman-teman sudah belajar mengenai algoritma sorting yang simpel, seperti _insertion sort_, _selection sort_, dan _bubble sort_. Karakteristik dari algoritma sorting simpel di atas adalah kodenya yang simpel sehingga (relatif) lebih mudah dipahami, kompleksitas waktu yang (relatif) buruk, dan performanya yang kurang baik untuk data besar dan tidak tersortir dengan baik.

Oleh karena itu, penggunaan algoritma sorting sederhana hanya diperuntukkan untuk penggunaan-penggunaan yang sederhana pula, yaitu pada data berjumlah kecil atau sudah hampir tersortir.

Untuk penggunaan yang lebih _advanced_, diperlukan algoritma sorting yang lebih efisien. Dalam materi ini, akan dibahas 2 algoritma sorting yang sangat efisien dan digunakan secara luas, yaitu _quicksort_ dan _mergesort_.

## 1. Quicksort

_Quicksort_ adalah algoritma pertama yang akan kita pelajari pada praktikum kali ini. _Quicksort_ adalah algoritma pengurutan _divide-and-conquer_ rekursif yang bekerja dengan memilih sebuah elemen _pivot_, dan membagi/mempartisi elemen lainnya, berdasarkan dari perbandingan nilai antara elemen tersebut dan elemen _pivot_.

### 1.1 Kompleksitas Waktu dan Memori

-   Best Case: `O(n log n)` menggunakan _simple partition_
-   Average Case: `O(n log n)`
-   Worst Case: `O(n^2)`
-   Kompleksitas memori: secara garis besar `O(log n)`

### 1.2 Contoh

```Java
public class QuickSort {

    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("Array asli:");
        printArray(arr);

        QuickSort qs = new QuickSort();
        qs.sort(arr, 0, arr.length - 1);

        System.out.println("Array setelah Quicksort:");
        printArray(arr);
    }
}
```

Algoritma _partition_ akan kita lompati untuk sekarang, yang memiliki fungsi:

-   Menentukan `pivot`, dapat mengambil nilai arbitrer atau random,
-   Meletakkan `pivot` ke posisinya dengan menukar posisi `pivot` dengan posisi yang seharusnya,
-   Mengurutkan bagian kanan dan kiri dari elemen `pivot`.

<div align="center">
<img src="https://lh7-us.googleusercontent.com/docsz/AD_4nXd_VD-PkxcpHnLp5ZJrgUXyIgh1ln6thyBna__49yH3YrOFSWdkcc2Qh8Lxf74uIcfnkpTWkump1uHsXt8HUBi2p4DpNRy43GStHkxkxr0e9E8hVx8Lpszk3rcO9yVUSd1-7BJUsaLsB6pNM5_70uOYNTw_?key=3_UPicvf_BgAHhUYi-MqCw"></img>
</div>

## 2. Mergesort

Algoritma sorting _Mergesort_ merupakan algoritma divide-and-conquer yang membagi set permasalahan yang akan diurutkan menjadi unit terkecil, lalu membandingkan masing-masing unit dengan unit di sebelahnya dan mengurutkannya. Langkah ini diulang terus-menerus hingga didapatkan hasil akhir berupa set permasalahan yang sudah terurut.

### 2.1 Kompleksitas Waktu dan Memori

-   Best Case: `O(n log n)`
-   Average Case: `O(n log n)`
-   Worst Case: `O(n log n)`
-   Kompleksitas memori: `O(n)`

### 2.2 Contoh

```Java
public class MergeSort {

    public void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Array asli:");
        printArray(arr);

        MergeSort ms = new MergeSort();
        ms.sort(arr, 0, arr.length - 1);

        System.out.println("Array setelah Mergesort:");
        printArray(arr);
    }
}
```

<div align="center">
<img src="https://upload.wikimedia.org/wikipedia/commons/c/cc/Merge-sort-example-300px.gif"></img>
</div>

## Perbandingan Quicksort dan Mergesort

-   Persamaan

    -   Keduanya merupakan algoritma pengurutan yang sangat efisien dan banyak digunakan untuk implementasi yang luas
    -   Merupakan algoritma divide-and-conquer yang membagi masalah besar menjadi banyak masalah-masalah kecil (submasalah)
    -   Dengan implementasi yang ideal, memiliki kompleksitas best case dan average case yang sepadan

-   Perbedaan

    -   _Mergesort_ memiliki kompleksitas worst case yang lebih baik yaitu `O(n log n)` daripada _quicksort_ `O(n^2)`
    -   _Mergesort_ memiliki kompleksitas ruang yang sedikit lebih buruk karena bukan merupakan algoritma pengurutan _in-place_, berbeda dengan _quicksort_
    -   _Quicksort_ bekerja lebih baik pada data yang kecil, sedangkan _mergesort_ tidak berbeda jauh performanya untuk data kecil maupun besar
