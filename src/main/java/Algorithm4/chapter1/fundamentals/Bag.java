package Algorithm4.chapter1.fundamentals;

import java.util.Iterator;
import java.util.ListIterator;

public class Bag<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public Bag() {
        first = null;
        N = 0;
    }

    public void add (Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public int size() {
        return N;
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
class TestBag {
    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();
        bag.add("apple");
        bag.add("banana");
        bag.add("bary");
        System.out.println("元素个数" + bag.size());
        for (String fruit : bag) {
            System.out.println(fruit);
        }
    }
}
