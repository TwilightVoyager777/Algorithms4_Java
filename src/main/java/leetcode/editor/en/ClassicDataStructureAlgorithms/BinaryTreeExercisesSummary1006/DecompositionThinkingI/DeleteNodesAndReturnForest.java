package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.DecompositionThinkingI;

import java.util.*;
import leetcode.editor.common.*;

public class DeleteNodesAndReturnForest {

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
        Set<Integer> delSet = new HashSet<>();
        List<TreeNode> res = new LinkedList<>();
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            if (root == null) return new LinkedList<>();
            for (int d: to_delete) {
                delSet.add(d);
            }
            doDelete(root,false);
            return res;
        }

        private TreeNode doDelete(TreeNode root, boolean hasParent) {
            if (root == null) return null;
            boolean deleted = delSet.contains(root.val);
            if (!deleted && !hasParent) res.add(root);
            root.left = doDelete(root.left, !deleted);
            root.right = doDelete(root.right, !deleted);
            return deleted ? null : root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new DeleteNodesAndReturnForest().new Solution();
        // put your test code here
        
    }
}