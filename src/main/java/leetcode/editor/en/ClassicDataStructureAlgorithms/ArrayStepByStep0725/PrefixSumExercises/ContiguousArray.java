package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.PrefixSumExercises;

import java.util.*;

public class ContiguousArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength(int[] nums) {
            int n = nums.length;
            int[] preSum = new int[n + 1];
            preSum[0] = 0;
            for (int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + (nums[i] == 0 ? -1 : 1);
            }
            HashMap<Integer, Integer> valToIndex = new HashMap<>();
            int res = 0;
            for (int i = 0; i < preSum.length; i++) {
                if (!valToIndex.containsKey(preSum[i])) {
                    valToIndex.put(preSum[i], i);
                } else {
                    res = Math.max(res, i - valToIndex.get(preSum[i]));
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ContiguousArray().new Solution();
        // put your test code here
        
    }
}