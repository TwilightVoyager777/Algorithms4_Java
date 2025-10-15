package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.DecompositionThinkingI;

import leetcode.editor.common.*;

public class MaximumBinaryTreeIi {

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
        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (root.val < val) {
                TreeNode temp = root;
                root = new TreeNode(val);
                root.left = temp;
            } else {
                root.right = insertIntoMaxTree(root.right, val);
            }
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MaximumBinaryTreeIi().new Solution();
        // put your test code here
        
    }
}