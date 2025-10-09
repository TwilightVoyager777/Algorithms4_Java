package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.TraversalThinkingIII;

import java.util.*;

public class LexicographicalNumbers {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<Integer> res = new ArrayList<>();

        public List<Integer> lexicalOrder(int n) {
            for (int i = 1; i < 10; i++) {
                traverse(i, n);
            }
            return res;
        }

        void traverse(int root, int n) {
            if (root > n) {
                return;
            }
            res.add(root);
            for (int child = root * 10; child < root * 10 + 10; child++) {
                traverse(child, n);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new LexicographicalNumbers().new Solution();
        // put your test code here
        
    }
}