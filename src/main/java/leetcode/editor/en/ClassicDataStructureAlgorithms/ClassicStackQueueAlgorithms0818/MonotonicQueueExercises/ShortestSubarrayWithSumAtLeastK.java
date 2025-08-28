package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.MonotonicQueueExercises;

import java.util.*;

public class ShortestSubarrayWithSumAtLeastK {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int n = nums.length;
            long[] preSum = new long[n + 1];
            preSum[0] = 0;
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
            MonotonicQueue<Long> window = new MonotonicQueue<>();
            int right = 0, left = 0;
            int len = Integer.MAX_VALUE;
            while (right < preSum.length) {
                window.push(preSum[right]);
                right++;
                while (right < preSum.length && !window.isEmpty() && preSum[right] - window.min() >= k) {
                    len = Math.min(len, right - left);
                    window.pop();
                    left++;
                }
            }
            return len == Integer.MAX_VALUE ? -1 : len;
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
        Solution solution = new ShortestSubarrayWithSumAtLeastK().new Solution();
        // put your test code here
        
    }
}