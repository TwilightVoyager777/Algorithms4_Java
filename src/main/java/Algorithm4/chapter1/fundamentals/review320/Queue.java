package Algorithm4.chapter1.fundamentals.review320;

import java.util.NoSuchElementException;

public class Queue<Item> {

    private Node first;
    private Node last;
    private int size;

    public class Node{
        Item item;
        Node next;
    }

    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public Item dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException("1");
        }
        Item item = first.item;
        first = first.next;
        if(isEmpty()) {
            last = null;
        }
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
