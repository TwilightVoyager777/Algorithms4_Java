package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.MonotonicQueueExercises;

import java.util.*;

public class JumpGameVi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxResult(int[] nums, int k) {
           int n = nums.length;
           MonotonicQueue<Integer> window = new MonotonicQueue<>();
           int[] dp = new int[n];
           Arrays.fill(dp, Integer.MIN_VALUE);
           dp[0] = nums[0];
           window.push(dp[0]);
           for (int p = 1; p < n; p++) {
               dp[p] = window.max() + nums[p];
               if (window.size() == k) {
                   window.pop();
               }
               window.push(dp[p]);
           }
           return dp[n - 1];
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
        Solution solution = new JumpGameVi().new Solution();
        // put your test code here
        
    }
}