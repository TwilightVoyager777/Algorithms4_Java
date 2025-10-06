package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeStepByStep0901.BSTBasics;

import leetcode.editor.common.*;

public class DeleteNodeInABst {

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
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;
            if (root.val == key) {
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;

                TreeNode minNode = getMin(root.right);
                root.right = deleteNode(root.right, minNode.val);
                minNode.left = root.left;
                minNode.right = root.right;
                root = minNode;
            } else if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else if (root.val < key) {
                root.right = deleteNode(root.right, key);
            }
            return root;
        }

        TreeNode getMin(TreeNode node) {
            while (node.left != null) node = node.left;
            return node;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new DeleteNodeInABst().new Solution();
        // put your test code here
        
    }
}