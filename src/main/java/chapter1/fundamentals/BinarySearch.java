package chapter1.fundamentals;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {
    //javac -cp lib/algs4.jar -d out src/main/java/chapter1/fundamentals/BinarySearch.java
    //java -cp lib/algs4.jar:out chapter1.fundamentals.BinarySearch src/main/resources/algs4-data/tinyW.txt < src/main/resources/algs4-data/tinyT.txt
    // 二分查找：在有序数组中查找目标值
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid; // 找到目标值，返回索引
            }
        }
        return -1; // 如果没有找到，返回 -1
    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist) < 0)
                StdOut.println(key);
        }
    }
}

