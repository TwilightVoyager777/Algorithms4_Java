package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.StackExercises;

import java.util.*;

public class SimplifyPath {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String simplifyPath(String path) {
            String[] parts = path.split("/");
            Stack<String> stk = new Stack<>();
            for (String part : parts) {
                if (part.isEmpty() || part.equals(".")) {
                    continue;
                }
                if (part.equals("..")) {
                    if (!stk.isEmpty()) stk.pop();
                    continue;
                }
                stk.push(part);
            }
            String res = "";
            while (!stk.isEmpty()) {
                res = "/" + stk.pop() + res;
            }
            return res.isEmpty() ? "/" : res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SimplifyPath().new Solution();
        // put your test code here
        
    }
}