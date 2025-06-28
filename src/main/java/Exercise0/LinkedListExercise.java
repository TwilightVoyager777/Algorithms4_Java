package Exercise0;

import java.util.LinkedList;
import java.util.Arrays;

public class LinkedListExercise {
    public static void main(String[] args) {
        // 初始化一个包含元素10,20,30,40,50的LinkedList
        LinkedList<Integer> lst = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50));
        // 检查LinkedList是否为空并输出结果
        System.out.println(lst.isEmpty());
        // 输出LinkedList的当前大小
        System.out.println(lst.size());
        // 在链表头部插入元素5
        lst.addFirst(5);
        // 在链表尾部插入元素55
        lst.addLast(55);
        // 获取并输出链表头部和尾部元素
        System.out.println(lst.getFirst());
        System.out.println(lst.getLast());
        // 删除链表头部元素
        lst.removeFirst();
        // 删除链表尾部元素
        lst.removeLast();
        // 在索引2的位置插入元素25
        lst.add(2, 25);
        // 删除索引3处的元素
        lst.remove(3);
        // 遍历并输出LinkedList中的所有元素
        for(int lst1 : lst) {
            System.out.println(lst1);
        }
    }
}