package leetcode.editor.en.CoreProblemSolvingFrameworks.BinaryTreeEssentials0707;

import leetcode.editor.common.*;

public class MaximumDepthOfBinaryTree {

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
        int depth = 0;
        int res = 0;
        public int maxDepth(TreeNode root) {
                traverse(root);
                return res;
        }
        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            depth++;
            if (root.left == null && root.right == null) {
                res = Math.max(res, depth);
            }
            traverse(root.left);
            traverse(root.right);
            depth--;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        // put your test code here
        
    }
}