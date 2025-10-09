package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.TraversalThinkingIII;

import java.util.*;
import leetcode.editor.common.*;

public class PathSumIii {

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
        long targetSum, pathSum;
        int res = 0;
        HashMap<Long, Integer> preSumCount = new HashMap<>();
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) return 0;
            this.pathSum = 0;
            this.targetSum = targetSum;
            this.preSumCount.put(0L, 1);
            traverse(root);
            return res;
        }

        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            pathSum = pathSum + root.val;
            res = res + preSumCount.getOrDefault(pathSum - targetSum, 0);
            preSumCount.put(pathSum, preSumCount.getOrDefault(pathSum, 0) + 1);
            traverse(root.left);
            traverse(root.right);
            preSumCount.put(pathSum, preSumCount.get(pathSum) - 1 );
            pathSum = pathSum - root.val;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
        // put your test code here
        
    }
}