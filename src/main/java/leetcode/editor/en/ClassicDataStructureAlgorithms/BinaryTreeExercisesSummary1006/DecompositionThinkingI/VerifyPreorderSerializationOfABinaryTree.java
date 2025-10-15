package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.DecompositionThinkingI;

public class VerifyPreorderSerializationOfABinaryTree {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSerialization(String preorder) {
            int edge = 1;
            for (String node : preorder.split(",")){
                if (node.equals("#")) {
                    edge = edge - 1;
                    if (edge < 0) {
                        return false;
                    }
                } else {
                    edge = edge - 1;
                    if (edge < 0) {
                        return false;
                    }
                    edge = edge + 2;
                }

            }
            return edge == 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new VerifyPreorderSerializationOfABinaryTree().new Solution();
        // put your test code here
        
    }
}