package Exercise0;

import java.util.HashMap;
import java.util.Map;

public class HashMapExercise {
    public static void main(String[] args) {
        // 初始化一个HashMap，包含键值对：101->"Alice", 102->"Bob", 103->"Charlie"
        HashMap<Integer, String> hashmap = new HashMap<>();
        hashmap.put(101,"Alice");
        hashmap.put(102,"Bob");
        hashmap.put(103,"Charlie");
        // 检查HashMap是否为空并输出结果
        System.out.println(hashmap.isEmpty());
        // 输出HashMap的当前大小
        System.out.println(hashmap.size());
        // 检查键102是否存在并输出对应的值
        if (hashmap.containsKey(102)) {
            System.out.println(hashmap.get(102));
        } else {
            System.out.println("null");
        }
        // 尝试获取不存在的键104的值，直接输出结果
        System.out.println(hashmap.get(104));
        // 尝试获取不存在的键104的值，若不存在则输出"Unknown"
        System.out.println(hashmap.getOrDefault(104,"Unknown"));
        // 添加新的键值对104->"David"
        hashmap.put(104, "David");
        // 删除键103对应的键值对
        hashmap.remove(103);
        // 检查删除后键103是否存在
        if (hashmap.containsKey(103)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        // 遍历并输出HashMap中的所有键值对
        for(Map.Entry<Integer, String> entry : hashmap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        // 仅遍历并输出HashMap中的所有键
        for(Integer key : hashmap.keySet()) {
            System.out.println(key);
        }
        // 仅遍历并输出HashMap中的所有值
        for(String value : hashmap.values()) {
            System.out.println(value);
        }
    }
}