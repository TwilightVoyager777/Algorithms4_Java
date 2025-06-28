package Exercise0;

import java.util.HashSet;
import java.util.Arrays;

public class HashSetExercise {
    public static void main(String[] args) {
        // 初始化一个包含元素"A","B","C","D"的HashSet
        HashSet<String> hashset = new HashSet<>(Arrays.asList("A", "B", "C"));
        // 检查HashSet是否为空并输出结果
        System.out.println(hashset.isEmpty());
        // 输出HashSet的当前大小
        System.out.println(hashset.size());
        // 检查元素"B"是否存在并输出结果
        if (hashset.contains("B")) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        // 添加新元素"E"
        hashset.add("E");
        // 删除元素"C"
        hashset.remove("C");
        // 再次检查元素"C"是否存在并输出结果
        if (hashset.contains("C")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        // 遍历并输出HashSet中的所有元素
        for (String hs : hashset) {
            System.out.print(hs + " ");
        }
    }
}