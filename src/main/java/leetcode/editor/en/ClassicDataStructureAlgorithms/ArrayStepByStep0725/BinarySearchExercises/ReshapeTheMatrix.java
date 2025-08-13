package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.BinarySearchExercises;

public class ReshapeTheMatrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            int m = mat.length, n = mat[0].length;
            if (r * c != m * n)  return mat;
            int[][] res = new int[r][c];
            for (int i = 0; i < m * n; i++) {
                set(res, i ,get(mat, i));
            }
            return res;
        }
        int get(int[][] matrix, int index) {
            int m = matrix.length, n = matrix[0].length;
            int i = index / n, j = index % n;
            return matrix[i][j];
        }
        void set(int[][] matrix, int index, int value) {
            int m = matrix.length, n = matrix[0].length;
            int i = index / n, j = index % n;
            matrix[i][j] = value;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReshapeTheMatrix().new Solution();
        // put your test code here
        
    }
}