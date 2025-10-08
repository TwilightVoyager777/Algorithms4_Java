package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.TraversalThinkingII;

import java.util.*;
import leetcode.editor.common.*;

public class VerticalOrderTraversalOfABinaryTree {

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

        class Triple {
            public int row, col;
            public TreeNode node;
            public Triple(TreeNode node, int row, int col) {
                this.node = node;
                this.row = row;
                this.col = col;
            }
        }

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            traverse(root, 0, 0);
            Collections.sort(nodes, (Triple a, Triple b) -> {
                if (a.col == b.col && a.row == b.row) {
                    return a.node.val - b.node.val;
                }
                if (a.col == b.col) {
                    return a.row - b.row;
                }
                return a.col - b.col;
            });
            LinkedList<List<Integer>> res = new LinkedList<>();
            int preCol = Integer.MIN_VALUE;
            for (int i = 0; i < nodes.size(); i++) {
                Triple cur = nodes.get(i);
                if (cur.col != preCol) {
                    res.addLast(new LinkedList<>());
                    preCol = cur.col;
                }
                res.getLast().add(cur.node.val);
            }
            return res;
        }

        ArrayList<Triple> nodes = new ArrayList<>();
        void traverse(TreeNode root, int row, int col) {
            if (root == null) return;
            nodes.add(new Triple(root, row, col));
            traverse(root.left, row + 1, col - 1);
            traverse(root.right, row + 1, col + 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new VerticalOrderTraversalOfABinaryTree().new Solution();
        // put your test code here
        
    }
}