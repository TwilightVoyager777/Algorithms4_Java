package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.StackExercises;

import java.util.*;

public class ImplementStackUsingQueues {

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyStack {
        Queue<Integer> q = new LinkedList<>();
        int top_elem = 0;

        public MyStack() {
            
        }
        
        public void push(int x) {
            q.offer(x);
            top_elem = x;
        }
        
        public int pop() {
            int size = q.size();
            while (size > 2) {
                q.offer(q.poll());
                size--;
            }
            top_elem = q.peek();
            q.offer(q.poll());
            return q.poll();
        }
        
        public int top() {
            return top_elem;
        }
        
        public boolean empty() {
            return q.isEmpty();
        }
    }
    
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    //leetcode submit region end(Prohibit modification and deletion)

    

}