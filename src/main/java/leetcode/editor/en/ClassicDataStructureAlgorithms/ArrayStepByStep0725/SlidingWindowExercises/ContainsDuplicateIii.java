package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.SlidingWindowExercises;

import java.util.*;

public class ContainsDuplicateIii {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
            int n = nums.length;
            int left = 0, right = 0;
            TreeSet<Integer> window = new TreeSet<>();
            while (right < n) {
                Integer ceiling = window.ceiling(nums[right]);
                if (ceiling != null && (long) ceiling - nums[right] <= valueDiff) {
                    return true;
                }
                Integer floor = window.floor(nums[right]);
                if (floor != null && (long) nums[right] - floor <= valueDiff) {
                    return true;
                }

                window.add(nums[right]);
                right++;

                if (right - left > indexDiff) {
                    window.remove(nums[left]);
                    left++;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii().new Solution();
        // put your test code here
        
    }
}