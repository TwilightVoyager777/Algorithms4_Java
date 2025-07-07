package leetcode.editor.en.Basic;

import java.util.*;

public class TimeNeededToBuyTickets {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int timeRequiredToBuy(int[] tickets, int k) {
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < tickets.length; i++) {
                q.offer(i);
            }

            int time = 0;
            while (!q.isEmpty()) {
                int front = q.poll();
                time++;
                tickets[front]--;

                if (front == k && tickets[front] == 0) {
                    return time;
                }
                if (tickets[front] == 0) {
                    continue;
                }
                q.offer(front);
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new TimeNeededToBuyTickets().new Solution();
        // put your test code here
        
    }
}