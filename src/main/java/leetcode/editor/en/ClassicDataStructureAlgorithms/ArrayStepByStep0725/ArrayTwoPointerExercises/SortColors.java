package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.ArrayTwoPointerExercises;

public class SortColors {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int left = 0, right = nums.length - 1;
            int i = 0;

            while (i <= right) {
                if (nums[i] == 0) {
                    swap(nums, i, left);
                    left++;
                    i++;
                } else if (nums[i] == 2) {
                    swap(nums, i, right);
                    right--;
                } else {
                    i++;
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        // put your test code here
        
    }
}