package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.ArrayTwoPointerExercises;

import java.util.*;

public class SortTheMatrixDiagonally {


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] diagonalSort(int[][] mat) {
            // 获取矩阵的行数 m 和列数 n
            // 请填写代码
            int m = mat.length, n = mat[0].length;
            // 创建一个哈希表，用于存储每条对角线的元素
            // key: 对角线的 ID（用 i - j 表示）
            // value: 存储该对角线上所有元素的动态数组（ArrayList）
            // 请填写代码
            HashMap<Integer, ArrayList<Integer>> diagonals = new HashMap<>();
            // 第一次遍历：收集每条对角线上的所有元素
            // 请填写外层循环（遍历每一行）
            for (int i = 0; i < m; i++)
            {
                // 请填写内层循环（遍历每一列）
                for (int j = 0; j < n; j++)
                {
                    // 计算当前元素 (i, j) 所在的对角线编号
                    // 请填写代码
                    int diagonalID = i - j;
                    // 如果哈希表中还没有这个 diagonalID 对应的列表，就创建一个
                    // 请填写代码
                    diagonals.putIfAbsent(diagonalID, new ArrayList<>());
                    // 把当前元素 mat[i][j] 添加到该对角线的列表中
                    // 请填写代码
                    diagonals.get(diagonalID).add(mat[i][j]);
                }
            }

            // 第二次处理：对每条对角线上的元素进行排序（降序）
            // 请填写循环：遍历哈希表中所有的对角线列表
            for(List<Integer> diagonal: diagonals.values())
            {
                // 对每条对角线的元素进行降序排序
                // 请填写代码
                Collections.sort(diagonal, Collections.reverseOrder());
            }

            // 第三次遍历：把排序后的元素重新填回原矩阵
            // 请填写外层循环（遍历每一行）
            for (int i = 0; i < m; i++)
            {
                // 请填写内层循环（遍历每一列）
                for (int j = 0; j < n; j++)
                {
                    // 找到当前 (i, j) 属于哪条对角线
                    // 请填写代码
                    ArrayList<Integer> diagonal = diagonals.get(i - j);
                    // 从哈希表中取出这条对角线对应的元素列表
                    // 请填写代码
                    // 取出列表中最后一个元素（最小值），并从列表中删除它
                    // 请填写代码
                    mat[i][j] = diagonal.remove(diagonal.size() -1 );
                }
            }

            // 返回已经按对角线排序好的矩阵
            // 请填写代码
            return mat;
        }
    }
    class Solution1 {
        public int[][] diagonalSort(int[][] mat) {
            //定义矩阵长宽
            int m = mat.length, n = mat[0].length;
            //HashMap一个diagonals
            HashMap<Integer, ArrayList<Integer>> diagonals = new HashMap<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int diagonalID = i - j;
                    //如歌这个ID没有对应list就创建一个新的
                    diagonals.putIfAbsent(diagonalID, new ArrayList<>());
                    //把元素加入对应对角线list
                    diagonals.get(diagonalID).add(mat[i][j]);
                }
            }
            for (List<Integer> diagonal: diagonals.values()) {
                Collections.sort(diagonal, Collections.reverseOrder());
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ArrayList<Integer> diagonal = diagonals.get(i - j);
                    mat[i][j] = diagonal.remove(diagonal.size() - 1);
                }
            }
            return mat;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SortTheMatrixDiagonally().new Solution();
        // put your test code here
        
    }
}