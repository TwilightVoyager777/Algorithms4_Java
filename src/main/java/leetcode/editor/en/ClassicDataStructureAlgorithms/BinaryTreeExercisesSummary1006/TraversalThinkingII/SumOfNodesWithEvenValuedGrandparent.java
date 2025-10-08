package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.TraversalThinkingII;

import leetcode.editor.common.*;

public class SumOfNodesWithEvenValuedGrandparent {

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
        public int sumEvenGrandparent(TreeNode root) {
            traverse(root);
            return sum;
        }
        int sum = 0;
        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.val % 2 == 0) {
                if (root.left != null) {
                    if (root.left.left != null) {
                        sum = sum + root.left.left.val;
                    }
                    if (root.left.right != null) {
                        sum = sum + root.left.right.val;
                    }
                }
                if (root.right != null) {
                    if (root.right.left != null) {
                        sum = sum + root.right.left.val;
                    }
                    if (root.right.right != null) {
                        sum = sum + root.right.right.val;
                    }
                }
            }
            traverse(root.left);
            traverse(root.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SumOfNodesWithEvenValuedGrandparent().new Solution();
        // put your test code here
        
    }
}