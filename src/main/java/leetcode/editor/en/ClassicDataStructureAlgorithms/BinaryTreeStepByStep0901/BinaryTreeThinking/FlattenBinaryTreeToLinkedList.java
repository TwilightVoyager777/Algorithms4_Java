package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeStepByStep0901.BinaryTreeThinking;

import leetcode.editor.common.*;

public class FlattenBinaryTreeToLinkedList {

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
        public void flatten(TreeNode root) {
            if (root == null) return;
            flatten(root.left);
            flatten(root.right);
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = null;
            root.right = left;
            TreeNode p = root;
            while (p.right != null) {
                p = p.right;
            }
            p.right = right;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
        // put your test code here
        
    }
}