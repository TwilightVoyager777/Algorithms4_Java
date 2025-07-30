package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.NSumProblemSolver;

import java.util.*;

public class TwoSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[]{map.get(complement), i};
                }
                map.put(nums[i], i);
            }
            return new int[]{};
        }
    }
    class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            Arrays.sort(nums);
            int left = 0, right = nums.length - 1;
            int k = nums.length;
            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target){
                    right--;
                } else {
                    return new int[]{left, right};
                }
            }
            return new int[]{};
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        // put your test code here
        
    }
}