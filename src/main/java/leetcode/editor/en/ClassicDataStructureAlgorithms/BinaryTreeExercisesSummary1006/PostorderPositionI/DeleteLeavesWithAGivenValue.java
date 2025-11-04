package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.PostorderPositionI;

import leetcode.editor.common.*;

public class DeleteLeavesWithAGivenValue {

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
        public TreeNode removeLeafNodes(TreeNode root, int target) {
            if (root == null) return null;
            root.left = removeLeafNodes(root.left, target);
            root.right = removeLeafNodes(root.right, target);
            if (root.val == target && root.left == null && root.right == null) {
                return null;
            }
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new DeleteLeavesWithAGivenValue().new Solution();
        // put your test code here
        
    }
}