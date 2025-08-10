package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.SlidingWindowExercises;

public class MinimumOperationsToReduceXToZero {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums, int x) {
            int n = nums.length;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum = sum + nums[i];
            }
            int left = 0, right = 0;
            int target = sum - x;
            int windowSum = 0;
            int maxLen = Integer.MIN_VALUE;
            while (right < nums.length) {
                windowSum = windowSum + nums[right];
                right++;
                while (windowSum > target && left < right) {
                    windowSum = windowSum - nums[left];
                    left++;
                }
                if (windowSum == target) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
            return maxLen == Integer.MIN_VALUE ? -1 : n - maxLen;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToReduceXToZero().new Solution();
        // put your test code here
        
    }
}