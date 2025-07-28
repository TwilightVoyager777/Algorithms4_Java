package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.MatrixTraversalTechniques;

public class SpiralMatrixIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            int upper_bound = 0, lower_bound = n - 1;
            int left_bound = 0, right_bound = n - 1;
            int num = 1;
            while (num <= n * n) {
                if (upper_bound <= lower_bound) {
                    for (int j = left_bound; j <= right_bound; j++) {
                        matrix[upper_bound][j] = num;
                        num++;
                    }
                    upper_bound++;
                }
                if (left_bound <= right_bound) {
                    for (int i = upper_bound; i <= lower_bound; i++) {
                        matrix[i][right_bound] = num;
                        num++;
                    }
                    right_bound--;
                }
                if (upper_bound <= lower_bound) {
                    for (int j = right_bound; j >= left_bound; j--) {
                        matrix[lower_bound][j] = num;
                        num++;
                    }
                    lower_bound--;
                }
                if (left_bound <= right_bound) {
                    for (int i = lower_bound; i >= upper_bound; i--) {
                        matrix[i][left_bound] = num;
                        num++;
                    }
                    left_bound++;
                }

            }
            return matrix;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        // put your test code here
        
    }
}