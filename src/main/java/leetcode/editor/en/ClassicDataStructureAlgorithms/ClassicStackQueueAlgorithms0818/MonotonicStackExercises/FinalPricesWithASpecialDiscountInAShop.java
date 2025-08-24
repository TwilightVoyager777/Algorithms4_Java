package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.MonotonicStackExercises;

import java.util.*;

public class FinalPricesWithASpecialDiscountInAShop {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] finalPrices(int[] prices) {
            int n = prices.length;
            int[] res = new int[n];
            int[] nextElement = nextLessOrEqualElement(prices);
            for (int i = 0; i < prices.length; i++) {
                if (nextElement[i] != -1) {
                    res[i] = prices[i] - nextElement[i];
                } else {
                    res[i] = prices[i];
                }
            }
            return res;
        }

        int[] nextLessOrEqualElement(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            Stack<Integer> stk = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                while (!stk.isEmpty() && stk.peek() > nums[i]) {
                    stk.pop();
                }
                res[i] = stk.isEmpty() ? -1 : stk.peek();
                stk.push(nums[i]);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new FinalPricesWithASpecialDiscountInAShop().new Solution();
        // put your test code here
        
    }
}