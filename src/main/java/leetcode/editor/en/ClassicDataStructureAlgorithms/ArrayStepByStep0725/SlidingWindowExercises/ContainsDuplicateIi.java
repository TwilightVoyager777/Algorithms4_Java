package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class ContainsDuplicateIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int left = 0, right = 0;
            HashSet<Integer> window = new HashSet<>();
            while (right < nums.length) {
                if (window.contains(nums[right])) {
                    return true;
                }
                window.add(nums[right]);
                right++;

                if (right - left > k) {
                    window.remove(nums[left]);
                    left++;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();
        // put your test code here
        
    }
}