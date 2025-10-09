package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.TraversalThinkingIII;

import leetcode.editor.common.*;

public class BinaryTreeColoringGame {

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

        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            TreeNode node = find(root, x);
            int leftCount = count(node.left);
            int rightCount = count(node.right);
            int otherCount = n - 1 - leftCount - rightCount;
            return Math.max(leftCount, Math.max(rightCount, otherCount)) > n / 2;
        }

        TreeNode find(TreeNode root, int x) {
            if (root == null) {
                return null;
            }
            if (root.val == x) {
                return root;
            }
            TreeNode left = find(root.left, x);
            if (left != null) {
                return left;
            }
            return find(root.right, x);
        }

        int count(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + count(root.left) + count(root.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BinaryTreeColoringGame().new Solution();
        // put your test code here
        
    }
}