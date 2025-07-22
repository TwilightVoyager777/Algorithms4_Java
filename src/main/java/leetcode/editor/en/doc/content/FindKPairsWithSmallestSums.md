<p>You are given two integer arrays <code>nums1</code> and <code>nums2</code> sorted in <strong>non-decreasing&nbsp;order</strong> and an integer <code>k</code>.</p>

<p>Define a pair <code>(u, v)</code> which consists of one element from the first array and one element from the second array.</p>

<p>Return <em>the</em> <code>k</code> <em>pairs</em> <code>(u<sub>1</sub>, v<sub>1</sub>), (u<sub>2</sub>, v<sub>2</sub>), ..., (u<sub>k</sub>, v<sub>k</sub>)</code> <em>with the smallest sums</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [1,7,11], nums2 = [2,4,6], k = 3
<strong>Output:</strong> [[1,2],[1,4],[1,6]]
<strong>Explanation:</strong> The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [1,1,2], nums2 = [1,2,3], k = 2
<strong>Output:</strong> [[1,1],[1,1]]
<strong>Explanation:</strong> The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums1.length, nums2.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>-10<sup>9</sup> &lt;= nums1[i], nums2[i] &lt;= 10<sup>9</sup></code></li> 
 <li><code>nums1</code> and <code>nums2</code> both are sorted in <strong>non-decreasing order</strong>.</li> 
 <li><code>1 &lt;= k &lt;= 10<sup>4</sup></code></li> 
 <li><code>k &lt;=&nbsp;nums1.length *&nbsp;nums2.length</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Heap (Priority Queue)</details><br>

