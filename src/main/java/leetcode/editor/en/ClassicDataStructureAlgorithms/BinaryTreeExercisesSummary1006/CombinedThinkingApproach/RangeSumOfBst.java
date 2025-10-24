package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.CombinedThinkingApproach;

import leetcode.editor.common.*;

public class RangeSumOfBst {

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
        public int res = 0;
        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null || low > high) return 0;
            traverse(root, low, high);
            return res;
        }
        void traverse(TreeNode root, int low, int high) {
            if (root == null || low > high) return;
            if (root.val < low) {
                traverse(root.right, low, high);
            } else if (root.val > high) {
                traverse(root.left, low, high);
            } else {
                res = res + root.val;
                traverse(root.right, low, high);
                traverse(root.left, low, high);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RangeSumOfBst().new Solution();
        // put your test code here
        
    }
}