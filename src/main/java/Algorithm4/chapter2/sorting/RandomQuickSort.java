package Algorithm4.chapter2.sorting;

import java.util.Arrays;
import java.util.Random;

public class RandomQuickSort {

    private static final Random RANDOM = new Random();

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pivotIndex = randomPartition(a, lo, hi);
        sort(a, lo, pivotIndex - 1);
        sort(a, pivotIndex + 1, hi);
    }

    private static int randomPartition(Comparable[] a, int lo, int hi) {
        int randomIndex = lo + RANDOM.nextInt(hi - lo + 1);
        swap(a, randomIndex, hi);
        return partition(a, lo, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable pivot = a[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (a[j].compareTo(pivot) < 0) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, hi);
        return i + 1;
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
