package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.MonotonicStackTemplate;

import java.util.*;

public class NextGreaterElementI {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] greater = nextGreaterElement(nums2);
            HashMap<Integer, Integer> greaterMap = new HashMap<>();
            for (int i = 0; i < nums2.length; i++) {
                greaterMap.put(nums2[i], greater[i]);
            }
            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                res[i] = greaterMap.get(nums1[i]);
            }
            return res;
        }
        int[] nextGreaterElement(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            Stack<Integer> s = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                while (!s.isEmpty() && s.peek() <= nums[i]) {
                    s.pop();
                }
                res[i] = s.isEmpty() ? -1 : s.peek();
                s.push(nums[i]);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementI().new Solution();
        // put your test code here
        
    }
}