package leetcode.editor.en.ClassicDataStructureAlgorithms.LinkedListStepByStep0724.LinkedListTwoPointerExercises;

import java.util.*;

public class KthSmallestElementInASortedMatrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                return a[0] -b[0];
            });
            for (int i = 0; i < matrix.length; i++) {
                pq.offer(new int[]{matrix[i][0], i, 0});
            }

            int res = -1;
            while (!pq.isEmpty() && k > 0) {
                int[] cur = pq.poll();
                res = cur[0];
                k--;
                int i = cur[1], j = cur[2];
                if (j + 1 < matrix[i].length) {
                    pq.add(new int[]{matrix[i][j + 1], i , j + 1});
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
        // put your test code here
        
    }
}