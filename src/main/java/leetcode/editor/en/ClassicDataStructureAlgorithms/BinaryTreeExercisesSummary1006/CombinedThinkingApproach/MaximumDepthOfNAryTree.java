package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeExercisesSummary1006.CombinedThinkingApproach;

public class MaximumDepthOfNAryTree {

    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    */

    class Solution1 {
        int depth = 0, res = 0;
        public int maxDepth(Node root) {
            if (root == null) return 0;
            traverse(root);
            return res;
        }
        void traverse(Node root) {
            if (root == null) return;
            depth++;
            res = Math.max(res, depth);
            for (Node child : root.children) {
                traverse(child);
            }
            depth--;
        }
    }
    class Solution {
        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }
            int subTreeMaxDepth = 0;
            for (Node child : root.children) {
                subTreeMaxDepth = Math.max(subTreeMaxDepth, maxDepth(child));
            }
            return 1 + subTreeMaxDepth;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfNAryTree().new Solution();
        // put your test code here
        
    }
}