package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.SlidingWindowExercises;

public class LongestRepeatingCharacterReplacement {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            int left = 0, right = 0;
            int max = 0;
            int res = 0;
            int[] count = new int[26];

            while (right < s.length()) {
                int c = s.charAt(right) - 'A';
                count[c]++;
                max = Math.max(max, count[c]);
                right++;

                while(right - left - max > k) {
                    count[s.charAt(left) - 'A']--;
                    left++;
                }
                res = Math.max(res, right - left);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new LongestRepeatingCharacterReplacement().new Solution();
        // put your test code here
        
    }
}