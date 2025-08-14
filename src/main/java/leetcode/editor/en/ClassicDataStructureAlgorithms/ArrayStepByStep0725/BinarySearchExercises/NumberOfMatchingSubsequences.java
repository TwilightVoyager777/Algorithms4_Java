package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.BinarySearchExercises;

import java.util.*;

public class NumberOfMatchingSubsequences {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            ArrayList<Integer>[] charToIndexes = new ArrayList[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (charToIndexes[c - 'a'] == null) {
                    charToIndexes[c - 'a'] = new ArrayList<>();
                }
                charToIndexes[c - 'a'].add(i);
            }

            int res = 0;
            for (String word : words) {
                int i = 0, j = 0;
                while (i < word.length()) {
                    char c = word.charAt(i);
                    if (charToIndexes[c - 'a'] == null) {
                        break;
                    }
                    int pos = left_bound(charToIndexes[c - 'a'], j);
                    if (pos == charToIndexes[c - 'a'].size()) {
                        break;
                    }
                    j = charToIndexes[c - 'a'].get(pos);
                    j++;
                    i++;
                }
                if (i == word.length()){
                    res++;
                }
            }
            return res;
        }

        int left_bound(ArrayList<Integer> arr, int target) {
            int left = 0, right = arr.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (target > arr.get(mid)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new NumberOfMatchingSubsequences().new Solution();
        // put your test code here
        
    }
}