package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.TraversalThinkingIII;

import java.util.*;

public class PathInZigzagLabelledBinaryTree {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> pathInZigZagTree(int label) {
            ArrayList<Integer> path = new ArrayList<>();
            while (label >= 1) {
                path.add(label);
                label = label / 2;

                int depth = log(label);
                int[] range = getLevelRange(depth);
                label = range[1] - (label - range[0]);
            }
            Collections.reverse(path);
            return path;
        }

        private int[] getLevelRange(int n) {
            int p = (int) Math.pow(2, n);
            return new int[]{p, 2 * p - 1};
        }

        int log(int x) {
            return (int) (Math.log(x) / Math.log(2));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PathInZigzagLabelledBinaryTree().new Solution();
        // put your test code here
        
    }
}