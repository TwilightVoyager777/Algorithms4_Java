package leetcode.editor.en.CoreProblemSolvingFrameworks.DynamicProgrammingFramework0708;

import java.util.*;

public class FibonacciNumber {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int n) {
            int[] memo = new int[n + 1];
            Arrays.fill(memo, -1);
            return dp(memo, n);
        }

        int dp(int[] memo, int n) {
            if (n == 0 || n == 1) {
                return n;
            }
            if (memo[n] != -1) {
                return memo[n];
            }
            memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
            return memo[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new FibonacciNumber().new Solution();
        // put your test code here
        
    }
}