package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class MinimumDepthOfBinaryTree {

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
        private int minDepth = Integer.MAX_VALUE;
        private int currentDepth = 0;
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            traverse(root);
            return minDepth;
        }

        private void traverse(TreeNode root) {
            if (root == null) {
                return;
            }

            currentDepth++;
            if (root.left == null && root.right == null) {
                minDepth = Math.min(minDepth, currentDepth);
            }

            traverse(root.left);
            traverse(root.right);
            currentDepth--;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
        // put your test code here

    }
}