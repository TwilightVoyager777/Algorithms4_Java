package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.BinarySearchThinking;

public class CapacityToShipPackagesWithinDDays {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int left = 0, right = 1;
            for (int w : weights) {
                left = Math.max(left, w);
                right = right + w;
            }
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (f(weights, mid) == days) {
                    right = mid;
                } else if (f(weights, mid) < days) {
                    right = mid;
                } else if (f(weights, mid) > days) {
                    left = mid + 1;
                }
            }
            return left;
        }
        int f(int[] weights, int x) {
            int days = 0;
            for (int i = 0; i < weights.length;) {
                int cap = x;
                while (i < weights.length) {
                    if (cap < weights[i]) break;
                    else cap = cap - weights[i];
                    i++;
                }
                days++;
            }
            return days;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new CapacityToShipPackagesWithinDDays().new Solution();
        // put your test code here
        
    }
}