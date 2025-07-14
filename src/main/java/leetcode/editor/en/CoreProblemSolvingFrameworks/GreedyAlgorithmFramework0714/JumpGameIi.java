package leetcode.editor.en.CoreProblemSolvingFrameworks.GreedyAlgorithmFramework0714;

public class JumpGameIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            if (nums.length <= 1) {
                return 0;
            }
            int n = nums.length;
            int end = 0, jumps = 0;
            int farthest = 0;
            for (int i = 0; i < n - 1; i++) {
                farthest = Math.max(farthest, i + nums[i]);
                if (i == end) {
                    jumps++;
                    end = farthest;
                    if (farthest >= n - 1) {
                        return jumps;
                    }
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
        // put your test code here
        
    }
}