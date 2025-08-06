package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.PrefixSumExercises;

import java.util.*;

public class LongestWellPerformingInterval {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestWPI(int[] hours) {
            int n = hours.length;
            int[] preSum = new int[n + 1];
            preSum[0] = 0;
            HashMap<Integer, Integer> day = new HashMap<>();
            int res = 0;
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + (hours[i - 1] - 8 > 0 ? 1 : -1);
                if (!day.containsKey(preSum[i])) {
                    day.put(preSum[i], i);
                } else {

                }
                if (preSum[i] > 0) {
                    res = Math.max(res, i);
                } else {
                    if (day.containsKey(preSum[i] - 1)) {
                        int j = day.get(preSum[i] - 1);
                        res = Math.max(res, i - j);
                    }
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new LongestWellPerformingInterval().new Solution();
        // put your test code here
        
    }
}