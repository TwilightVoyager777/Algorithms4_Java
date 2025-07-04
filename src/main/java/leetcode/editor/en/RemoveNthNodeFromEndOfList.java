package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveNthNodeFromEndOfList {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode x = findFromEnd(dummy, n + 1);
            x.next = x.next.next;
            return dummy.next;
        }
        private ListNode findFromEnd(ListNode head, int k) {
            ListNode p1 = head;
            for (int i = 0; i < k; i++) {
                p1 = p1.next;
            }
            ListNode p2 = head;
            while (p1 != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p2;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        // put your test code here
        
    }
}