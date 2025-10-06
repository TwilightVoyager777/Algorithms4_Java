package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.TraversalThinkingI;

import leetcode.editor.common.*;

public class PseudoPalindromicPathsInABinaryTree {

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
        public int pseudoPalindromicPaths (TreeNode root) {
            traverse(root);
            return res;
        }
        int[] count = new int[10];
        int res = 0;

        void traverse(TreeNode root) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                count[root.val]++;
                int odd = 0;
                for (int n : count) {
                    if (n % 2 == 1) {
                        odd++;
                    }
                }
                if (odd <= 1) {
                    res++;
                }
                count[root.val]--;
                return;
            }
            count[root.val]++;
            traverse(root.left);
            traverse(root.right);
            count[root.val]--;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PseudoPalindromicPathsInABinaryTree().new Solution();
        // put your test code here
        
    }
}