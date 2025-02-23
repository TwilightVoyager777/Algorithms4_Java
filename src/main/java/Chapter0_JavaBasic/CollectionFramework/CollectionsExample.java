package Chapter0_JavaBasic.CollectionFramework;

import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class CollectionsExample {
    public static void main(String[] args) {
        //List
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Apple"); //可以重复
        list.add("Banana");
        System.out.println("List: " + list.get(1));

        //Set
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Apple1"); //不可重复
        System.out.println("Set size :" + set.size());

        //Map
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Mike", 30);
        System.out.println("Map: " + map.get("Mike"));
    }

}
