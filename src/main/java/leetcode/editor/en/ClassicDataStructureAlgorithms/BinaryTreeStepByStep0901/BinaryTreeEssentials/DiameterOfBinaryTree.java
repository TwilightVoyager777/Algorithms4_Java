package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeStepByStep0901.BinaryTreeEssentials;

import leetcode.editor.common.*;

public class DiameterOfBinaryTree {

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

        int maxDiameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            traverse(root);
            return maxDiameter;
        }

        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);
            int myDiameter = leftMax + rightMax;
            maxDiameter = Math.max(maxDiameter, myDiameter);
            traverse(root.left);
            traverse(root.right);
        }

        int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);
            return 1 + Math.max(leftMax, rightMax);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
        // put your test code here
        
    }
}