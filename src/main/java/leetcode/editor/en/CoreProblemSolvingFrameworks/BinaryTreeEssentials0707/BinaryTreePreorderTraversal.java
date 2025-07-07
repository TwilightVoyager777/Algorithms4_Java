package leetcode.editor.en.CoreProblemSolvingFrameworks.BinaryTreeEssentials0707;

import java.util.*;
import leetcode.editor.common.*;

public class BinaryTreePreorderTraversal {

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
        List<Integer> res = new LinkedList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            traverse(root);
            return res;
        }
        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            res.add(root.val);
            traverse(root.left);
            traverse(root.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
        // put your test code here
        
    }
}