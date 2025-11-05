package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.PostorderPositionII;

import leetcode.editor.common.*;

public class MaximumDifferenceBetweenNodeAndAncestor {

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

        public int maxAncestorDiff(TreeNode root) {
            if (root == null) return 0;
            getMinMax(root);
            return res;
        }

        private int[] getMinMax(TreeNode root) {
            if (root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
            int[] leftMinMax = getMinMax(root.left);
            int[] rightMinMax = getMinMax(root.right);
            int rootMin = min(root.val, leftMinMax[0], rightMinMax[0]);
            int rootMax = max(root.val, leftMinMax[1], rightMinMax[1]);
            res = max(res, rootMax - root.val, root.val - rootMin);
            return new int[]{rootMin, rootMax};
        }

        int min(int a, int b, int c) {
            return Math.min(Math.min(a, b), c);
        }
        int max(int a, int b, int c) {
            return Math.max(Math.max(a, b), c);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MaximumDifferenceBetweenNodeAndAncestor().new Solution();
        // put your test code here
        
    }
}