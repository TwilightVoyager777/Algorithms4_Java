package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.WeightedRandomPicker;

import java.util.*;

public class RandomPickWithWeight {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] preSum;
        private Random rand = new Random();
        public Solution(int[] w) {
            int n = w.length;
            preSum = new int[n + 1];
            preSum[0] = 0;
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + w[i - 1];
            }
        }
        
        public int pickIndex() {
            int n = preSum.length;
            int target = rand.nextInt(preSum[n - 1]) + 1;
            return left_bound(preSum, target) - 1;
        }

        // 搜索左侧边界的二分搜索
        int left_bound(int[] nums, int target) {
            if (nums.length == 0) return -1;
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;
                }
            }
            return left;
        }
    }
    
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(w);
     * int param_1 = obj.pickIndex();
     */
    //leetcode submit region end(Prohibit modification and deletion)
}