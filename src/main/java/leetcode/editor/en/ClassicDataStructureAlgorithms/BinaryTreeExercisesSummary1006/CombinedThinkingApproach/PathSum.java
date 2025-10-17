package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.CombinedThinkingApproach;

import leetcode.editor.common.*;

public class PathSum {

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
    class Solution1 {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            this.target = targetSum;
            traverse(root, targetSum);
            return res;
        }
        boolean res;
        int sum = 0;
        int target;
        void traverse(TreeNode root, int targetSum) {
            if (root == null) return;
            sum = root.val + sum;
            if (root.left == null && root.right == null) {
                if (sum == target) {
                    res = true;
                }
            }
            traverse(root.left,targetSum);
            traverse(root.right,targetSum);
            sum = sum - root.val;
        }
    }
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            if (root.left == root.right && root.val == targetSum) return true;
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();
        // put your test code here
        
    }
}