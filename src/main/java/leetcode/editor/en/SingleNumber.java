package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class SingleNumber {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            HashMap<Integer, Integer> hashmap = new HashMap<>();
            for(int num : nums) {
                hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
            }
            for(int num : nums) {
                if(hashmap.get(num) == 1){
                    return num;
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
        // put your test code here
        int result = solution.singleNumber(new int[] {2,2,3,3,4});
        System.out.println(result);
    }
}