<p>You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: <code>'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'</code>. The wheels can rotate freely and wrap around: for example we can turn <code>'9'</code> to be <code>'0'</code>, or <code>'0'</code> to be <code>'9'</code>. Each move consists of turning one wheel one slot.</p>

<p>The lock initially starts at <code>'0000'</code>, a string representing the state of the 4 wheels.</p>

<p>You are given a list of <code>deadends</code> dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.</p>

<p>Given a <code>target</code> representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> deadends = ["0201","0101","0102","1212","2002"], target = "0202"
<strong>Output:</strong> 6
<strong>Explanation:</strong> 
A sequence of valid moves would be "0000" -&gt; "1000" -&gt; "1100" -&gt; "1200" -&gt; "1201" -&gt; "1202" -&gt; "0202".
Note that a sequence like "0000" -&gt; "0001" -&gt; "0002" -&gt; "0102" -&gt; "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> deadends = ["8888"], target = "0009"
<strong>Output:</strong> 1
<strong>Explanation:</strong> We can turn the last wheel in reverse to move from "0000" -&gt; "0009".
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
<strong>Output:</strong> -1
<strong>Explanation:</strong> We cannot reach the target without getting stuck.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= deadends.length &lt;= 500</code></li> 
 <li><code>deadends[i].length == 4</code></li> 
 <li><code>target.length == 4</code></li> 
 <li>target <strong>will not be</strong> in the list <code>deadends</code>.</li> 
 <li><code>target</code> and <code>deadends[i]</code> consist of digits only.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Hash Table | String | Breadth-First Search</details><br>

<div>👍 4972, 👎 227<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/bfs-framework/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

本质上就是穷举，在避开 `deadends` 密码的前提下，对四位密码的每一位进行 0~9 的穷举。

