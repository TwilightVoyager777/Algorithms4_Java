package leetcode.editor.en.CoreProblemSolvingFrameworks.BFSFramework0712;

import java.util.*;

public class OpenTheLock {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int openLock(String[] deadends, String target) {
            // 记录需要跳过的死亡密码
            Set<String> deads = new HashSet<>();
            for (String s : deadends) deads.add(s);
            if (deads.contains("0000")) return -1;

            // 记录已经穷举过的密码，防止走回头路
            Set<String> visited = new HashSet<>();
            Queue<String> q = new LinkedList<>();
            // 从起点开始启动广度优先搜索
            int step = 0;
            q.offer("0000");
            visited.add("0000");

            while (!q.isEmpty()) {
                int sz = q.size();
                // 将当前队列中的所有节点向周围扩散
                for (int i = 0; i < sz; i++) {
                    String cur = q.poll();

                    // 判断是否到达终点
                    if (cur.equals(target))
                        return step;

                    // 将一个节点的合法相邻节点加入队列
                    for (String neighbor : getNeighbors(cur)) {
                        if (!visited.contains(neighbor) && !deads.contains(neighbor)) {
                            q.offer(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
                // 在这里增加步数
                step++;
            }
            // 如果穷举完都没找到目标密码，那就是找不到了
            return -1;
        }

        // 将 s[j] 向上拨动一次
        String plusOne(String s, int j) {
            char[] ch = s.toCharArray();
            if (ch[j] == '9')
                ch[j] = '0';
            else
                ch[j] += 1;
            return new String(ch);
        }

        // 将 s[i] 向下拨动一次
        String minusOne(String s, int j) {
            char[] ch = s.toCharArray();
            if (ch[j] == '0')
                ch[j] = '9';
            else
                ch[j] -= 1;
            return new String(ch);
        }

        // 将 s 的每一位向上拨动一次或向下拨动一次，8 种相邻密码
        List<String> getNeighbors(String s) {
            List<String> neighbors = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                neighbors.add(plusOne(s, i));
                neighbors.add(minusOne(s, i));
            }
            return neighbors;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new OpenTheLock().new Solution();
        // put your test code here
        
    }
}