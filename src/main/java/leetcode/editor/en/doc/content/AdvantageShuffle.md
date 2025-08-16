<p>You are given two integer arrays <code>nums1</code> and <code>nums2</code> both of the same length. The <strong>advantage</strong> of <code>nums1</code> with respect to <code>nums2</code> is the number of indices <code>i</code> for which <code>nums1[i] &gt; nums2[i]</code>.</p>

<p>Return <em>any permutation of </em><code>nums1</code><em> that maximizes its <strong>advantage</strong> with respect to </em><code>nums2</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<pre><strong>Input:</strong> nums1 = [2,7,11,15], nums2 = [1,10,4,11]
<strong>Output:</strong> [2,11,7,15]
</pre>
<p><strong class="example">Example 2:</strong></p> 
<pre><strong>Input:</strong> nums1 = [12,24,8,32], nums2 = [13,25,32,11]
<strong>Output:</strong> [24,32,8,12]
</pre> 
<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums1.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>nums2.length == nums1.length</code></li> 
 <li><code>0 &lt;= nums1[i], nums2[i] &lt;= 10<sup>9</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Two Pointers | Greedy | Sorting</details><br>

<div>👍 1662, 👎 100<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/practice-in-action/advantage-shuffle/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题就像田忌赛马的情景，`nums1` 就是田忌的马，`nums2` 就是齐王的马，数组中的元素就是马的战斗力，你就是谋士孙膑，请你帮田忌安排赛马顺序，使胜场最多。

最优策略是将齐王和田忌的马按照战斗力排序，然后按照战斗力排名一一对比：

如果田忌的马能赢，那就比赛，如果赢不了，那就换个垫底的来送人头，保存实力。

具体分析见详细题解。

