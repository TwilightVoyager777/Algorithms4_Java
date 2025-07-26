package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.MatrixTraversalTechniques;

import java.util.*;

public class SpiralMatrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int upper_bound = 0, lower_bound = m - 1;
            int left_bound = 0, right_bound = n - 1;
            LinkedList res = new LinkedList<>();
            while (res.size() < m * n) {
                if (upper_bound <= lower_bound) {
                    for (int j = left_bound; j <= right_bound; j++) {
                        res.add(matrix[upper_bound][j]);
                    }
                    upper_bound++;
                }
                if (left_bound <= right_bound) {
                    for (int i = upper_bound; i <= lower_bound; i++) {
                        res.add(matrix[i][right_bound]);
                    }
                    right_bound--;
                }
                if (upper_bound <= lower_bound) {
                    for (int j = right_bound; j >= left_bound; j--) {
                        res.add(matrix[lower_bound][j]);
                    }
                    lower_bound--;
                }
                if (left_bound <= right_bound) {
                    for (int i = lower_bound; i >= upper_bound; i--) {
                        res.add(matrix[i][left_bound]);
                    }
                    left_bound++;
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        // put your test code here
        
    }
}