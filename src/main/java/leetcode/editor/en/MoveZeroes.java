package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class MoveZeroes {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int fast = 0, slow = 0;
            while (fast < nums.length) {
                if (nums[fast] != 0) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            int size = fast - slow;
            for (int i = 0; i < size; i++) {
                nums[i + slow] = 0;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        // put your test code here
        
    }
}