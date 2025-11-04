package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.PostorderPositionI;

import leetcode.editor.common.*;

public class BinaryTreeTilt {

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
        int res = 0;
        public int findTilt(TreeNode root) {
            if (root == null) return 0;
            sum(root);
            return res;
        }
        int sum(TreeNode root) {
            if (root == null) return 0;
            int leftSum = sum(root.left);
            int rightSum = sum(root.right);
            res = res + Math.abs(leftSum - rightSum);
            return leftSum + rightSum + root.val;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BinaryTreeTilt().new Solution();
        // put your test code here
        
    }
}