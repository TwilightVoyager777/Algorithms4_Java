package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.PostorderPositionI;

import leetcode.editor.common.*;

public class BinaryTreePruning {

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
        public TreeNode pruneTree(TreeNode root) {
            if (root == null) return null;
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
            if (root.left == null && root.right == null && root.val == 0) {
                return null;
            }
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BinaryTreePruning().new Solution();
        // put your test code here
        
    }
}