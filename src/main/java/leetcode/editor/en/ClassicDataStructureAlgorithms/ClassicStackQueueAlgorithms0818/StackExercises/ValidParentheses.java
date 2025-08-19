package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.StackExercises;

import java.util.*;

public class ValidParentheses {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> left = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    left.push(c);
                } else {
                    if (!left.isEmpty() && leftOf(c) == left.peek()) {
                        left.pop();
                    } else {
                        return false;
                    }
                }
            }
            return left.isEmpty();
        }
        char leftOf(char c) {
            if (c == '}') return '{';
            if (c == ')') return '(';
            return '[';
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        // put your test code here
        
    }
}