**详细题解**：
  - [田忌赛马背后的算法决策](https://labuladong.online/algo/practice-in-action/advantage-shuffle/)
  - [【练习】优先级队列经典习题](https://labuladong.online/algo/problem-set/binary-heap/)

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
#include <queue>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<int> advantageCount(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size();
        // 给 nums2 降序排序
        priority_queue<pair<int, int>, vector<pair<int, int>>, less<>> maxpq;
        for (int i = 0; i < n; i++) {
            maxpq.push({nums2[i], i});
        }
        // 给 nums1 升序排序
        sort(nums1.begin(), nums1.end());

        // nums1[left] 是最小值，nums1[right] 是最大值
        int left = 0, right = n - 1;
        vector<int> res(n);

        while (!maxpq.empty()) {
            auto pair = maxpq.top();
            maxpq.pop();
            // maxval 是 nums2 中的最大值，i 是对应索引
            int i = pair.second, maxval = pair.first;
            if (maxval < nums1[right]) {
                // 如果 nums1[right] 能胜过 maxval，那就自己上
                res[i] = nums1[right];
                right--;
            } else {
                // 否则用最小值混一下，养精蓄锐
                res[i] = nums1[left];
                left++;
            }
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

class Solution:
    def advantageCount(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n = len(nums1)
        # 给 nums2 降序排序
        indexed_nums2 = [(value, index) for index, value in enumerate(nums2)]
        indexed_nums2.sort(key=lambda x: x[0], reverse=True)
        
        # 给 nums1 升序排序
        nums1_sorted = sorted(nums1)

        # nums1[left] 是最小值，nums1[right] 是最大值
        left, right = 0, n - 1
        result = [0] * n

        for value, index in indexed_nums2:
            # maxval 是 nums2 中的最大值，i 是对应索引
            maxval = value
            i = index
            if nums1_sorted[right] > maxval:
                # 如果 nums1[right] 能胜过 maxval，那就自己上
                result[i] = nums1_sorted[right]
                right -= 1
            else:
                # 否则用最小值混一下，养精蓄锐
                result[i] = nums1_sorted[left]
                left += 1
                
        return result
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // 给 nums2 降序排序
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(
                (int[] pair1, int[] pair2) -> {
                    return pair2[1] - pair1[1];
                }
        );
        for (int i = 0; i < n; i++) {
            maxpq.offer(new int[]{i, nums2[i]});
        }
        // 给 nums1 升序排序
        Arrays.sort(nums1);

        // nums1[left] 是最小值，nums1[right] 是最大值
        int left = 0, right = n - 1;
        int[] res = new int[n];

        while (!maxpq.isEmpty()) {
            int[] pair = maxpq.poll();
            // maxval 是 nums2 中的最大值，i 是对应索引
            int i = pair[0], maxval = pair[1];
            if (maxval < nums1[right]) {
                // 如果 nums1[right] 能胜过 maxval，那就自己上
                res[i] = nums1[right];
                right--;
            } else {
                // 否则用最小值混一下，养精蓄锐
                res[i] = nums1[left];
                left++;
            }
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

type pair struct {
    first  int
    second int
}

type IntSlice []int

func (s IntSlice) Len() int           { return len(s) }
func (s IntSlice) Less(i, j int) bool { return s[i] < s[j] }
func (s IntSlice) Swap(i, j int)      { s[i], s[j] = s[j], s[i] }

func advantageCount(nums1 []int, nums2 []int) []int {
    n := len(nums1)
    // 给 nums2 降序排序
    maxpq := &pairHeap{}
    for i, v := range nums2 {
        heap.Push(maxpq, pair{i, v})
    }
    
    // 给 nums1 升序排序
    sort.Ints(nums1)

    // nums1[left] 是最小值，nums1[right] 是最大值
    left, right := 0, n-1
    res := make([]int, n)

    for maxpq.Len() > 0 {
        val := heap.Pop(maxpq).(pair)
        // maxval 是 nums2 中的最大值，i 是对应索引
        i, maxval := val.first, val.second
        if maxval < nums1[right] {
            // 如果 nums1[right] 能胜过 maxval，那就自己上
            res[i] = nums1[right]
            right--
        } else {
            // 否则用最小值混一下，养精蓄锐
            res[i] = nums1[left]
            left++
        }
    }
    return res
}

type pairHeap []pair

func (h pairHeap) Len() int            { return len(h) }
func (h pairHeap) Less(i, j int) bool  { return h[i].second > h[j].second }
func (h pairHeap) Swap(i, j int)       { h[i], h[j] = h[j], h[i] }
func (h *pairHeap) Push(x interface{}) { *h = append(*h, x.(pair)) }
func (h *pairHeap) Pop() interface{} {
    old := *h
    n := len(old)
    x := old[n-1]
    *h = old[0 : n-1]
    return x
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var advantageCount = function(nums1, nums2) {
    let n = nums1.length;
    // 给 nums2 降序排序
    let maxpq = new CustomPriorityQueue((pair1, pair2) => {
        return pair2[1] - pair1[1];
    });
    for (let i = 0; i < n; i++) {
        maxpq.offer([i, nums2[i]]);
    }
    // 给 nums1 升序排序
    nums1.sort((a, b) => a - b);

    // nums1[left] 是最小值，nums1[right] 是最大值
    let left = 0, right = n - 1;
    let res = new Array(n);

    while (!maxpq.isEmpty()) {
        let pair = maxpq.poll();
        // maxval 是 nums2 中的最大值，i 是对应索引
        let i = pair[0], maxval = pair[1];
        if (maxval < nums1[right]) {
            // 如果 nums1[right] 能胜过 maxval，那就自己上
            res[i] = nums1[right];
            right--;
        } else {
            // 否则用最小值混一下，养精蓄锐
            res[i] = nums1[left];
            left++;
        }
    }
    return res;
};

// CustomPriorityQueue implementation in JavaScript
class CustomPriorityQueue {
    constructor(comparator = (a, b) => a - b) {
        this._heap = [];
        this._comparator = comparator;
    }
    size() {
        return this._heap.length;
    }
    isEmpty() {
        return this.size() === 0;
    }
    peek() {
        return this._heap[0];
    }
    offer(value) {
        this._heap.push(value);
        this._siftUp();
    }
    poll() {
        const poppedValue = this.peek();
        const bottom = this.size() - 1;
        if (bottom > 0) {
            this._swap(0, bottom);
        }
        this._heap.pop();
        this._siftDown();
        return poppedValue;
    }
    _greater(i, j) {
        return this._comparator(this._heap[i], this._heap[j]) < 0;
    }
    _swap(i, j) {
        [this._heap[i], this._heap[j]] = [this._heap[j], this._heap[i]];
    }
    _siftUp() {
        let node = this.size() - 1;
        while (node > 0 && this._greater(node, Math.floor((node - 1) / 2))) {
            this._swap(node, Math.floor((node - 1) / 2));
            node = Math.floor((node - 1) / 2);
        }
    }
    _siftDown() {
        let node = 0;
        while (
            (node * 2 + 1 < this.size() && this._greater(node * 2 + 1, node)) ||
            (node * 2 + 2 < this.size() && this._greater(node * 2 + 2, node))
        ) {
            let maxChild = (node * 2 + 2 < this.size() && this._greater(node * 2 + 2, node * 2 + 1)) ? node * 2 + 2 : node * 2 + 1;
            this._swap(node, maxChild);
            node = maxChild;
        }
    }
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_advantage-shuffle"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_advantage-shuffle"></div></div>
</details><hr /><br />

</div>
</details>
</div>

