package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.ParenthesesProblems;

public class MinimumInsertionsToBalanceAParenthesesString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minInsertions(String s) {
            int res = 0, need = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    need = need + 2;
                    if (need % 2 == 1) {
                        res++;
                        need--;
                    }
                }
                if (s.charAt(i) == ')') {
                    need--;
                    if (need == -1) {
                        res++;
                        need = 1;
                    }
                }
            }
            return need + res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MinimumInsertionsToBalanceAParenthesesString().new Solution();
        // put your test code here
        
    }
}