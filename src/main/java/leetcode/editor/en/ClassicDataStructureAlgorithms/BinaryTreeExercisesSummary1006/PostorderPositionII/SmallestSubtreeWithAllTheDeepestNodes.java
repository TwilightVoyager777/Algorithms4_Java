package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.PostorderPositionII;

import leetcode.editor.common.*;

public class SmallestSubtreeWithAllTheDeepestNodes {

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

        class Result {
            public TreeNode node;
            public int depth;

            public Result(TreeNode node, int depth) {
                this.node = node;
                this.depth = depth;
            }
        }

        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            if (root == null) return null;
            Result res = maxDepth(root);
            return res.node;
        }

        Result maxDepth(TreeNode root) {
            if (root == null) {
                return new Result(null, 0);
            }
            Result left = maxDepth(root.left);
            Result right = maxDepth(root.right);
            if (left.depth == right.depth) {
                return new Result(root, left.depth + 1);
            }
            Result res = left.depth > right.depth ? left : right;
            res.depth++;
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SmallestSubtreeWithAllTheDeepestNodes().new Solution();
        // put your test code here
        
    }
}