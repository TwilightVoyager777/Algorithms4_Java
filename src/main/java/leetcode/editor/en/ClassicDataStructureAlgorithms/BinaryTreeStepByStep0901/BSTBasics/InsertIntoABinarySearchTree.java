package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeStepByStep0901.BSTBasics;

import leetcode.editor.common.*;

public class InsertIntoABinarySearchTree {

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
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);
            if (root.val < val) {
                root.right = insertIntoBST(root.right, val);
            }
            if (root.val > val) {
                root.left = insertIntoBST(root.left, val);
            }
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new InsertIntoABinarySearchTree().new Solution();
        // put your test code here
        
    }
}