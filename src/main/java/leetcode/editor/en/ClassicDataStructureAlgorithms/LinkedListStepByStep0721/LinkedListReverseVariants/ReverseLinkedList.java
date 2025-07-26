package leetcode.editor.en.ClassicDataStructureAlgorithms.LinkedListStepByStep0721.LinkedListReverseVariants;

import leetcode.editor.common.*;

public class ReverseLinkedList {

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
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode last = reverseList(head.next);
            head.next.next= head;
            head.next = null;
            return last;
        }
    }
    class Solution1 {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre, cur, nxt;
            pre = null; cur = head; nxt = head.next;
            while (cur != null) {
                cur.next = pre;
                pre = cur;
                cur = nxt;
                if (nxt != null) {
                    nxt = nxt.next;
                }
            }
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        // put your test code here
        
    }
}