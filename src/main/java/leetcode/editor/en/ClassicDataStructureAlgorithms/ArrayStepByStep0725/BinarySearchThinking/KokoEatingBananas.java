package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.BinarySearchThinking;

public class KokoEatingBananas {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1, right = 1000000000 + 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (f(piles, mid) == h) {
                    right = mid;
                } else if (f(piles, mid) < h) {
                    right = mid;
                } else if(f(piles, mid) > h) {
                    left = mid + 1;
                }
            }
            return left;
        }
        long f(int[] piles, int x) {
            long hours = 0;
            for (int i = 0; i < piles.length; i++) {
                hours = hours + piles[i] / x;
                if (piles[i] % x > 0) {
                    hours++;
                }
            }
            return hours;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new KokoEatingBananas().new Solution();
        // put your test code here
        
    }
}