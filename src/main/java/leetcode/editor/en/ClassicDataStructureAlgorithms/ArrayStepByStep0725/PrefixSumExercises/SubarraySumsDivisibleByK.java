package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.PrefixSumExercises;

import java.util.*;

public class SubarraySumsDivisibleByK {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraysDivByK(int[] nums, int k) {
            int n = nums.length;
            int[] preSum = new int[n + 1];
            HashMap<Integer, Integer> remainderToCount = new HashMap<>();
            preSum[0] = 0;
            remainderToCount.put(0, 1);
            int res = 0;
            for (int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
                int curRemainder = preSum[i + 1] % k;
                if (curRemainder < 0) {
                    curRemainder = curRemainder + k;
                }
                if (remainderToCount.containsKey(curRemainder)) {
                    int count = remainderToCount.get(curRemainder);
                    res += count;
                    remainderToCount.put(curRemainder, count + 1);
                } else {
                    remainderToCount.put(curRemainder, 1);
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SubarraySumsDivisibleByK().new Solution();
        // put your test code here
        
    }
}