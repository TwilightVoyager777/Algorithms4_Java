package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.PrefixSumExercises;

import java.util.*;

public class ContinuousSubarraySum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int n = nums.length;
            int[] preSum = new int[n + 1];
            preSum[0] = 0;
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
            HashMap<Integer, Integer> valToIndex = new HashMap<>();
            for (int i = 0; i < preSum.length; i++) {
                int val = preSum[i] % k;
                if (!valToIndex.containsKey(val)) {
                    valToIndex.put(val, i);
                }
            }
            int res = 0;
            for (int i = 1; i < preSum.length; i++) {
                int need = preSum[i] % k;
                if (valToIndex.containsKey(need)) {
                    if (i - valToIndex.get(need) > 2) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ContinuousSubarraySum().new Solution();
        // put your test code here
        
    }
}