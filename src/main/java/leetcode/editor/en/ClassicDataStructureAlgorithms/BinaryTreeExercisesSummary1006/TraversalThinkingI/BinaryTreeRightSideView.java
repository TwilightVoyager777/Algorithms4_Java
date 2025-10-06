package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.TraversalThinkingI;

import java.util.*;
import leetcode.editor.common.*;

public class BinaryTreeRightSideView {

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
        List<Integer> res = new ArrayList<>();
        int depth = 0;

        public List<Integer> rightSideView(TreeNode root) {
            traverse(root);
            return res;
        }

        void traverse(TreeNode root) {
            if (root == null) return;
            depth++;
            if (res.size() < depth) {
                res.add(root.val);
            }
            traverse(root.right);
            traverse(root.left);
            depth--;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
        // put your test code here
        
    }
}