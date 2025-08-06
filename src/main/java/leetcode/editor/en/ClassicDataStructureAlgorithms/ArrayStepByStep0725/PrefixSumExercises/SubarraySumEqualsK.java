package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.PrefixSumExercises;

import java.util.*;

public class SubarraySumEqualsK {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int n = nums.length;
            int[] preSum = new int[n + 1];
            preSum[0] = 0;
            HashMap<Integer, Integer> count = new HashMap<>();
            count.put(0, 1);
            int res = 0;
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
                int need = preSum[i] - k;
                if (count.containsKey(need)) {
                    res = res + count.get(need);
                }
                if (!count.containsKey(preSum[i])) {
                    count.put(preSum[i], 1);
                } else {
                    count.put(preSum[i], count.get(preSum[i]) + 1);
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
        // put your test code here
        
    }
}