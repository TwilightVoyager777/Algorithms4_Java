package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.CombinedThinkingApproach;

import leetcode.editor.common.*;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    
    class Solution {
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            this.target = target;
            traverse(original, cloned);
            return res;
        }

        TreeNode target, res;
        void traverse(TreeNode original, TreeNode cloned) {
            if (original == null || res != null) {
                return;
            }
            if (original == target) {
                res = cloned;
                return;
            }
            traverse(original.left, cloned.left);
            traverse(original.right, cloned.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree().new Solution();
        // put your test code here
        
    }
}