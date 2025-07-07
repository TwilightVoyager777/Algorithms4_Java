package Algorithm4.chapter1.fundamentals;

public class SinglyLinkedList {
    private Node head;

    private static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public void addFirst(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public void removeFirst() {
        if (head == null) return;
        head = head.next;
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
class TestSinglyLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        System.out.print("初始链表:");
        list.printList();

        list.removeFirst();
        System.out.print("删除头节点后:");
        list.printList();

        list.reverse();
        System.out.print("反转链表后：");
        list.printList();
    }
}
