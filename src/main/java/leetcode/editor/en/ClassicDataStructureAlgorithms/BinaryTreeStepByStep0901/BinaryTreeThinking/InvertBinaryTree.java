package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeStepByStep0901.BinaryTreeThinking;

import leetcode.editor.common.*;

public class InvertBinaryTree {

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
        public TreeNode invertTree(TreeNode root) {
            traverse(root);
            return root;
        }
        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            traverse(root.left);
            traverse(root.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
        // put your test code here
        
    }
}