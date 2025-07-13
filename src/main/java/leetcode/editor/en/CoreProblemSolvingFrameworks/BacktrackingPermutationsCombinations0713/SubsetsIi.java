package leetcode.editor.en.CoreProblemSolvingFrameworks.BacktrackingPermutationsCombinations0713;

import java.util.*;

public class SubsetsIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            backtrack(nums, 0);
            return res;
        }

        void backtrack(int[] nums, int start) {
            res.add(new LinkedList<>(track));
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i-1]) {
                    continue;
                }
                track.addLast(nums[i]);
                backtrack(nums, i + 1);
                track.removeLast();
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
        // put your test code here
        
    }
}