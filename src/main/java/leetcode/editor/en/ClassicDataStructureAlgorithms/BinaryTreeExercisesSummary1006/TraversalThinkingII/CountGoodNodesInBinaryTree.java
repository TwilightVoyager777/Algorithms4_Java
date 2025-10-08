package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.TraversalThinkingII;

import leetcode.editor.common.*;

public class CountGoodNodesInBinaryTree {

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
        public int goodNodes(TreeNode root) {
            traverse(root, root.val);
            return count;
        }
        int count = 0;
        void traverse(TreeNode root,int pathMax) {
            if (root == null) return;
            if (pathMax <= root.val) count++;
            pathMax = Math.max(pathMax, root.val);
            traverse(root.left, pathMax);
            traverse(root.right, pathMax);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new CountGoodNodesInBinaryTree().new Solution();
        // put your test code here
        
    }
}