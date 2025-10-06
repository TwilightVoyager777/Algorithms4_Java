package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.TraversalThinkingI;

import leetcode.editor.common.*;

public class SumRootToLeafNumbers {

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

        StringBuilder path = new StringBuilder();
        int res = 0;

        public int sumNumbers(TreeNode root) {
            traverse(root);
            return res;
        }

        void traverse(TreeNode root) {
            if (root == null) return;
            path.append(root.val);
            //到叶子结点
            if (root.left == null && root.right == null) {
                res = res + Integer.parseInt(path.toString());
            }
            traverse(root.left);
            traverse(root.right);
            path.deleteCharAt(path.length() - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SumRootToLeafNumbers().new Solution();
        // put your test code here
        
    }
}