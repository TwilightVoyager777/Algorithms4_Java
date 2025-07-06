package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class MinimumWindowSubstring {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> window = new HashMap<>();
            Map<Character, Integer> need = new HashMap<>();
            for (char c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            int left = 0, right = 0, valid = 0;
            int start = 0, len = Integer.MAX_VALUE;
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c)))
                        valid++;
                }

                while (valid == need.size()) {
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }
                    char d = s.charAt(left);
                    left++;
                    if (need.containsKey(d)) {
                        if (window.get(d).equals(need.get(d)))
                            valid--;
                        window.put(d, window.get(d) - 1);
                    }
                }
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        // put your test code here
        
    }
}