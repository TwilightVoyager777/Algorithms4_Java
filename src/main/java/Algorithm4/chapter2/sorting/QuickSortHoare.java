package Algorithm4.chapter2.sorting;

import java.util.Arrays;

public class QuickSortHoare {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pivotIndex = partition(a, lo, hi);
        sort(a, lo, pivotIndex);
        sort(a, pivotIndex + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable pivot = a[lo];
        int i = lo - 1, j = hi + 1;

        while (true) {
            do {
                i++;
            } while (a[i].compareTo(pivot) < 0);

            do {
                j--;
            } while (a[j].compareTo(pivot) > 0);

            if (i >= j) {
                return j;
            }
            swap(a, i, j);
        }
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
