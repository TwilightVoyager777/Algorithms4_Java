package chapter0.javabasic.Collections;

import java.util.*;
import java.util.List;

public class CollectionDemo {
    public static void main(String[] args){
        //1.ArrayList示例
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("cherry");
        System.out.println("原始列表:" + fruits);
        //2.HashMap示例
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice",55);
        scores.put("Mike",66);
        scores.put("Jake",77);
        System.out.println("Jake的分数为 " + scores.get("Jake") + " 分");
        Iterator<String> it = fruits.iterator();
        while (it.hasNext()) {
            String fruit = it.next();
            if (fruit.startsWith("b")){
                it.remove();
            }
        }
        System.out.println("删除后列表为:" + fruits);

    }
}
