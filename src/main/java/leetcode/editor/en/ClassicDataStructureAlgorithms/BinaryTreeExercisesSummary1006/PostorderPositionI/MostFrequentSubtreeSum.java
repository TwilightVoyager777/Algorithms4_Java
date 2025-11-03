package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.PostorderPositionI;

import java.util.*;
import leetcode.editor.common.*;

public class MostFrequentSubtreeSum {

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
        HashMap<Integer, Integer> sumToCount = new HashMap<>();
        public int[] findFrequentTreeSum(TreeNode root) {
            sum(root);
            int maxCount = 0;
            for (int count : sumToCount.values()) {
                maxCount = Math.max(maxCount, count);
            }
            ArrayList<Integer> res = new ArrayList<>();
            for (Integer key : sumToCount.keySet()) {
                if (sumToCount.get(key) == maxCount) {
                    res.add(key);
                }
            }
            int[] arr = new int[res.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = res.get(i);
            }
            return arr;

        }

        int sum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftSum = sum(root.left);
            int rightSum = sum(root.right);
            int res = root.val + leftSum + rightSum;

            sumToCount.put(res, sumToCount.getOrDefault(res, 0) + 1);
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MostFrequentSubtreeSum().new Solution();
        // put your test code here
        
    }
}