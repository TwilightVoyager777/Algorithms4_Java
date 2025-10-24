package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.CombinedThinkingApproach;

import leetcode.editor.common.*;

public class IncreasingOrderSearchTree {

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
        TreeNode cur;
        public TreeNode increasingBST(TreeNode root) {
            TreeNode dummy = new TreeNode(-1);
            cur = dummy;

            // 中序遍历 BST
            traverse(root);

            // 返回哨兵的右子节点，即新根
            return dummy.right;
        }

        void traverse(TreeNode root) {
            if (root == null) return;

            traverse(root.left);   // 左
            root.left = null;      // 去掉左子树
            cur.right = root;      // 将当前节点接在链表尾部
            cur = root;            // 更新链表尾指针
            traverse(root.right);  // 右
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new IncreasingOrderSearchTree().new Solution();
        // put your test code here
        
    }
}