package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.TraversalThinkingI;

import leetcode.editor.common.*;

public class SmallestStringStartingFromLeaf {

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
        public String smallestFromLeaf(TreeNode root) {
            traverse(root);
            return res;
        }

        StringBuilder path = new StringBuilder();
        String res = null;

        void traverse(TreeNode root) {
            if (root == null) return;

            if (root.left == null && root.right == null) {
                path.append((char) ('a' + root.val));
                path.reverse();

                String s = path.toString();
                if (res == null || res.compareTo(s) > 0) {
                    res = s;
                }

                path.reverse();
                path.deleteCharAt(path.length() - 1);
                return;
            }
            path.append((char) ('a' + root.val));
            traverse(root.left);
            traverse(root.right);
            path.deleteCharAt(path.length() - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SmallestStringStartingFromLeaf().new Solution();
        // put your test code here
        
    }
}