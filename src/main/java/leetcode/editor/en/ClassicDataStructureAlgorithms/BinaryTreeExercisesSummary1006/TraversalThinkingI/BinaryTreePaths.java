package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.TraversalThinkingI;

import java.util.*;
import leetcode.editor.common.*;

public class BinaryTreePaths {

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
        public List<String> binaryTreePaths(TreeNode root) {
            traverse(root);
            return res;
        }

        LinkedList<String> path = new LinkedList<>();
        LinkedList<String> res = new LinkedList<>();

        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }

            if (root.left == null && root.right == null) {
                path.addLast(root.val + "");
                res.addLast(String.join("->", path));
                path.removeLast();
                return;
            }
            path.addLast(root.val + "");
            traverse(root.left);
            traverse(root.right);
            path.removeLast();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
        // put your test code here
        
    }
}