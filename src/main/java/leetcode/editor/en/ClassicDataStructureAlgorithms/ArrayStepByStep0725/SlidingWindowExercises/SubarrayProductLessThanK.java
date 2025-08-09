package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class SubarrayProductLessThanK {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int left = 0, right = 0;
            int count = 0;
            int windowSum = 1;
            while (right < nums.length) {
                windowSum = windowSum * nums[right];
                right++;
                while (windowSum >= k && left < right) {
                    windowSum = windowSum / nums[left];
                    left++;
                }
                count += right - left;
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SubarrayProductLessThanK().new Solution();
        // put your test code here
        
    }
}