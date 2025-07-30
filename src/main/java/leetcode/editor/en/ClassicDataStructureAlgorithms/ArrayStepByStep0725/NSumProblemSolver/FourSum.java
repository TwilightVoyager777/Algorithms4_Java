package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.NSumProblemSolver;

import java.util.*;

public class FourSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            return nSumTarget(nums, 4, 0, target);
        }
        List<List<Integer>> nSumTarget(int[] nums, int n, int start, long target) {
            int sz = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if (n < 2 || sz < n) return res;
            if (n == 2) {
                int lo = start, hi = sz - 1;
                while (lo < hi) {
                    int sum = nums[lo] + nums[hi];
                    int left = nums[lo], right = nums[hi];
                    if (sum < target) {
                        while (lo < hi && nums[lo] == left) lo++;
                    } else if (sum > target) {
                        while (lo < hi && nums[hi] == right) hi--;
                    } else {
                        res.add(new ArrayList<>(Arrays.asList(left, right)));
                        while (lo < hi && nums[lo] == left) lo++;
                        while (lo < hi && nums[hi] == right) hi--;
                    }
                }
            }else {
                for (int i = start; i < sz; i++) {
                    List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                    for (List<Integer> arr : sub) {
                        arr.add(nums[i]);
                        res.add(arr);
                    }
                    while (i < sz - 1 && nums[i] == nums[i + 1]) i++;
                }
            }
            return res;
        }

    }

    class Solution1 {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            int n = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<List<Integer>> triples = threeSumTarget(nums, i + 1, (long)target - nums[i]); // 修正：n+1 -> i+1
                for (List<Integer> triple : triples) {
                    List<Integer> quad = new ArrayList<>(triple); // 创建新 list
                    quad.add(0, nums[i]); // 在头部插入 nums[i]
                    res.add(quad);
                }
                while (i < n - 1 && nums[i] == nums[i + 1]) i++;
            }
            return res;
        }
        List<List<Integer>> threeSumTarget(int[] nums, int start, long target) {
            int n = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            for (int i = start; i < n; i++) {
                // 跳过重复的第一个数
                if (i > start && nums[i] == nums[i - 1]) continue;

                int left = i + 1;
                int right = n - 1;

                while (left < right) {
                    // 使用 long 防止溢出
                    long sum = (long) nums[left] + nums[right];

                    if (sum < target - nums[i]) {
                        left++;
                    } else if (sum > target - nums[i]) {
                        right--;
                    } else {
                        // 找到一组解
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        // 跳过重复值
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    }
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        // put your test code here
        
    }
}