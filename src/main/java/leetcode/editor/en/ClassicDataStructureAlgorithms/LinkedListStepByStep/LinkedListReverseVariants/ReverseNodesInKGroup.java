package leetcode.editor.en.ClassicDataStructureAlgorithms.LinkedListStepByStep.LinkedListReverseVariants;

import leetcode.editor.common.*;

public class ReverseNodesInKGroup {

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
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) return null;
            ListNode a,b;
            a = b = head;
            for (int i = 0; i < k; i++) {
                if (b == null) return head;
                b = b.next;
            }
            ListNode newHead = reverseN(a, k);
            a.next = reverseKGroup(b, k);
            return newHead;
        }
        ListNode reverseN(ListNode head, int n) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre, cur, nxt;
            pre = null; cur = head; nxt = head.next;
            while (n > 0) {
                cur.next = pre;
                pre = cur;
                cur = nxt;
                if (nxt != null) {
                    nxt = nxt.next;
                }
                n--;
            }
            head.next = cur;
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        // put your test code here
        
    }
}