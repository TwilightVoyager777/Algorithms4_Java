package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeStepByStep0901.BinaryTreePostorder;

import java.util.*;
import leetcode.editor.common.*;

public class FindDuplicateSubtrees {

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

        HashMap<String, Integer> memo = new HashMap<>();
        LinkedList<TreeNode> res = new LinkedList<>();

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            traverse(root);
            return res;
        }

        String traverse(TreeNode root) {
            if (root == null) {
                return "#";
            }
            String left = traverse(root.left);
            String right = traverse(root.right);
            String subTree = left + "," + right + "," + root.val;
            int freq = memo.getOrDefault(subTree, 0);
            if (freq == 1) {
                res.add(root);
            }
            memo.put(subTree, freq + 1);
            return subTree;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new FindDuplicateSubtrees().new Solution();
        // put your test code here
        
    }
}