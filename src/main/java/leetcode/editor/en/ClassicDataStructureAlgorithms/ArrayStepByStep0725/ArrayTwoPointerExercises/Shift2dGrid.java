package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.ArrayTwoPointerExercises;

import java.util.*;

public class Shift2dGrid {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            //定义长 宽 数组个数 k取余
            int m = grid.length, n = grid[0].length, mn = m * n;
            k = k % mn;
            //翻转最后k个数
            reverse(grid, mn - k, mn - 1);
            //翻转前面
            reverse(grid, 0, mn - k - 1);
            //翻转整个
            reverse(grid, 0, mn - 1);
            //转化为List
            List<List<Integer>> res = new ArrayList<>();
            for (int[] row : grid) {
                List<Integer> rowList = new ArrayList<>();
                for (int e : row) {
                    rowList.add(e);
                }
                res.add(rowList);
            }
            return res;
        }
        //get方法 通过一维数组访问二维数组
        int get(int[][] grid, int index) {
            int n = grid[0].length;
            int i = index / n, j = index % n;
            return grid[i][j];
        }
        //set方法 通过一维数组修改二维数组
        void set(int[][] grid, int index, int value) {
            int n = grid[0].length;
            int i = index / n, j = index % n;
            grid[i][j] = value;
        }
        //翻转数组
        void reverse(int[][] grid, int i, int j) {
            while (i < j) {
                int temp = get(grid, i);
                set(grid, i, get(grid, j));
                set(grid, j , temp);
                i++;
                j--;
            }
        }
    }
    class Solution1 {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            //定义长 宽 数组个数 k取余
            int m = grid.length, n = grid[0].length;
            int mn = m * n;
            k = k % mn;
            //翻转最后k个数
            reverse(grid, mn - k, mn - 1);
            //翻转前面
            reverse(grid, 0, mn - k - 1);
            //翻转整个
            reverse(grid, 0, mn - 1);

            //转化为List
            List<List<Integer>> res = new ArrayList<>();
            for (int[] row : grid) {
                List<Integer> rowList = new ArrayList<>();
                for (int e : row) {
                    rowList.add(e);
                }
                res.add(rowList);
            }
            return res;
        }
        //get方法 通过一维数组访问二维数组
        int get(int[][] grid, int index) {
            int n = grid[0].length;
            int i = index / n, j = index % n;
            return grid[i][j];
        }
        //set方法 通过一维数组修改二维数组
        void set(int[][] grid, int index, int val) {
            int n = grid[0].length;
            int i = index / n, j = index % n;
            grid[i][j] = val;
        }
        //翻转数组
        void reverse(int[][] grid, int i, int j) {
            while (i < j) {
                int temp = get(grid, i);
                set(grid, i, get(grid, j));
                set(grid, j, temp);
                i++;
                j--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new Shift2dGrid().new Solution();
        // put your test code here
        
    }
}