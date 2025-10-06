package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeStepByStep0901.BSTConstruction;

public class UniqueBinarySearchTrees {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;

        public int numTrees(int n) {
            memo = new int[n + 1][n + 1];
            return count(1, n);
        }

        int count(int lo, int hi) {
            if (lo >= hi) return 1;
            if (memo[lo][hi] != 0) {
                return memo[lo][hi];
            }

            int res = 0;
            for (int mid = lo; mid <= hi; mid++) {
                int left = count(lo, mid - 1);
                int right = count(mid + 1, hi);
                res = res + left * right;
            }
            memo[lo][hi] = res;
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        
    }
}