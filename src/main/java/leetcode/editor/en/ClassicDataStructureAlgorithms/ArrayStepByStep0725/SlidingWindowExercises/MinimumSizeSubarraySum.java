package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class MinimumSizeSubarraySum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int left = 0, right = 0;
            int windowSum = 0;
            int len = Integer.MAX_VALUE;
            while (right < nums.length) {
                windowSum = windowSum + nums[right];
                right++;

                while (windowSum >= target && left < right) {
                    len = Math.min(len, right - left);
                    windowSum = windowSum - nums[left];
                    left++;
                }
            }
            return len == Integer.MAX_VALUE ? 0 : len;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        // put your test code here
        
    }
}