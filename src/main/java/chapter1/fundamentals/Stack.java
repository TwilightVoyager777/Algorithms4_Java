package chapter1.fundamentals;

import java.util.Iterator;
import java.util.ListIterator;

public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public Stack() {
        first = null;
        N = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        if(isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek() {
        if(isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return first.item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println("栈大小 " + stack.size());
        System.out.println("栈顶元素" + stack.peek());
        System.out.println("出栈" + stack.pop());

    }
}
