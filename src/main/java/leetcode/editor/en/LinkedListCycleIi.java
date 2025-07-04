package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class LinkedListCycleIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while(fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) break;
            }
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = head;
            while (slow != fast) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
        // put your test code here
        
    }
}