package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.TraversalThinkingI;

import leetcode.editor.common.*;

public class SumOfRootToLeafBinaryNumbers {

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
        public int sumRootToLeaf(TreeNode root) {
            traverse(root);
            return res;
        }
        int path = 0;
        int res = 0;
        void traverse(TreeNode root) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                res = res + ((path << 1) | root.val);
                return;
            }
            path = path << 1 | root.val;
            traverse(root.left);
            traverse(root.right);
            path = path >> 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SumOfRootToLeafBinaryNumbers().new Solution();
        // put your test code here
        
    }
}