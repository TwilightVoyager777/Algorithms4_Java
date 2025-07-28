package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.ArrayTwoPointerExercises;

public class SquaresOfASortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int n = nums.length;
            int i = 0, j = n - 1, p = n - 1;
            int[] res = new int[n];
            while (i <= j) {
                if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                    res[p] = nums[i] * nums[i];
                    i++;
                } else {
                    res[p] = nums[j] * nums[j];
                    j--;
                }
                p--;
            }
            return res;
        }
    }
    class Solution1 {
        public int[] sortedSquares(int[] nums) {
            if (nums.length == 0) return new int[0];

            int[] nums1 = new int[nums.length];  // 存放非负数平方
            int[] nums2 = new int[nums.length];  // 存放负数平方
            int i = 0, j = 0;

            // 第一步：将平方分别放入 nums1 和 nums2
            for (int p = 0; p < nums.length; p++) {
                int square = nums[p] * nums[p];
                if (nums[p] >= 0) {
                    nums1[i++] = square;
                } else {
                    nums2[j++] = square;
                }
            }

            // 第二步：反转 nums2（因为负数平方是递减的）
            reverse(nums2, j);

            // 第三步：合并两个有序数组到 res
            int[] res = new int[nums.length];
            int idx = 0, p1 = 0, p2 = 0;

            while (p1 < i && p2 < j) {
                if (nums1[p1] < nums2[p2]) {
                    res[idx++] = nums1[p1++];
                } else {
                    res[idx++] = nums2[p2++];
                }
            }

            // 处理剩余元素
            while (p1 < i) {
                res[idx++] = nums1[p1++];
            }
            while (p2 < j) {
                res[idx++] = nums2[p2++];
            }

            return res;
        }

        // 辅助函数：反转 nums2 的前 j 个元素
        private void reverse(int[] nums, int j) {
            for (int left = 0, right = j - 1; left < right; left++, right--) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
        // put your test code here
        
    }
}