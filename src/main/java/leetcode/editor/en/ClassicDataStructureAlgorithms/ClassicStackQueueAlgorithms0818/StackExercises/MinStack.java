package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.StackExercises;

import java.util.*;

public class MinStack {

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack1 {

        Stack<Integer> stk = new Stack<>();
        Stack<Integer> minStk = new Stack<>();

        public MinStack1() {

        }
        
        public void push(int val) {
            stk.push(val);
            if (minStk.isEmpty() || val <= minStk.peek()) {
                minStk.push(val);
            } else {
                minStk.push(minStk.peek());
            }
        }
        
        public void pop() {
            stk.pop();
            minStk.pop();
        }
        
        public int top() {
            return stk.peek();
        }
        
        public int getMin() {
            return minStk.peek();
        }
    }
    
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    //leetcode submit region end(Prohibit modification and deletion)

    

}