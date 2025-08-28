package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.MonotonicQueueExercises;

import java.util.*;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            int left = 0, right = 0;
            int windowSize = 0, res = 0;
            MonotonicQueue<Integer> window = new MonotonicQueue<>();
            while (right < nums.length) {
                window.push(nums[right]);
                right++;
                windowSize++;
                while (window.max() - window.min() > limit) {
                    window.pop();
                    left++;
                    windowSize--;
                }
                res = Math.max(res, windowSize);
            }
            return res;
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
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit().new Solution();
        // put your test code here
        
    }
}