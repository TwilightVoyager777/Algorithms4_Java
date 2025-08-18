package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.QueueStackConversion;

import java.util.*;

public class ImplementQueueUsingStacks {

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {
        private Stack<Integer> s1, s2;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }
        
        public void push(int x) {
            s1.push(x);
        }
        
        public int pop() {
            peek();
            return s2.pop();
        }
        
        public int peek() {
            if (s2.isEmpty())
                while (!s1.isEmpty())
                    s2.push(s1.pop());
            return s2.peek();
        }
        
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
    
    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    //leetcode submit region end(Prohibit modification and deletion)

    

}