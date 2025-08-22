package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.QueueExercises;

public class DesignCircularQueue {

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularQueue {
        private int[] arr;
        private int front, rear, size;

        public MyCircularQueue(int k) {
            size = k + 1; // 多开一个空间来区分满和空
            arr = new int[size];
            front = 0;
            rear = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;
            arr[rear] = value;
            rear = (rear + 1) % size;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            front = (front + 1) % size;
            return true;
        }

        public int Front() {
            if (isEmpty()) return -1;
            return arr[front];
        }

        public int Rear() {
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
     * Your MyCircularQueue object will be instantiated and called as such:
     * MyCircularQueue obj = new MyCircularQueue(k);
     * boolean param_1 = obj.enQueue(value);
     * boolean param_2 = obj.deQueue();
     * int param_3 = obj.Front();
     * int param_4 = obj.Rear();
     * boolean param_5 = obj.isEmpty();
     * boolean param_6 = obj.isFull();
     */
    //leetcode submit region end(Prohibit modification and deletion)

    

}