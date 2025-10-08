package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.TraversalThinkingII;

import leetcode.editor.common.*;

public class SumOfLeftLeaves {

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
        public int sumOfLeftLeaves(TreeNode root) {
            traverse(root);
            return res;
        }

        int res = 0;
        void traverse(TreeNode root) {
            if (root == null) return;
            if (root.left != null && root.left.left == null && root.left.right == null) {
                res = res + root.left.val;
            }
            traverse(root.left);
            traverse(root.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
        // put your test code here
        
    }
}