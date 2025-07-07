package Algorithm4.Exercise0;

import java.util.Queue;
import java.util.LinkedList;

public class QueueExercise {
    public static void main(String[] args) {
        // 初始化一个空的字符串队列
        Queue<String> q = new LinkedList<>();
        // 在队尾依次添加元素"Apple"、"Banana"、"Cherry"
        q.offer("Apple");
        q.offer("Banana");
        q.offer("Cherry");
        // 检查队列是否为空并输出结果
        System.out.println(q.isEmpty());
        // 输出队列的当前大小
        System.out.println(q.size());
        // 获取但不移除队列的队头元素
        System.out.println(q.peek());
        // 移除并返回队头元素
        System.out.println(q.poll());
        // 再次获取队头元素
        System.out.println(q.peek());
        // 遍历队列并输出所有元素（注意：遍历不会移除元素）
        for (String p : q) {
            System.out.println(p);
        }
    }
}