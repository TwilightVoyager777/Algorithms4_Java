package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.BinarySearchExercises;

import java.util.*;

public class FindKClosestElements {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int p = left_bound(arr, x);
            int left = p - 1, right = p;
            ArrayList<Integer> res = new ArrayList<>();
            while (right - left - 1 < k) {
                if (left == -1) {
                    right++;
                } else if (right == arr.length) {
                    left--;
                } else if (x - arr[left] > arr[right] - x) {
                    right++;
                } else {
                    left--;
                }
            }
            for (int i = left + 1; i < right; i++) {
                res.add(arr[i]);
            }
            return res;
        }
        int left_bound(int[] nums, int target) {
            int left = 0;
            int right = nums.length;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    right = mid;
                } else if (nums[mid] > target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new FindKClosestElements().new Solution();
        // put your test code here
        
    }
}