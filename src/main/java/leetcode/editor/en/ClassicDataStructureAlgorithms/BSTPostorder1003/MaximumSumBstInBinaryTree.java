package leetcode.editor.en.ClassicDataStructureAlgorithms.BSTPostorder1003;

import leetcode.editor.common.*;

public class MaximumSumBstInBinaryTree {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {

        int maxSum = 0;

        public int maxSumBST(TreeNode root) {
            findMaxMinSum(root);
            return maxSum;
        }

        int[] findMaxMinSum(TreeNode root) {
            if (root == null) {
                return new int[] {
                        1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0
                };
            }

            int[] left = findMaxMinSum(root.left);
            int[] right = findMaxMinSum(root.right);

            int[] res = new int[4];

            if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
                res[0] = 1;
                res[1] = Math.min(left[1], root.val);
                res[2] = Math.max(right[2], root.val);
                res[3] = left[3] + right[3] + root.val;
                maxSum = Math.max(maxSum, res[3]);
            } else {
                res[0] = 0;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MaximumSumBstInBinaryTree().new Solution();
        // put your test code here
        
    }
}