package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.NSumProblemSolver;

import java.util.*;

public class ThreeSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            List<List<Integer>> res = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;  // 去重

                List<List<Integer>> tuples = twoSumTarget(nums, i + 1, -nums[i]);
                for (List<Integer> tuple : tuples) {
                    // 创建新 list，加入 nums[i]
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.addAll(tuple);
                    res.add(triplet);
                }
            }

            return res;
        }

        // 返回所有和为 target 的 [nums[lo], nums[hi]] 对（去重）
        List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
            int lo = start, hi = nums.length - 1;
            List<List<Integer>> res = new ArrayList<>();

            while (lo < hi) {
                int sum = nums[lo] + nums[hi];

                if (sum < target) {
                    lo++;
                } else if (sum > target) {
                    hi--;
                } else {
                    res.add(Arrays.asList(nums[lo], nums[hi]));
                    // 去重
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    lo++;
                    hi--;
                }
            }

            return res;
        }
    }
    class Solution1 {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<List<Integer>> tuples = twoSumTarget(nums, i + 1, 0 - nums[i]);
                for (List<Integer> tuple : tuples) {
                    tuple.add(nums[i]);
                    res.add(tuple);
                }
                while (i < n - 1 && nums[i] == nums[i + 1]) i++;
            }
            return res;
        }
        List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
            int lo = start, hi = nums.length - 1;
            List<List<Integer>> res = new ArrayList<>();
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                if (sum < target) {
                    lo++;
                } else if (sum > target) {
                    hi--;
                } else {
                    res.add(Arrays.asList(nums[lo], nums[hi]));
                    lo++;
                    hi--;
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        // put your test code here
        
    }
}