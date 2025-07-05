package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class TwoSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[] {i,j};
                    }
                }
            }
            //twosum
            return new int[0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        // put your test code here
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));
    }
}