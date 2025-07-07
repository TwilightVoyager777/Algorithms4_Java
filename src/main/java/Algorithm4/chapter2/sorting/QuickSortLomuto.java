package Algorithm4.chapter2.sorting;

import java.util.Arrays;

public class QuickSortLomuto {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pivotIndex = partition(a, lo, hi); // Lomuto 分区，找到 pivot 的最终位置
        sort(a, lo, pivotIndex - 1);
        sort(a, pivotIndex + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable pivot = a[hi]; // 选择最后一个元素作为基准
        int i = lo - 1; // i 追踪比 pivot 小的区域

        for(int j = lo; j < hi; j++) {
            if (a[j].compareTo(pivot) < 0) { // 如果 a[j] < pivot
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
