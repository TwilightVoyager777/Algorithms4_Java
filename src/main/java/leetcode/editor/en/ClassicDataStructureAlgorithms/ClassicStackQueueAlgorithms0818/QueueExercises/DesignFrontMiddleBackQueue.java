package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.QueueExercises;

import java.util.*;

public class DesignFrontMiddleBackQueue {

    //leetcode submit region begin(Prohibit modification and deletion)
    class FrontMiddleBackQueue {
        Deque<Integer> left, right;

        public FrontMiddleBackQueue() {
            left = new ArrayDeque<>();
            right = new ArrayDeque<>();
        }

        // 保持平衡
        private void balance() {
            if (left.size() > right.size() + 1) {
                right.offerFirst(left.pollLast());
            } else if (left.size() < right.size()) {
                left.offerLast(right.pollFirst());
            }
        }

        public void pushFront(int val) {
            left.offerFirst(val);
            balance();
        }

        public void pushMiddle(int val) {
            if (left.size() > right.size()) {
                right.offerFirst(left.pollLast());
            }
            left.offerLast(val);
        }

        public void pushBack(int val) {
            right.offerLast(val);
            balance();
        }

        public int popFront() {
            if (isEmpty()) return -1;
            int val = left.pollFirst();
            if (val == 0 && left.isEmpty()) { // 这里防止空指针
                if (!right.isEmpty()) {
                    val = right.pollFirst();
                }
            }
            balance();
            return val;
        }

        public int popMiddle() {
            if (isEmpty()) return -1;
            int val = left.pollLast();
            balance();
            return val;
        }

        public int popBack() {
            if (isEmpty()) return -1;
            int val;
            if (!right.isEmpty()) {
                val = right.pollLast();
            } else {
                val = left.pollLast();
            }
            balance();
            return val;
        }

        private boolean isEmpty() {
            return left.isEmpty() && right.isEmpty();
        }
    }


    /**
     * Your FrontMiddleBackQueue object will be instantiated and called as such:
     * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
     * obj.pushFront(val);
     * obj.pushMiddle(val);
     * obj.pushBack(val);
     * int param_4 = obj.popFront();
     * int param_5 = obj.popMiddle();
     * int param_6 = obj.popBack();
     */
    //leetcode submit region end(Prohibit modification and deletion)


}