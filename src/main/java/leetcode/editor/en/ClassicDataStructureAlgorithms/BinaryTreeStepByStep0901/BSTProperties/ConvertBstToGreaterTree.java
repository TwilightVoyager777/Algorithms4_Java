package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeStepByStep0901.BSTProperties;

import leetcode.editor.common.*;

public class ConvertBstToGreaterTree {

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
        public TreeNode convertBST(TreeNode root) {
            traverse(root);
            return root;
        }

        int sum = 0;
        void traverse(TreeNode root) {
            if (root == null) return;
            traverse(root.right);
            sum = sum + root.val;
            root.val = sum;
            traverse(root.left);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ConvertBstToGreaterTree().new Solution();
        // put your test code here
        
    }
}