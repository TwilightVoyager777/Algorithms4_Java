package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.ArrayTwoPointerExercises;

public class RemoveDuplicatesFromSortedArrayIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) return 0;
            int slow = 0, fast = 0, count = 0;
            while (fast < nums.length) {
                if (nums[fast] != nums[slow]) {
                    slow++;
                    nums[slow] = nums[fast];
                } else if (slow < fast && count < 2) {
                    slow++;
                    nums[slow] = nums[fast];
                }
                fast++;
                count++;
                if (fast < nums.length && nums[fast] != nums[fast - 1]) {
                    count = 0;
                }
            }
            return slow + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArrayIi().new Solution();
        // put your test code here
        
    }
}