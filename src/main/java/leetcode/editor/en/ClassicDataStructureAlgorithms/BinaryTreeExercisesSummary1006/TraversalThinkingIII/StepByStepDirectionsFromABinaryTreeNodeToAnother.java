package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.TraversalThinkingIII;

import leetcode.editor.common.*;

public class StepByStepDirectionsFromABinaryTreeNodeToAnother {

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
        public String getDirections(TreeNode root, int startValue, int destValue) {
            this.startValue = startValue;
            this.destValue = destValue;
            traverse(root);
            int p = 0, m = startPath.length(), n = destPath.length();
            while (p < m && p < n && startPath.charAt(p) == destPath.charAt(p)) {
                p++;
            }
            startPath = startPath.substring(p);
            destPath = destPath.substring(p);
            startPath = "U".repeat(startPath.length());
            return startPath + destPath;
        }

        StringBuilder path = new StringBuilder();
        String startPath, destPath;
        int startValue, destValue;

        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.val == startValue) {
                startPath = path.toString();
            } else if (root.val == destValue) {
                destPath = path.toString();
            }

            path.append('L');
            traverse(root.left);
            path.deleteCharAt(path.length() - 1);
            path.append('R');
            traverse(root.right);
            path.deleteCharAt(path.length() - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new StepByStepDirectionsFromABinaryTreeNodeToAnother().new Solution();
        // put your test code here
        
    }
}