package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.PostorderPositionI;

import leetcode.editor.common.*;

public class BalancedBinaryTree {

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
        public boolean isBalanced(TreeNode root) {
            maxDepth(root);
            return isBalanced;
        }
        boolean isBalanced = true;
        int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftMaxDepth = maxDepth(root.left);
            int rightMaxDepth = maxDepth(root.right);
            if (Math.abs(rightMaxDepth - leftMaxDepth) > 1) {
                isBalanced = false;
            }
            return 1 + Math.max(leftMaxDepth, rightMaxDepth);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
        // put your test code here
        
    }
}