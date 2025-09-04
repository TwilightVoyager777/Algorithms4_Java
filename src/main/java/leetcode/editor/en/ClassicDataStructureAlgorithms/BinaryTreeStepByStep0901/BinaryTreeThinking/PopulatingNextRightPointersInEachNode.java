package leetcode.editor.en.ClassicDataStructureAlgorithms.BinaryTreeStepByStep0901.BinaryTreeThinking;

public class PopulatingNextRightPointersInEachNode {

    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    */
    
    class Solution {
        public Node connect(Node root) {
            if (root == null) return null;
            traverse(root.left, root.right);
            return root;
        }
        void traverse(Node node1, Node node2) {
            if (node1 == null || node2 == null) {
                return;
            }
            node1.next = node2;
            traverse(node1.left, node1.right);
            traverse(node2.left, node2.right);
            traverse(node1.right, node2.left);
        }
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
        // put your test code here
        
    }
}