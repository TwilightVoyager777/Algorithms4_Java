package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.QueueExercises;

public class DesignCircularDeque {

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularDeque {
        private int[] arr;
        private int front, rear, size;

        public MyCircularDeque(int k) {
            size = k + 1; // 多开一个空间，区分满和空
            arr = new int[size];
            front = 0;
            rear = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) return false;
            // front 往前移一格再放值
            front = (front - 1 + size) % size;
            arr[front] = value;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) return false;
            arr[rear] = value;
            rear = (rear + 1) % size;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) return false;
            front = (front + 1) % size;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;
            rear = (rear - 1 + size) % size;
            return true;
        }

        public int getFront() {
            if (isEmpty()) return -1;
            return arr[front];
        }

        public int getRear() {
            if (isEmpty()) return -1;
            return arr[(rear - 1 + size) % size];
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }
    }

    /**
     * Your MyCircularDeque object will be instantiated and called as such:
     * MyCircularDeque obj = new MyCircularDeque(k);
     * boolean param_1 = obj.insertFront(value);
     * boolean param_2 = obj.insertLast(value);
     * boolean param_3 = obj.deleteFront();
     * boolean param_4 = obj.deleteLast();
     * int param_5 = obj.getFront();
     * int param_6 = obj.getRear();
     * boolean param_7 = obj.isEmpty();
     * boolean param_8 = obj.isFull();
     */
    //leetcode submit region end(Prohibit modification and deletion)


}