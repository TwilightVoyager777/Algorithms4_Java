package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.MonotonicStackExercises;

import java.util.*;

public class ShortestUnsortedContinuousSubarray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int[] temp = Arrays.copyOf(nums, nums.length);
            Arrays.sort(temp);
            int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (temp[i] != nums[i]) {
                    left = i;
                    break;
                }
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                if (temp[i] != nums[i]) {
                    right = i;
                    break;
                }
            }
            if (left == Integer.MAX_VALUE && right == Integer.MIN_VALUE) {
                return 0;
            }
            return right - left + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
        // put your test code here
        
    }
}