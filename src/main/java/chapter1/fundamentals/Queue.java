package chapter1.fundamentals;

import java.util.Iterator;
import java.util.ListIterator;

public class Queue <Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public Queue() {
        first = null;
        last = null;
        N = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldlast = last;

        last = new Node();
        last.item = item;
        last.next = null;

        if(isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        Item item = first.item;
        first = first.next;
        N--;
        if(isEmpty()) {
            last = null;
        }
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
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
class TestQueue {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println("长度为" + queue.size());
        System.out.println("出队" + queue.dequeue());
        for (String s : queue)
            System.out.println(s);
    }
}
