package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.ArrayTwoPointerExercises;

public class MergeSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1;
            int j = n - 1;
            int p = nums1.length - 1;
            while (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[p] = nums1[i];
                    i--;
                } else {
                    nums1[p] = nums2[j];
                    j--;
                }
                p--;
            }
            while (j >= 0) {
                nums1[p] = nums2[j];
                j--;
                p--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        // put your test code here
        
    }
}