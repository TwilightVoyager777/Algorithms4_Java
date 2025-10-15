package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.DecompositionThinkingI;

import java.util.*;
import leetcode.editor.common.*;

public class AllPossibleFullBinaryTrees {

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

        List<TreeNode>[] memo;

        public List<TreeNode> allPossibleFBT(int n) {
            if (n % 2 == 0) {
                return new LinkedList<>();
            }
            memo = new LinkedList[n + 1];
            return build(n);
        }

        public List<TreeNode> build(int n) {
            List<TreeNode> res = new LinkedList<>();
            if (n == 1) {
                res.add(new TreeNode(0));
                return res;
            }
            if (memo[n] != null) {
                return memo[n];
            }
            for (int i = 1; i < n; i = i + 2) {
                int j = n - i - 1;
                List<TreeNode> leftSubTrees = build(i);
                List<TreeNode> rightSubTrees = build(j);

                for (TreeNode left : leftSubTrees) {
                    for (TreeNode right : rightSubTrees) {
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }
            memo[n] = res;
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new AllPossibleFullBinaryTrees().new Solution();
        // put your test code here
        
    }
}