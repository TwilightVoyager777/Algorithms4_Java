package leetcode.editor.en.ClassicDataStructureAlgorithms.LinkedListStepByStep.LinkedListTwoPointerExercises;

import leetcode.editor.common.*;

public class RemoveDuplicatesFromSortedListIi {

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
    class Solution1 {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy1 = new ListNode(101);
            ListNode dummy2 = new ListNode(101);
            ListNode p1 = dummy1, p2 = dummy2, p = head;
            while (p != null) {
                if ((p.next != null && p.val == p.next.val) || p.val == p2.val) {
                    p2.next = p;
                    p2 = p2.next;
                } else {
                    p1.next = p;
                    p1 = p1.next;
                }
                p = p.next;
                p1.next = null;
                p2.next = null;
            }
            return dummy1.next;
        }
    }
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(101);
            ListNode q = dummy, p = head;
            while (p != null) {
                if (p.next != null && p.val != p.next.val) {
                    while (p.next != null && p.val != p.next.val) {
                        p = p.next;
                    }
                    p = p.next;
                    if (p == null) {
                        q.next = null;
                    }
                } else {
                    q.next = p;
                    q = q.next;
                    p = p.next;
            }
            }
            return dummy.next;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


    
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
        // put your test code here
        
    }
}