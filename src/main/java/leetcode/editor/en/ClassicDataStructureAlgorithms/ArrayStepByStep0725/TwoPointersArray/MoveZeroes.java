package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep.TwoPointersArray;

public class MoveZeroes {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            if (nums.length == 0) return;
            int fast = 0, slow = 0;
            while (fast < nums.length) {
                if (nums[fast] != 0) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            for (int i = slow; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        // put your test code here
        
    }
}