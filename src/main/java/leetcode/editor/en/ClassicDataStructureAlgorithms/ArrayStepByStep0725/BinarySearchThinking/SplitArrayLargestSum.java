package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.BinarySearchThinking;

public class SplitArrayLargestSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int splitArray(int[] nums, int k) {
            int left = 0;
            int right = 0;
            for (int n : nums) {
                left = Math.max(left, n);
                right = n + right;
            }
            right++;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (f(nums, mid) < k) {
                    right = mid;
                } else if (f(nums, mid) == k) {
                    right = mid;
                } else if (f(nums, mid) > k){
                    left = mid + 1;
                }
            }
            return left;
        }

        int f(int[] nums, int x) {
            int sum = 0;
            int groups = 1;
            for (int i = 0; i < nums.length; i++) {
                if (sum + nums[i] <= x) {
                    sum = sum + nums[i];
                } else {
                    groups++;
                    sum = nums[i];
                }
            }
            return groups;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SplitArrayLargestSum().new Solution();
        // put your test code here
        
    }
}