package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class MaxConsecutiveOnesIii {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int left = 0, right = 0;
            int count = 0;
            int max = 0;
            while (right < nums.length) {
                if (nums[right] == 1) {
                    count++;
                }
                right++;

                while (right - left - count > k) {
                    if (nums[left] == 1) {
                        count--;
                    }
                    left++;
                }
                max = Math.max(max, right - left);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnesIii().new Solution();
        // put your test code here
        
    }
}