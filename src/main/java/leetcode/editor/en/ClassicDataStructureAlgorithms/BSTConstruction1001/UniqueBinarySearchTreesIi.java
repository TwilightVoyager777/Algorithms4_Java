package leetcode.editor.en.ClassicDataStructureAlgorithms.BSTConstruction1001;

import java.util.*;
import leetcode.editor.common.*;

public class UniqueBinarySearchTreesIi {

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
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) return new LinkedList<>();
            return build(1, n);
        }

        List<TreeNode> build(int lo, int hi) {
            List<TreeNode> res = new LinkedList<>();
            if (lo > hi) {
                res.add(null);
                return res;
            }
            for (int i = lo; i <= hi; i++) {
                List<TreeNode> leftTree = build(lo, i - 1);
                List<TreeNode> rightTree = build(i + 1, hi);
                for (TreeNode left : leftTree) {
                    for (TreeNode right : rightTree) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();
        // put your test code here
        
    }
}