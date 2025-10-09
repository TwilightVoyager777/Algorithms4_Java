package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.TraversalThinkingIII;

import leetcode.editor.common.*;

public class FindBottomLeftTreeValue {

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
        TreeNode res = null;
        int depth, maxDepth;
        public int findBottomLeftValue(TreeNode root) {
            traverse(root);
            return res.val;
        }
        void traverse(TreeNode root) {
            if (root == null) return;
            depth++;
            if (depth > maxDepth) {
                maxDepth = depth;
                res = root;
            }
            traverse(root.left);
            traverse(root.right);
            depth--;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new FindBottomLeftTreeValue().new Solution();
        // put your test code here
        
    }
}