package leetcode.editor.en.CoreProblemSolvingFrameworks.BacktrackingFramework;

import java.util.*;

public class Permutations {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> permute(int[] nums) {
            LinkedList<Integer> track = new LinkedList<>();
            boolean[] used = new boolean[nums.length];
            backtrack(nums, track, used);
            return res;
        }

        void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
            if (track.size() == nums.length) {
                res.add(new LinkedList(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                track.add(nums[i]);
                used[i] = true;
                backtrack(nums, track, used);
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