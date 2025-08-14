package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.BinarySearchExercises;

public class SearchA2dMatrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int left = 0, right = m * n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (get(matrix, mid) == target) {
                    return true;
                } else if (get(matrix, mid) > target) {
                    right = mid - 1;
                } else if (get(matrix, mid) < target) {
                    left = mid + 1;
                }
            }
            return false;
        }

        int get(int[][] matrix, int index) {
            int m = matrix.length, n = matrix[0].length;
            int i = index / n, j = index % n;
            return matrix[i][j];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        // put your test code here
        
    }
}