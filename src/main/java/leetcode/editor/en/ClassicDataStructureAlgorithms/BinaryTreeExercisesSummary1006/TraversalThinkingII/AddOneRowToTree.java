package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.TraversalThinkingII;

import leetcode.editor.common.*;

public class AddOneRowToTree {

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
        private int targetVal;
        private int targetDepth;
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            targetVal = val;
            targetDepth = depth;
            if (depth == 1) {
                TreeNode newRoot = new TreeNode(targetVal);
                newRoot.left = root;
                return newRoot;
            }
            traverse(root);
            return root;
        }

        private int curDepth = 0;
        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            curDepth++;
            if (curDepth == targetDepth - 1) {
                TreeNode newLeft = new TreeNode(targetVal);
                TreeNode newRight = new TreeNode(targetVal);
                newLeft.left = root.left;
                newRight.right = root.right;
                root.left = newLeft;
                root.right = newRight;
            }
            traverse(root.left);
            traverse(root.right);
            curDepth--;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new AddOneRowToTree().new Solution();
        // put your test code here
        
    }
}