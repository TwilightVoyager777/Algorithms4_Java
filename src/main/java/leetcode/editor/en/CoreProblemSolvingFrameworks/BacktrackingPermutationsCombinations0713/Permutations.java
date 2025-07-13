package leetcode.editor.en.CoreProblemSolvingFrameworks.BacktrackingPermutationsCombinations0713;

import java.util.*;

public class Permutations {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used;
        public List<List<Integer>> permute(int[] nums) {
            used = new boolean[nums.length];
            backtrack(nums);
            return res;
        }

        void backtrack(int[] nums) {
            if (track.size() == nums.length) {
                res.add(new LinkedList(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                track.addLast(nums[i]);
                backtrack(nums);
                track.removeLast();
                used[i] = false;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        // put your test code here
        
    }
}