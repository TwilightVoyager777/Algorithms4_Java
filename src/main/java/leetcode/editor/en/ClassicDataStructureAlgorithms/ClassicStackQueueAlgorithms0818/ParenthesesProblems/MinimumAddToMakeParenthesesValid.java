package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.ParenthesesProblems;

public class MinimumAddToMakeParenthesesValid {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minAddToMakeValid(String s) {
            int res = 0, need = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    need++;
                }
                if (s.charAt(i) == ')') {
                    need--;
                    if (need < 0) {
                        need = 0;
                        res++;
                    }
                }
            }
            return need + res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MinimumAddToMakeParenthesesValid().new Solution();
        // put your test code here
        
    }
}