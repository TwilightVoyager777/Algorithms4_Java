package leetcode.editor.en.ClassicDataStructureAlgorithms.LinkedListStepByStep0724.LinkedListTwoPointerExercises;

import leetcode.editor.common.*;

public class AddTwoNumbers {

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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode p1 = l1, p2 = l2, p = dummy;
            int carry = 0;
            while (p1 != null || p2 != null || carry > 0) {
                int val = carry;
                if (p1 != null) {
                    val = val + p1.val;
                    p1 = p1.next;
                }
                if (p2 != null) {
                    val = val + p2.val;
                    p2 = p2.next;
                }
                carry = val / 10;
                val = val % 10;
                p.next = new ListNode(val);
                p = p.next;
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        // put your test code here
        
    }
}