<div>👍 6662, 👎 476<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题其实是前文 [单链表的六大解题套路](https://labuladong.online/algo/essential-technique/linked-list-skills-summary/) 中讲过的 [✔ ✨23. 合并K个升序链表](/problems/merge-k-sorted-lists/) 的变体。

怎么把这道题变成合并多个有序链表呢？就比如说题目输入的用例：

```java
nums1 = [1,7,11], nums2 = [2,4,6]
```

组合出的所有数对儿这就可以抽象成三个有序链表：

```java
[1, 2] -> [1, 4] -> [1, 6]
[7, 2] -> [7, 4] -> [7, 6]
[11, 2] -> [11, 4] -> [11, 6]
```

这三个链表中每个元素（数对之和）是递增的，所以就可以按照 [✔ ✨23. 合并K个升序链表](/problems/merge-k-sorted-lists/) 的思路来合并，取出前 `k` 个作为答案即可。

**详细题解**：
  - [【练习】优先级队列经典习题](https://labuladong.online/algo/problem-set/binary-heap/)
  - [【练习】链表双指针经典习题](https://labuladong.online/algo/problem-set/linkedlist-two-pointers/)

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
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        // 存储三元组 (num1[i], nums2[i], i)
        // i 记录 nums2 元素的索引位置，用于生成下一个节点
        auto cmp = [](const vector<int>& a, const vector<int>& b) {
            // 按照数对的元素和升序排序
            return (a[0] + a[1]) > (b[0] + b[1]);
        };
        priority_queue<vector<int>, vector<vector<int>>, decltype(cmp)> pq(cmp);
        
        // 按照 23 题的逻辑初始化优先级队列
        for (int i = 0; i < nums1.size(); i++) {
            pq.push({nums1[i], nums2[0], 0});
        }

        vector<vector<int>> res;
        // 执行合并多个有序链表的逻辑
        while (!pq.empty() && k > 0) {
            vector<int> cur = pq.top();
            pq.pop();
            k--;
            // 链表中的下一个节点加入优先级队列
            int next_index = cur[2] + 1;
            if (next_index < nums2.size()) {
                pq.push({cur[0], nums2[next_index], next_index});
            }

            res.push_back({cur[0], cur[1]});
        }
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

from queue import PriorityQueue

class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        # 存储三元组 (num1[i], nums2[i], i)
        # i 记录 nums2 元素的索引位置，用于生成下一个节点
        pq = PriorityQueue()
        
        # 按照 23 题的逻辑初始化优先级队列
        for i in range(len(nums1)):
            pq.put((nums1[i] + nums2[0], nums1[i], nums2[0], 0))

        res = []
        # 执行合并多个有序链表的逻辑
        while not pq.empty() and k > 0:
            _, num1, num2, idx = pq.get()
            k -= 1
            # 链表中的下一个节点加入优先级队列
            next_index = idx + 1
            if next_index < len(nums2):
                pq.put((num1 + nums2[next_index], num1, nums2[next_index], next_index))

            # 按照数对的元素和升序排序
            pair = [num1, num2]
            res.append(pair)

        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 存储三元组 (num1[i], nums2[i], i)
        // i 记录 nums2 元素的索引位置，用于生成下一个节点
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // 按照数对的元素和升序排序
            return (a[0] + a[1]) - (b[0] + b[1]);
        });
        // 按照 23 题的逻辑初始化优先级队列
        for (int i = 0; i < nums1.length; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        List<List<Integer>> res = new ArrayList<>();
        // 执行合并多个有序链表的逻辑
        while (!pq.isEmpty() && k > 0) {
            int[] cur = pq.poll();
            k--;
            // 链表中的下一个节点加入优先级队列
            int next_index = cur[2] + 1;
            if (next_index < nums2.length) {
                pq.add(new int[]{cur[0], nums2[next_index], next_index});
            }

            List<Integer> pair = new ArrayList<>();
            pair.add(cur[0]);
            pair.add(cur[1]);
            res.add(pair);
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func kSmallestPairs(nums1 []int, nums2 []int, k int) [][]int {
    // 存储三元组 (num1[i], nums2[i], i)
    // i 记录 nums2 元素的索引位置，用于生成下一个节点
    pq := &PriorityQueue{}
    heap.Init(pq)
    
    // 按照 23 题的逻辑初始化优先级队列
    for i := 0; i < len(nums1); i++ {
        heap.Push(pq, []int{nums1[i], nums2[0], 0})
    }

    res := [][]int{}
    // 执行合并多个有序链表的逻辑
    for pq.Len() > 0 && k > 0 {
        cur := heap.Pop(pq).([]int)
        k--
        // 链表中的下一个节点加入优先级队列
        nextIndex := cur[2] + 1
        if nextIndex < len(nums2) {
            heap.Push(pq, []int{cur[0], nums2[nextIndex], nextIndex})
        }

        res = append(res, []int{cur[0], cur[1]})
    }
    return res
}

// PriorityQueue implements heap.Interface and holds Items.
type PriorityQueue [][]int

func (pq PriorityQueue) Len() int { return len(pq) }

func (pq PriorityQueue) Less(i, j int) bool {
    // 按照数对的元素和升序排序
    return (pq[i][0] + pq[i][1]) < (pq[j][0] + pq[j][1])
}

func (pq PriorityQueue) Swap(i, j int) {
    pq[i], pq[j] = pq[j], pq[i]
}

func (pq *PriorityQueue) Push(x interface{}) {
    *pq = append(*pq, x.([]int))
}

func (pq *PriorityQueue) Pop() interface{} {
    old := *pq
    n := len(old)
    item := old[n-1]
    *pq = old[0 : n-1]
    return item
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var kSmallestPairs = function(nums1, nums2, k) {
    // 存储三元组 (num1[i], nums2[i], i)
    // i 记录 nums2 元素的索引位置，用于生成下一个节点
    let pq = new PriorityQueue((a, b) => {
        // 按照数对的元素和升序排序
        return (a[0] + a[1]) - (b[0] + b[1]);
    });

    // 按照 23 题的逻辑初始化优先级队列
    for (let i = 0; i < nums1.length; i++) {
        pq.enqueue([nums1[i], nums2[0], 0]);
    }

    let res = [];
    // 执行合并多个有序链表的逻辑
    while (!pq.isEmpty() && k > 0) {
        let cur = pq.dequeue();
        k--;
        // 链表中的下一个节点加入优先级队列
        let next_index = cur[2] + 1;
        if (next_index < nums2.length) {
            pq.enqueue([cur[0], nums2[next_index], next_index]);
        }

        let pair = [cur[0], cur[1]];
        res.push(pair);
    }
    return res;
};
```

</div></div>
</div></div>

</div>
</details>
</div>

