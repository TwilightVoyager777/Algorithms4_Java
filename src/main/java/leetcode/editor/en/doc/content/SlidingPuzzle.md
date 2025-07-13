<p>On an <code>2 x 3</code> board, there are five tiles labeled from <code>1</code> to <code>5</code>, and an empty square represented by <code>0</code>. A <strong>move</strong> consists of choosing <code>0</code> and a 4-directionally adjacent number and swapping it.</p>

<p>The state of the board is solved if and only if the board is <code>[[1,2,3],[4,5,0]]</code>.</p>

<p>Given the puzzle board <code>board</code>, return <em>the least number of moves required so that the state of the board is solved</em>. If it is impossible for the state of the board to be solved, return <code>-1</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/29/slide1-grid.jpg" style="width: 244px; height: 165px;" /> 
<pre>
<strong>Input:</strong> board = [[1,2,3],[4,0,5]]
<strong>Output:</strong> 1
<strong>Explanation:</strong> Swap the 0 and the 5 in one move.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/29/slide2-grid.jpg" style="width: 244px; height: 165px;" /> 
<pre>
<strong>Input:</strong> board = [[1,2,3],[5,4,0]]
<strong>Output:</strong> -1
<strong>Explanation:</strong> No number of moves will make the board solved.
</pre>

<p><strong class="example">Example 3:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/29/slide3-grid.jpg" style="width: 244px; height: 165px;" /> 
<pre>
<strong>Input:</strong> board = [[4,1,2],[5,0,3]]
<strong>Output:</strong> 5
<strong>Explanation:</strong> 5 is the smallest number of moves that solves the board.
An example path:
After move 0: [[4,1,2],[5,0,3]]
After move 1: [[4,1,2],[0,5,3]]
After move 2: [[0,1,2],[4,5,3]]
After move 3: [[1,0,2],[4,5,3]]
After move 4: [[1,2,0],[4,5,3]]
After move 5: [[1,2,3],[4,5,0]]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>board.length == 2</code></li> 
 <li><code>board[i].length == 3</code></li> 
 <li><code>0 &lt;= board[i][j] &lt;= 5</code></li> 
 <li>Each value <code>board[i][j]</code> is <strong>unique</strong>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Dynamic Programming | Backtracking | Breadth-First Search | Memoization | Matrix</details><br>

<div>👍 2689, 👎 72<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/bfs-framework/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题可以用 BFS 算法解决。BFS 算法并不只是一个寻路算法，而是一种暴力搜索算法，只要涉及暴力穷举的问题，BFS 就可以用，而且可以最快地穷举出答案，关于 BFS 算法原理可以看 [BFS 算法框架](https://labuladong.online/algo/essential-technique/bfs-framework/)。

**详细题解**：
  - [BFS 算法解题套路框架](https://labuladong.online/algo/essential-technique/bfs-framework/)

</div>





<div id="solution">

## 解法代码



<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

#include <vector>
#include <string>
#include <queue>
#include <unordered_set>
using namespace std;

class Solution {
public:
    int slidingPuzzle(vector<vector<int>>& board) {
        int m = 2, n = 3;
        string target = "123450";
        // 将 2x3 的数组转化成字符串作为 BFS 的起点
        string start;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start += to_string(board[i][j]);
            }
        }

        // 记录一维字符串的相邻索引
        vector<vector<int>> neighbor = {
            {1, 3},
            {0, 4, 2},
            {1, 5},
            {0, 4},
            {3, 1, 5},
            {4, 2}
        };

        // ****** BFS 算法框架开始 ******
        queue<string> q;
        unordered_set<string> visited;
        // 从起点开始 BFS 搜索
        q.push(start);
        visited.insert(start);

        int step = 0;
        while (!q.empty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                string cur = q.front();
                q.pop();
                // 判断是否达到目标局面
                if (target == cur) {
                    return step;
                }
                // 找到数字 0 的索引
                int idx = 0;
                for (; cur[idx] != '0'; idx++) ;
                // 将数字 0 和相邻的数字交换位置
                for (int adj : neighbor[idx]) {
                    string new_board = swap(cur, adj, idx);
                    // 防止走回头路
                    if (!visited.count(new_board)) {
                        q.push(new_board);
                        visited.insert(new_board);
                    }
                }
            }
            step++;
        }
        // ****** BFS 算法框架结束 ******
        return -1;
    }

