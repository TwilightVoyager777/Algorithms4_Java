package leetcode.editor.en.ClassicDataStructureAlgorithms.LinkedListStepByStep.PalindromeLinkedListCheck;

import leetcode.editor.common.*;

public class PalindromeLinkedList {

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

        public boolean isPalindrome(ListNode head) {
            ListNode slow, fast;
            slow = fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            if (fast != null) slow = slow.next;
            ListNode left = head;
            ListNode right = reverse(slow);
            while (right != null) {
                if (left.val != right.val) {
                    return false;
                }
                left = left.next;
                right = right.next;
            }
            return true;
        }
        ListNode reverse(ListNode head) {
            ListNode pre = null, cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

    }
    class Solution1 {
        ListNode left, right;
        boolean res = true;
        public boolean isPalindrome(ListNode head) {
            left = head;
            traverse(head);
            return res;
        }
        void traverse(ListNode right) {
            if (right == null) return;
            traverse(right.next);
            if (left.val != right.val) {
                res = false;
            }
            left = left.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        // put your test code here
        
    }
}