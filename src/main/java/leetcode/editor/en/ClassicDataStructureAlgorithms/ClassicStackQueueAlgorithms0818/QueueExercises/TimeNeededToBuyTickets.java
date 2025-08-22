package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.QueueExercises;

public class TimeNeededToBuyTickets {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int timeRequiredToBuy(int[] tickets, int k) {
            int res = 0;
            for (int i = 0; i < tickets.length; i++) {
                if (i <= k) {
                    res = res + Math.min(tickets[k], tickets[i]);
                } else {
                    res = res + Math.min(tickets[k] - 1, tickets[i]);
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new TimeNeededToBuyTickets().new Solution();
        // put your test code here
        
    }
}