package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.SlidingWindowTemplate;

import java.util.*;

public class PermutationInString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            HashMap<Character, Integer> window = new HashMap<>();
            HashMap<Character, Integer> need = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            int left = 0, right = 0, valid = 0;
            int start = 0, len = Integer.MAX_VALUE;
            while (right < s2.length()) {
                char c = s2.charAt(right);
                right++;
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c)))
                        valid++;
                }
                while (right - left >= s1.length()) {
                    if (valid == need.size())
                        return true;
                    char d = s2.charAt(left);
                    left++;
                    if (need.containsKey(d)) {
                        if (window.get(d).equals(need.get(d)))
                            valid--;
                        window.put(d, window.get(d) - 1);
                    }

                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        // put your test code here
        
    }
}