package leetcode.editor.en.CoreProblemSolvingFrameworks.TwoPointersLinkedList0704;

import java.util.*;
import leetcode.editor.common.*;

public class MergeKSortedLists {

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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) return null;
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            PriorityQueue<ListNode> pq = new PriorityQueue<>(
                    lists.length, (a, b)->(a.val - b.val));
            for (ListNode head : lists) {
                if(head != null) {
                    pq.add(head);
                }
            }
            while (!pq.isEmpty()) {
                ListNode node = pq.poll();
                p.next = node;
                if (node.next != null) {
                    pq.add(node.next);
                }
                p = p.next;
            }
            return dummy.next;
        }
        //RE
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        // put your test code here
        
    }
}