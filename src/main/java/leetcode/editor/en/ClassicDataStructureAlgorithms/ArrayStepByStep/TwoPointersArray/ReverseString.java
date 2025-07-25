package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep.TwoPointersArray;

public class ReverseString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            int left = 0, right = s.length - 1;
            while (left < right) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++;
                right--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseString().new Solution();
        // put your test code here
        
    }
}