package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.StackExercises;

import java.util.*;

public class EvaluateReversePolishNotation {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stk = new Stack<>();
            for (String token : tokens) {
                if ("+-*/".contains(token)) {
                    int a = stk.pop(), b = stk.pop();
                    switch(token) {
                        case "+":
                            stk.push(a + b);
                            break;
                        case "-":
                            stk.push(b - a);
                            break;
                        case "*":
                            stk.push(a * b);
                            break;
                        case "/":
                            stk.push(b / a);
                            break;
                    }
                } else {
                    stk.push(Integer.parseInt(token));
                }
            }
            return stk.pop();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new EvaluateReversePolishNotation().new Solution();
        // put your test code here
        
    }
}