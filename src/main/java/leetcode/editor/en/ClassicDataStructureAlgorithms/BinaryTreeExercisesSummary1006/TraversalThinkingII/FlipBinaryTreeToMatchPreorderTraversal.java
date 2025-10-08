package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.TraversalThinkingII;

import java.util.*;
import leetcode.editor.common.*;

public class FlipBinaryTreeToMatchPreorderTraversal {

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
        public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
            this.voyage = voyage;
            traverse(root);
            if (canFilp) {
                return res;
            }
            return Arrays.asList(-1);
        }
        List<Integer> res = new LinkedList<>();
        int i = 0;
        int[] voyage;
        boolean canFilp = true;
        void traverse(TreeNode root) {
            if (root == null || !canFilp) return;
            if (root.val != voyage[i++]) {
                canFilp = false;
                return;
            }
            if(root.left != null && root.left.val != voyage[i]) {
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                res.add(root.val);
            }
            traverse(root.left);
            traverse(root.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new FlipBinaryTreeToMatchPreorderTraversal().new Solution();
        // put your test code here
        
    }
}