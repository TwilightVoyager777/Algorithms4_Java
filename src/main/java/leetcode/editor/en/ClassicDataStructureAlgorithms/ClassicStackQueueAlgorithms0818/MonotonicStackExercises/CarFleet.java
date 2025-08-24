package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.MonotonicStackExercises;

import java.util.*;

public class CarFleet {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            int n = position.length;
            int[][] cars = new int[n][2];
            for (int i = 0; i < n; i++) {
                cars[i][0] = position[i];
                cars[i][1] = speed[i];
            }
            Arrays.sort(cars, (int[] a, int[] b) -> {
                return Integer.compare(a[0], b[0]);
            });
            double[] time = new double[n];
            for (int i = 0; i < n; i++) {
                int[] car = cars[i];
                time[i] = (double) (target - car[0]) / car[1];
            }
            int res = 0;
            double maxTime = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (time[i] > maxTime) {
                    maxTime = time[i];
                    res++;
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new CarFleet().new Solution();
        // put your test code here
        
    }
}