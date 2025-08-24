package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.MonotonicStackExercises;

import java.util.*;
import leetcode.editor.common.*;

public class NextGreaterNodeInLinkedList {

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
        public int[] nextLargerNodes(ListNode head) {
            ArrayList<Integer> nums = new ArrayList<>();
            for (ListNode p = head; p != null; p = p.next) {
                nums.add(p.val);
            }
            int[] res = new int[nums.size()];
            Stack<Integer> stk = new Stack<>();
            for (int i = nums.size() - 1; i >= 0; i--) {
                while (!stk.isEmpty() && stk.peek() <= nums.get(i)) {
                    stk.pop();
                }
                res[i] = stk.isEmpty() ? 0 : stk.peek();
                stk.push(nums.get(i));
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new NextGreaterNodeInLinkedList().new Solution();
        // put your test code here
        
    }
}