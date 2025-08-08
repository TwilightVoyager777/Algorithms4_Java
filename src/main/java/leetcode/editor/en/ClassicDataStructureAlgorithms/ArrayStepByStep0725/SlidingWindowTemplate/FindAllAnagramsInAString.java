package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.SlidingWindowTemplate;

import java.util.*;

public class FindAllAnagramsInAString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            HashMap<Character, Integer> window = new HashMap<>();
            HashMap<Character, Integer> need = new HashMap<>();
            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            int left = 0, right = 0, valid = 0;
            int start = 0, len = Integer.MAX_VALUE;
            List<Integer> res = new ArrayList<>();
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                window.put(c, need.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }
            while (right - left >= p.length()){
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        // put your test code here
        
    }
}