package chapter1.fundamentals.review320;

import java.util.NoSuchElementException;

public class review {
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

        public boolean isEmpty(){
            return first == null;
        }

        public int size() {
            return size;
        }

        public void enqueue(Item item) {
            Node oldLast = last;
            last.item = item;
            last.next = null;
            if(isEmpty()) {
                first = last;
            } else {
                oldLast.next = last;
            }
            size++;
        }

        public Item inqueue() {
            if(isEmpty()) {
                throw new NoSuchElementException("栈空");
            }
            Item item = first.item;
            first = first.next;
            if(isEmpty()) {
                last = null;
            }
            size--;
            return item;
        }
    }
}
