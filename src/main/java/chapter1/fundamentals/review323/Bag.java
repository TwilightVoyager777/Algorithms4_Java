package chapter1.fundamentals.review323;

public class Bag<Item> {

    private Node first;
    private int size;

    public class Node {
        Item item;
        Node next;
    }

    public Bag() {
        first = null;
        size = 0;
    }

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }
}