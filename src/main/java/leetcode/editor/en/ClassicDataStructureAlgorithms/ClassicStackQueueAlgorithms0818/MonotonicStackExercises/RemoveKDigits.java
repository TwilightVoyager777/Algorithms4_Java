package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.MonotonicStackExercises;

import java.util.*;

public class RemoveKDigits {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeKdigits(String num, int k) {
            Stack<Character> stk = new Stack<>();
            for (char c : num.toCharArray()) {
                while (!stk.isEmpty() && stk.peek() > c && k > 0) {
                    stk.pop();
                    k--;
                }
                if (stk.isEmpty() && c == '0') {
                    continue;
                }
                stk.push(c);
            }

            while (k > 0 && !stk.isEmpty()) {
                stk.pop();
                k--;
            }
            if (stk.isEmpty()) {
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            while (!stk.isEmpty()) {
                sb.append(stk.pop());
            }
            return sb.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RemoveKDigits().new Solution();
        // put your test code here
        
    }
}