根据 BFS 算法的性质，第一次拨出 `target` 时的旋转次数就是最少的，直接套 [BFS 算法框架](https://labuladong.online/algo/essential-technique/bfs-framework/) 即可。

另外，针对这道题的场景，还可以使用「双向 BFS」技巧进行优化，见详细题解。

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

class Solution {
public:
    int openLock(vector<string>& deadends, string target) {
        unordered_set<string> deads(deadends.begin(), deadends.end());
        
        // base case
        if (deads.count("0000")) return -1;
        if (target == "0000") return 0;

        // 用集合不用队列，可以快速判断元素是否存在
        unordered_set<string> q1;
        unordered_set<string> q2;
        unordered_set<string> visited;

        int step = 0;
        q1.insert("0000");
        visited.insert("0000");
        q2.insert(target);
        visited.insert(target);

        while (!q1.empty() && !q2.empty()) {/**<extend down -200>![](https://labuladong.online/algo/images/bfs/2.jpeg) */

            // 在这里增加步数
            step++;

            // 哈希集合在遍历的过程中不能修改，所以用 newQ1 存储邻居节点
            unordered_set<string> newQ1;

            // 获取 q1 中的所有节点的邻居
            for (const string& cur : q1) {
                // 将一个节点的未遍历相邻节点加入集合
                for (const string& neighbor : getNeighbors(cur)) {
                    // 判断是否到达终点
                    if (q2.count(neighbor)) {
                        return step;
                    }
                    if (!visited.count(neighbor) && !deads.count(neighbor)) {
                        newQ1.insert(neighbor);
                        visited.insert(neighbor);
                    }
                }
            }
            // newQ1 存储着 q1 的邻居节点
            q1 = newQ1;
            // 因为每次 BFS 都是扩散 q1，所以把元素数量少的集合作为 q1
            if (q1.size() > q2.size()) {
                swap(q1, q2);
            }
        }
        return -1;
    }

    // 将 s[j] 向上拨动一次
    string plusOne(string s, int j) {
        if (s[j] == '9')
            s[j] = '0';
        else
            s[j] += 1;
        return s;
    }

    // 将 s[i] 向下拨动一次
    string minusOne(string s, int j) {
        if (s[j] == '0')
            s[j] = '9';
        else
            s[j] -= 1;
        return s;
    }

    vector<string> getNeighbors(string s) {
        vector<string> neighbors;
        for (int i = 0; i < 4; i++) {
            neighbors.push_back(plusOne(s, i));
            neighbors.push_back(minusOne(s, i));
        }
        return neighbors;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        deads = set(deadends)
        # base case
        if "0000" in deads: return -1
        if target == "0000": return 0

        # 用集合不用队列，可以快速判断元素是否存在
        q1 = set()
        q2 = set()
        visited = set()
        
        step = 0
        q1.add("0000")
        visited.add("0000")
        q2.add(target)
        visited.add(target)

        while q1 and q2: # <extend down -200>![](https://labuladong.online/algo/images/bfs/2.jpeg) #
            # 在这里增加步数
            step += 1

            # 哈希集合在遍历的过程中不能修改，所以用 newQ1 存储邻居节点
            newQ1 = set()

            # 获取 q1 中的所有节点的邻居
            for cur in q1:
                # 将一个节点的未遍历相邻节点加入集合
                for neighbor in self.getNeighbors(cur):
                    # 判断是否到达终点
                    if neighbor in q2:
                        return step
                    if neighbor not in visited and neighbor not in deads:
                        newQ1.add(neighbor)
                        visited.add(neighbor)
            # newQ1 存储着 q1 的邻居节点
            q1 = newQ1
            # 因为每次 BFS 都是扩散 q1，所以把元素数量少的集合作为 q1
            if len(q1) > len(q2):
                q1, q2 = q2, q1
        return -1

    # 将 s[j] 向上拨动一次
    def plusOne(self, s: str, j: int) -> str:
        ch = list(s)
        if ch[j] == '9':
            ch[j] = '0'
        else:
            ch[j] = str(int(ch[j]) + 1)
        return ''.join(ch)

    # 将 s[i] 向下拨动一次
    def minusOne(self, s: str, j: int) -> str:
        ch = list(s)
        if ch[j] == '0':
            ch[j] = '9'
        else:
            ch[j] = str(int(ch[j]) - 1)
        return ''.join(ch)

    def getNeighbors(self, s: str) -> List[str]:
        neighbors = []
        for i in range(4):
            neighbors.append(self.plusOne(s, i))
            neighbors.append(self.minusOne(s, i))
        return neighbors
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);
        // base case
        if (deads.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        // 用集合不用队列，可以快速判断元素是否存在
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        
        int step = 0;
        q1.add("0000");
        visited.add("0000");
        q2.add(target);
        visited.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {/**<extend down -200>![](https://labuladong.online/algo/images/bfs/2.jpeg) */
            // 在这里增加步数
            step++;

            // 哈希集合在遍历的过程中不能修改，所以用 newQ1 存储邻居节点
            Set<String> newQ1 = new HashSet<>();

            // 获取 q1 中的所有节点的邻居
            for (String cur : q1) {
                // 将一个节点的未遍历相邻节点加入集合
                for (String neighbor : getNeighbors(cur)) {
                    // 判断是否到达终点
                    if (q2.contains(neighbor)) {
                        return step;
                    }
                    if (!visited.contains(neighbor) && !deads.contains(neighbor)) {
                        newQ1.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            // newQ1 存储着 q1 的邻居节点
            q1 = newQ1;
            // 因为每次 BFS 都是扩散 q1，所以把元素数量少的集合作为 q1
            if (q1.size() > q2.size()) {
                Set<String> temp = q1;
                q1 = q2;
                q2 = temp;
            }
        }
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

    List<String> getNeighbors(String s) {
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            neighbors.add(plusOne(s, i));
            neighbors.add(minusOne(s, i));
        }
        return neighbors;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func openLock(deadends []string, target string) int {
    deads := make(map[string]struct{})
    for _, s := range deadends {
        deads[s] = struct{}{}
    }
    // base case
    if _, found := deads["0000"]; found {
        return -1
    }
    if target == "0000" {
        return 0
    }

    // 用集合不用队列，可以快速判断元素是否存在
    q1 := make(map[string]struct{})
    q2 := make(map[string]struct{})
    visited := make(map[string]struct{})

    step := 0
    q1["0000"] = struct{}{}
    visited["0000"] = struct{}{}
    q2[target] = struct{}{}
    visited[target] = struct{}{}

    for len(q1) != 0 && len(q2) != 0 {
        // 在这里增加步数
        step++

        // 哈希集合在遍历的过程中不能修改，所以用 newQ1 存储邻居节点
        newQ1 := make(map[string]struct{})

        // 获取 q1 中的所有节点的邻居
        for cur := range q1 {
            // 将一个节点的未遍历相邻节点加入集合
            for _, neighbor := range getNeighbors(cur) {
                // 判断是否到达终点
                if _, found := q2[neighbor]; found {
                    return step
                }
                if _, found := visited[neighbor]; !found {
                    if _, found := deads[neighbor]; !found {
                        newQ1[neighbor] = struct{}{}
                        visited[neighbor] = struct{}{}
                    }
                }
            }
        }
        // newQ1 存储着 q1 的邻居节点
        q1 = newQ1
        // 因为每次 BFS 都是扩散 q1，所以把元素数量少的集合作为 q1
        if len(q1) > len(q2) {
            q1, q2 = q2, q1
        }
    }
    return -1
}

// 将 s[j] 向上拨动一次
func plusOne(s string, j int) string {
    ch := []rune(s)
    if ch[j] == '9' {
        ch[j] = '0'
    } else {
        ch[j]++
    }
    return string(ch)
}

// 将 s[i] 向下拨动一次
func minusOne(s string, j int) string {
    ch := []rune(s)
    if ch[j] == '0' {
        ch[j] = '9'
    } else {
        ch[j]--
    }
    return string(ch)
}

func getNeighbors(s string) []string {
    neighbors := []string{}
    for i := 0; i < 4; i++ {
        neighbors = append(neighbors, plusOne(s, i))
        neighbors = append(neighbors, minusOne(s, i))
    }
    return neighbors
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var openLock = function(deadends, target) {
    let deads = new Set(deadends);
    // base case
    if (deads.has("0000")) return -1;
    if (target === "0000") return 0;

    // 用集合不用队列，可以快速判断元素是否存在
    let q1 = new Set();
    let q2 = new Set();
    let visited = new Set();

    let step = 0;
    q1.add("0000");
    visited.add("0000");
    q2.add(target);
    visited.add(target);

    while (q1.size && q2.size) {
        // 在这里增加步数
        step++;

        // 哈希集合在遍历的过程中不能修改，所以用 newQ1 存储邻居节点
        let newQ1 = new Set();

        // 获取 q1 中的所有节点的邻居
        for (let cur of q1) {
            // 将一个节点的未遍历相邻节点加入集合
            for (let neighbor of getNeighbors(cur)) {
                // 判断是否到达终点
                if (q2.has(neighbor)) {
                    return step;
                }
                if (!visited.has(neighbor) && !deads.has(neighbor)) {
                    newQ1.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        // newQ1 存储着 q1 的邻居节点
        q1 = newQ1;
        // 因为每次 BFS 都是扩散 q1，所以把元素数量少的集合作为 q1
        if (q1.size > q2.size) {
            let temp = q1;
            q1 = q2;
            q2 = temp;
        }
    }
    return -1;
};

// 将 s[j] 向上拨动一次
function plusOne(s, j) {
    let ch = s.split('');
    if (ch[j] === '9')
        ch[j] = '0';
    else
        ch[j] = (parseInt(ch[j]) + 1).toString();
    return ch.join('');
}

// 将 s[i] 向下拨动一次
function minusOne(s, j) {
    let ch = s.split('');
    if (ch[j] === '0')
        ch[j] = '9';
    else
        ch[j] = (parseInt(ch[j]) - 1).toString();
    return ch.join('');
}

function getNeighbors(s) {
    let neighbors = [];
    for (let i = 0; i < 4; i++) {
        neighbors.push(plusOne(s, i));
        neighbors.push(minusOne(s, i));
    }
    return neighbors;
}
```

</div></div>
</div></div>

</div>
</details>
</div>



