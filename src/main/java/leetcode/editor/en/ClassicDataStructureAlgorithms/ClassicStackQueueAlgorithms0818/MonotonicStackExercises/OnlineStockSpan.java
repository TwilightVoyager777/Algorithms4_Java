package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.MonotonicStackExercises;

import java.util.*;

public class OnlineStockSpan {

    //leetcode submit region begin(Prohibit modification and deletion)
    class StockSpanner {

        Stack<int[]> stk = new Stack<>();
        public StockSpanner() {
            
        }
        
        public int next(int price) {
            int count = 1;
            while (!stk.isEmpty() && stk.peek()[0] <= price) {
                int[] prev = stk.pop();
                count = count + prev[1];
            }
            stk.push(new int[]{price, count});
            return count;
        }
    }
    
    /**
     * Your StockSpanner object will be instantiated and called as such:
     * StockSpanner obj = new StockSpanner();
     * int param_1 = obj.next(price);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}