package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.MatrixTraversalTechniques;

public class RotateImage {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            for (int[] row : matrix){
                reverse(row);
            }
        }
        void reverse(int[] arr) {
            int i = 0, j = arr.length - 1;
            while (j > i) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
                i++;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
        // put your test code here
        
    }
}