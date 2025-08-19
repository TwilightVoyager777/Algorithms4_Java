package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.StackExercises;

import java.util.*;

public class LongestAbsoluteFilePath {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthLongestPath(String input) {
            Deque<String> stack = new LinkedList<>();
            int maxLen = 0;
            for (String part : input.split("\n")) {
                int level = part.lastIndexOf("\t") + 1;
                while (level < stack.size()) {
                    stack.removeLast();
                }
                stack.addLast(part.substring(level));
                if (part.contains(".")) {
                    int sum = stack.stream().mapToInt(String::length).sum();
                    sum += stack.size() - 1;
                    maxLen = Math.max(maxLen, sum);
                }
            }
            return maxLen;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new LongestAbsoluteFilePath().new Solution();
        // put your test code here
        
    }
}