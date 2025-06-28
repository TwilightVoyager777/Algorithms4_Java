package Exercise0;

import java.util.Stack;

public class StackExercise {
    public static void main(String[] args) {
        // 初始化一个空的字符串栈
        Stack<String> s = new Stack<>();
        // 向栈顶依次添加元素"First"、"Second"、"Third"
        s.push("First");
        s.push("Second");
        s.push("Third");
        // 检查栈是否为空并输出结果
        System.out.println(s.isEmpty());
        // 输出栈的当前大小
        System.out.println(s.size());
        // 获取但不移除栈顶元素
        System.out.println(s.peek());
        // 移除并返回栈顶元素
        System.out.println(s.pop());
        // 再次获取栈顶元素
        System.out.println(s.peek());
        // 遍历栈并输出所有元素（从栈顶到栈底）
        for (String ss : s) {
            System.out.print(ss + " ");
        }
    }
}