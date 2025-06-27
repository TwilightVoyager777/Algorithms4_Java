package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class LongestPalindromicSubstring {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                // 以 s[i] 为中心的最长回文子串
                String s1 = palindrome(s, i, i);
                // 以 s[i] 和 s[i+1] 为中心的最长回文子串
                String s2 = palindrome(s, i, i + 1);
                // res = longest(res, s1, s2)
                res = res.length() > s1.length() ? res : s1;
                res = res.length() > s2.length() ? res : s2;
            }
            return res;
        }

        String palindrome(String s, int l, int r) {
            // 防止索引越界
            while (l >= 0 && r < s.length()
                    && s.charAt(l) == s.charAt(r)) {
                // 向两边展开
                l--;
                r++;
            }
            // 此时 [l+1, r-1] 就是最长回文串
            return s.substring(l + 1, r);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        // put your test code here
        solution.longestPalindrome("babad");
    }
}