package leetcode.editor.en.CoreProblemSolvingFrameworks.GreedyAlgorithmFramework0714;

public class JumpGame {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int farthest = 0;
            for (int i = 0; i < n - 1; i++) {
                farthest = Math.max(farthest, i + nums[i]);
                if (farthest < i) {
                    return false;
                }
            }
            return farthest >= n - 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        // put your test code here
        
    }
}