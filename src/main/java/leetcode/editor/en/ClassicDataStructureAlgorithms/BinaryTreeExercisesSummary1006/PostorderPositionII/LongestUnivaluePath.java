package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.PostorderPositionII;

import leetcode.editor.common.*;

public class LongestUnivaluePath {

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
        int res = 0;
        public int longestUnivaluePath(TreeNode root) {
            //edge
            if (root == null) return 0;
            //initialize
            maxLen(root, root.val);
            return res;
        }

        private int maxLen(TreeNode root, int parentVal) {
            if (root == null) return 0;
            int rootLeft = maxLen(root.left, root.val);
            int rootRight = maxLen(root.right, root.val);
            res = Math.max(res,rootLeft + rootRight);
            if (root.val != parentVal) {
                return 0;
            }
            return 1 + Math.max(rootLeft, rootRight);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new LongestUnivaluePath().new Solution();
        // put your test code here
        
    }
}