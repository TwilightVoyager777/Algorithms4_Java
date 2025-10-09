package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.TraversalThinkingIII;

import java.util.*;
import leetcode.editor.common.*;

public class FindElementsInAContaminatedBinaryTree {

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
    class FindElements {

        HashSet<Integer> values = new HashSet<>();

        public FindElements(TreeNode root) {
            traverse(root, 0);
        }

        void traverse(TreeNode root, int val) {
            if (root == null) return;
            root.val = val;
            values.add(val);
            traverse(root.left, 2 * val + 1);
            traverse(root.right, 2 * val + 2);
        }

        public boolean find(int target) {
            return values.contains(target);
        }
    }
    
    /**
     * Your FindElements object will be instantiated and called as such:
     * FindElements obj = new FindElements(root);
     * boolean param_1 = obj.find(target);
     */
    //leetcode submit region end(Prohibit modification and deletion)


}