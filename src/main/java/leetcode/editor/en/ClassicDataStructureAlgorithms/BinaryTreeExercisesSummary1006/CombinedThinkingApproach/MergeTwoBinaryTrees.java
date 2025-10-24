package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.CombinedThinkingApproach;

import leetcode.editor.common.*;

public class MergeTwoBinaryTrees {

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
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) return root2;
            if (root2 == null) return root1;
            traverse(root1, root2);

            return root1;
        }

        void traverse(TreeNode root1, TreeNode root2) {
            if ((root1 == null) || (root2 == null)) return;
            if ((root1 != null) && (root2 != null)) {
                root1.val = root1.val + root2.val;
            }
            if (root1.left == null && root2.left != null) {
                root1.left = root2.left;
                root2.left = null;
            }
            if (root1.right == null && root2.right !=null) {
                root1.right = root2.right;
                root2.right = null;
            }
            traverse(root1.left, root2.left);
            traverse(root1.right, root2.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees().new Solution();
        // put your test code here
        
    }
}