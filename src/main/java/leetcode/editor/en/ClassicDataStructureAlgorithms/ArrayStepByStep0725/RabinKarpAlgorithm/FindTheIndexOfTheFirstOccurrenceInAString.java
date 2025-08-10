package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.RabinKarpAlgorithm;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) return 0; // 空 needle 返回 0
            if (haystack.length() < needle.length()) return -1; // 无法匹配

            return rabinKarp(haystack, needle);
        }

        int rabinKarp (String txt, String pat) {
            int L = pat.length();
            int R = 256;
            long Q = 1658598167;
            long RL = 1;
            for (int i = 1; i <= L - 1; i++) {
                RL = (RL * R) % Q;
            }
            long patHash = 0;
            for (int i = 0; i < pat.length(); i++) {
                patHash = (R * patHash + pat.charAt(i)) % Q;
            }
            long windowHash = 0;
            int left = 0, right = 0;
            while (right < txt.length()) {
                windowHash = ((R * windowHash) % Q + txt.charAt(right)) % Q;
                right++;
                if (right - left == L) {
                    if (windowHash == patHash) {
                        if (pat.equals(txt.substring(left, right))) {
                            return left;
                        }
                    }
                    windowHash = (windowHash - (txt.charAt(left) * RL) % Q + Q) % Q;
                    left++;
                }

            }
            return -1;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
        // put your test code here
        
    }
}