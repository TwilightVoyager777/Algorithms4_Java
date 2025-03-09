package chapter0.javabasic.Collections;

import java.util.*;

public class MergeLists {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 3, 4));
        Set<Integer> set = new LinkedHashSet<>(list1);
        List<Integer> mergedList = new ArrayList<>(set);
        System.out.println(mergedList);
    }
}
