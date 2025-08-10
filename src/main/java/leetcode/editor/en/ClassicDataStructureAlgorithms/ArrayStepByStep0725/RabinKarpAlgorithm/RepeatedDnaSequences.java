package leetcode.editor.en.ClassicDataStructureAlgorithms.ArrayStepByStep0725.RabinKarpAlgorithm;

import java.util.*;

public class RepeatedDnaSequences {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            //新建一个数组nums 把原来的s的字符串转化成四进制数字数组
            int[] nums = new int[s.length()];
            //开始s的字符串遍历 从i=0开始 A C G T分别转为0 1 2 3四进制形式
            for (int i = 0; i < nums.length; i++) {
                switch(s.charAt(i)) {
                    case 'A' :
                        nums[i] = 0;
                        break;
                    case 'C' :
                        nums[i] = 1;
                        break;
                    case 'G' :
                        nums[i] = 2;
                        break;
                    case 'T' :
                        nums[i] = 3;
                        break;
                }
            }
            //记录重复出现的哈希值
            HashSet<Integer> seen = new HashSet<>();
            //记录重复出现的字符串结果
            HashSet<String> res = new HashSet<>();
            //L为数字几位数 R位几进制
            int L = 10, R = 4;
            //RL为存储结果
            int RL = (int) Math.pow(R, L - 1);
            //维护滑动窗口内字符串哈希值
            int windowHash = 0;

            //滑动窗口代码框架
            int left = 0, right = 0;
            while (right < nums.length) {
                //移入数字 更新windowHash
                windowHash = R * windowHash + nums[right];
                //扩大窗口
                right++;
                //当子串符合要求长度
                if (right - left == L) {
                    //若windowHash在seen中以前出现过
                    if (seen.contains(windowHash)) {
                        //添加到res中
                        res.add(s.substring(left, right));
                    } else {
                        //若没出现过则记下来
                        seen.add(windowHash);
                    }
                    //移除数字 更新windowHash
                    windowHash = windowHash - nums[left] * RL;
                    //缩小窗口
                    left++;
                }
            }
            //返回res
            return new LinkedList<>(res);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RepeatedDnaSequences().new Solution();
        // put your test code here
        
    }
}