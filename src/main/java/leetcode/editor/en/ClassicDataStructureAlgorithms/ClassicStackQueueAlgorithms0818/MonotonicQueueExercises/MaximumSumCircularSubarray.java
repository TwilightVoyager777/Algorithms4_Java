package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.MonotonicQueueExercises;

import java.util.*;

public class MaximumSumCircularSubarray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int n = nums.length;
            int[] preSum = new int[2 * n + 1];
            preSum[0] = 0;
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + nums[(i - 1) % n];
            }
            int maxSum = Integer.MIN_VALUE;
            MonotonicQueue<Integer> window = new MonotonicQueue<>();
            window.push(0);
            for (int i = 1; i < preSum.length; i++) {
                maxSum  = Math.max(maxSum, preSum[i] - window.min());
                if (window.size() == n) {
                    window.pop();
                }
                window.push(preSum[i]);
            }
            return maxSum;
        }
    }

    class MonotonicQueue<E extends Comparable<E>> {
        LinkedList<E> q = new LinkedList<>();
        LinkedList<E> maxq = new LinkedList<>();
        LinkedList<E> minq = new LinkedList<>();
        public void push(E elem) {
            q.addLast(elem);
            while (!maxq.isEmpty() && maxq.getLast().compareTo(elem) < 0) {
                maxq.pollLast();
            }
            maxq.addLast(elem);
            while (!minq.isEmpty() && minq.getLast().compareTo(elem) > 0) {
                minq.pollLast();
            }
            minq.addLast(elem);
        }
        public E max() {
            return maxq.getFirst();
        }
        public E min() {
            return minq.getFirst();
        }
        public E pop() {
            E deleteVal = q.pollFirst();
            assert deleteVal != null;
            if (deleteVal.equals(maxq.getFirst())) {
                maxq.pollFirst();
            }
            if (deleteVal.equals(minq.getFirst())) {
                minq.pollFirst();
            }
            return deleteVal;
        }
        public int size() {
            return q.size();
        }
        public boolean isEmpty() {
            return q.isEmpty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MaximumSumCircularSubarray().new Solution();
        // put your test code here
        
    }
}