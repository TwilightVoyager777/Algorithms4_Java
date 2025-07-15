package leetcode.editor.en.CoreProblemSolvingFrameworks.DivideAndConquerFramework0715;

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
    // 用分治算法合并 k 个有序链表
    class Solution {

        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            return mergeKLists3(lists, 0, lists.length - 1);
        }


        // 定义：合并 lists[start..end] 为一个有序链表
        ListNode mergeKLists3(ListNode[] lists, int start, int end) {
            if (start == end) {
                return lists[start];
            }

            int mid = start + (end - start) / 2;
            // 合并左半边 lists[start..mid] 为一个有序链表
            ListNode left = mergeKLists3(lists, start, mid);

            // 合并右半边 lists[mid+1..end] 为一个有序链表
            ListNode right = mergeKLists3(lists, mid + 1, end);

            // 合并左右两个有序链表
            return mergeTwoLists(left, right);
        }


        // 双指针技巧合并两个有序链表
        // https://labuladong.online/algo/essential-technique/linked-list-skills-summary/
        ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1), p = dummy;
            ListNode p1 = l1, p2 = l2;

            while (p1 != null && p2 != null) {
                if (p1.val > p2.val) {
                    p.next = p2;
                    p2 = p2.next;
                } else {
                    p.next = p1;
                    p1 = p1.next;
                }
                p = p.next;
            }

            if (p1 != null) {
                p.next = p1;
            }

            if (p2 != null) {
                p.next = p2;
            }

            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        // put your test code here
        
    }
}