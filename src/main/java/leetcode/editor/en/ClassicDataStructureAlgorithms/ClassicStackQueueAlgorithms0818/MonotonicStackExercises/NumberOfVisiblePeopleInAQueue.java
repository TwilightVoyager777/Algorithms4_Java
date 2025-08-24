package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.MonotonicStackExercises;

import java.util.*;

public class NumberOfVisiblePeopleInAQueue {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] canSeePersonsCount(int[] heights) {
            int n = heights.length;
            int[] res = new int[n];
            Stack<Integer> stk = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                int count = 0;
                while (!stk.isEmpty() && stk.peek() <= heights[i]) {
                    stk.pop();
                    count++;
                }
                res[i] = stk.isEmpty() ? count : count + 1;
                stk.push(heights[i]);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new NumberOfVisiblePeopleInAQueue().new Solution();
        // put your test code here
        
    }
}