private:
    // Helper function to swap characters in a string
    string swap(string s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        return s;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        m, n = 2, 3
        target = "123450"
        # 将 2x3 的数组转化成字符串作为 BFS 的起点
        start = ''.join(str(num) for row in board for num in row)

        # 记录一维字符串的相邻索引
        neighbor = [
            [1, 3],
            [0, 4, 2],
            [1, 5],
            [0, 4],
            [3, 1, 5],
            [4, 2]
        ]

        # ****** BFS 算法框架开始 ******
        q = deque([start])
        visited = set([start])

        # 从起点开始 BFS 搜索
        step = 0
        while q:
            sz = len(q)
            for _ in range(sz):
                cur = q.popleft()
                # 判断是否达到目标局面
                if target == cur:
                    return step
                # 找到数字 0 的索引
                idx = cur.index('0')
                # 将数字 0 和相邻的数字交换位置
                for adj in neighbor[idx]:
                    new_board = self.swap(list(cur), adj, idx)
                    # 防止走回头路
                    if new_board not in visited:
                        q.append(new_board)
                        visited.add(new_board)
            step += 1
        # ****** BFS 算法框架结束 ******
        return -1

    def swap(self, chars, i, j):
        chars[i], chars[j] = chars[j], chars[i]
        return ''.join(chars)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int slidingPuzzle(int[][] board) {
        int m = 2, n = 3;
        StringBuilder sb = new StringBuilder();
        String target = "123450";
        // 将 2x3 的数组转化成字符串作为 BFS 的起点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();

        // 记录一维字符串的相邻索引
        int[][] neighbor = new int[][]{
                {1, 3},
                {0, 4, 2},
                {1, 5},
                {0, 4},
                {3, 1, 5},
                {4, 2}
        };

        // ****** BFS 算法框架开始 ******
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        // 从起点开始 BFS 搜索
        q.offer(start);
        visited.add(start);

        int step = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                // 判断是否达到目标局面
                if (target.equals(cur)) {
                    return step;
                }
                // 找到数字 0 的索引
                int idx = 0;
                for (; cur.charAt(idx) != '0'; idx++) ;
                // 将数字 0 和相邻的数字交换位置
                for (int adj : neighbor[idx]) {
                    String new_board = swap(cur.toCharArray(), adj, idx);
                    // 防止走回头路
                    if (!visited.contains(new_board)) {
                        q.offer(new_board);
                        visited.add(new_board);
                    }
                }
            }
            step++;
        }
        // ****** BFS 算法框架结束 ******
        return -1;
    }

    private String swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func slidingPuzzle(board [][]int) int {
    m, n := 2, 3
    target := "123450"
    // 将 2x3 的数组转化成字符串作为 BFS 的起点
    start := ""
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            start += strconv.Itoa(board[i][j])
        }
    }

    // 记录一维字符串的相邻索引
    neighbor := [][]int{
        {1, 3},
        {0, 4, 2},
        {1, 5},
        {0, 4},
        {3, 1, 5},
        {4, 2},
    }

    // ****** BFS 算法框架开始 ******
    q := []string{start}
    visited := make(map[string]bool)
    visited[start] = true

    // 从起点开始 BFS 搜索
    step := 0
    for len(q) > 0 {
        sz := len(q)
        for i := 0; i < sz; i++ {
            cur := q[0]
            q = q[1:]
            // 判断是否达到目标局面
            if cur == target {
                return step
            }
            // 找到数字 0 的索引
            idx := 0
            for ; cur[idx] != '0'; idx++ {}
            // 将数字 0 和相邻的数字交换位置
            for _, adj := range neighbor[idx] {
                newBoard := swap(cur, adj, idx)
                // 防止走回头路
                if !visited[newBoard] {
                    q = append(q, newBoard)
                    visited[newBoard] = true
                }
            }
        }
        step++
    }
    // ****** BFS 算法框架结束 ******
    return -1
}

// Helper function to swap characters in a string at given indices
func swap(s string, i, j int) string {
    runes := []rune(s)
    runes[i], runes[j] = runes[j], runes[i]
    return string(runes)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var slidingPuzzle = function(board) {
    let m = 2, n = 3;
    let sb = [];
    let target = "123450";
    // 将 2x3 的数组转化成字符串作为 BFS 的起点
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            sb.push(board[i][j]);
        }
    }
    let start = sb.join('');

    // 记录一维字符串的相邻索引
    let neighbor = [
        [1, 3],
        [0, 4, 2],
        [1, 5],
        [0, 4],
        [3, 1, 5],
        [4, 2]
    ];

    // ****** BFS 算法框架开始 ******
    let q = [];
    let visited = new Set();
    // 从起点开始 BFS 搜索
    q.push(start);
    visited.add(start);

    let step = 0;
    while (q.length > 0) {
        let sz = q.length;
        for (let i = 0; i < sz; i++) {
            let cur = q.shift();
            // 判断是否达到目标局面
            if (target === cur) {
                return step;
            }
            // 找到数字 0 的索引
            let idx = 0;
            for (; cur.charAt(idx) !== '0'; idx++);
            // 将数字 0 和相邻的数字交换位置
            for (let adj of neighbor[idx]) {
                let new_board = swap(cur.split(''), adj, idx);
                // 防止走回头路
                if (!visited.has(new_board)) {
                    q.push(new_board);
                    visited.add(new_board);
                }
            }
        }
        step++;
    }
    // ****** BFS 算法框架结束 ******
    return -1;
};

var swap = function(chars, i, j) {
    let temp = chars[i];
    chars[i] = chars[j];
    chars[j] = temp;
    return chars.join('');
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_sliding-puzzle"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_sliding-puzzle"></div></div>
</details><hr /><br />

</div>
</details>
</div>

