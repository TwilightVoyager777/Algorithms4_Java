package leetcode.editor.en.CoreProblemSolvingFrameworks.BacktrackingPermutationsCombinations0713;

import java.util.*;

public class Combinations {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        public List<List<Integer>> combine(int n, int k) {
            backtrack(1, n, k);
            return res;
        }

        void backtrack(int start, int n, int k) {
            if (k == track.size()) {
                res.add(new LinkedList<>(track));
                return;
            }

            for(int i = start; i <= n; i++) {
                track.addLast(i);
                backtrack(i + 1, n , k);
                track.removeLast();
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        // put your test code here
        
    }
}