package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.StackExercises;

import java.util.*;
import leetcode.editor.common.*;

public class ReorderList {

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
        public void reorderList(ListNode head) {
            Stack<ListNode> stk = new Stack<>();
            ListNode p = head;
            while (p != null) {
                stk.push(p);
                p = p.next;
            }

            p = head;
            while (p != null) {
                ListNode lastNode = stk.pop();
                ListNode next = p.next;
                if (lastNode == next || lastNode.next == next) {
                    lastNode.next = null;
                    break;
                }
                p.next = lastNode;
                lastNode.next = next;
                p = next;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
        // put your test code here
        
    }
}