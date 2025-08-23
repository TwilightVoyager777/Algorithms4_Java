package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.MonotonicStackTemplate;

import java.util.*;

public class NextGreaterElementIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            Stack<Integer> s = new Stack<>();
            for (int i = 2 * n - 1; i >= 0; i--) {
                while (!s.isEmpty() && s.peek() <= nums[i % n]) {
                    s.pop();
                }
                res[i % n] = s.isEmpty() ? -1 : s.peek();
                s.push(nums[i % n]);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIi().new Solution();
        // put your test code here
        
    }
}