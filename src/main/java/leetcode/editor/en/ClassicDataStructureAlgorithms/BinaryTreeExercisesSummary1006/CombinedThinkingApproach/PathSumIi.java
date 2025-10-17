package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.CombinedThinkingApproach;

import java.util.*;
import leetcode.editor.common.*;

public class PathSumIi {

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


        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> rootAnswers = new LinkedList<>();
            if (root == null) {
                return rootAnswers;
            }
            if (root.left == null && root.right == null && root.val == sum) {
                LinkedList<Integer> path = new LinkedList<>();
                path.add(root.val);
                rootAnswers.add(path);
                return rootAnswers;
            }

            List<List<Integer>> leftAnswers = pathSum(root.left, sum - root.val);
            List<List<Integer>> rightAnswers = pathSum(root.right, sum - root.val);

            for (List<Integer> answer : leftAnswers) {
                answer.add(0, root.val);
                rootAnswers.add(answer);
            }

            for (List<Integer> answer : rightAnswers) {
                answer.add(0, root.val);
                rootAnswers.add(answer);
            }
            return rootAnswers;
        }

    }
    class Solution1 {

        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if (root == null) return res;
            traverse(root, sum, new LinkedList<>());
            return res;
        }

        void traverse(TreeNode root, int sum, LinkedList<Integer> path) {
            if (root == null) return;
            int remain = sum - root.val;
            if (root.left == null && root.right == null) {
                if (remain == 0) {
                    path.addLast(root.val);
                    res.add(new LinkedList<>(path));
                    path.removeLast();
                }
                return;
            }

            path.addLast(root.val);
            traverse(root.left, remain, path);
            path.removeLast();

            path.addLast(root.val);
            traverse(root.right, remain, path);
            path.removeLast();
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
        // put your test code here
        
    }
}