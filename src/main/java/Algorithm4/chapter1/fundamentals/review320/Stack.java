package Algorithm4.chapter1.fundamentals.review320;

import java.util.NoSuchElementException;

public class Stack<Item> {
    private Node first;
    private int size;

    public class Node {
        Item item;
        Node next;
    }

    public Stack() {
        first = null;
        size = 0;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public Item pop(){
        if (isEmpty()) {
            throw new NoSuchElementException("栈空");
        }
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size() {
        return size;
    }
}
