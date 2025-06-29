package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class ContainsDuplicate {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashSet hashset = new HashSet<>();
            for(int num : nums) {
                if(hashset.contains(num)) {
                    return true;
                }
                hashset.add(num);
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicate().new Solution();
        // put your test code here
        boolean result = solution.containsDuplicate(new int[]{1,2,3,1});
        System.out.println(result);
    }
}