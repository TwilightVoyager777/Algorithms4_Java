package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.QueueExercises;

import java.util.*;

public class NumberOfRecentCalls {

    //leetcode submit region begin(Prohibit modification and deletion)
    class RecentCounter {
    
        public RecentCounter() {
            
        }

        Queue<Integer> q = new LinkedList<>();

        public int ping(int t) {
            q.offer(t);
            while (q.peek() < t - 3000) {
                q.poll();
            }
            return q.size();
        }
    }
    
    /**
     * Your RecentCounter object will be instantiated and called as such:
     * RecentCounter obj = new RecentCounter();
     * int param_1 = obj.ping(t);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}