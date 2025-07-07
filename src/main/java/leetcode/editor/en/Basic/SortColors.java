package leetcode.editor.en.Basic;

public class SortColors {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int[] count = new int[3];
            for (int i = 0; i < nums.length; i++) {
                count[nums[i]]++;
            }
            int index = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < count[i]; j++) {
                    nums[index] = i;
                    index++;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        // put your test code here
        
    }
}