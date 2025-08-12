package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.BinarySearchTemplate;

public class FindFirstAndLastPositionOfElementInSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
//            return new int[]{left_bound(nums, target), right_bound(nums,target)};
            int left = left_bound(nums, target);
            int right = right_bound(nums, target);

            if (left == nums.length || nums[left] != target) {
                return new int[]{-1, -1};
            }
            return new int[]{left, right};
        }
        int left_bound(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;
                }
            }
            return left;
        }

        int right_bound(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    left = mid + 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;
                }
            }
            return left - 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // put your test code here
        
    }
}