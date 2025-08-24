<p>There are <code>n</code> people standing in a queue, and they numbered from <code>0</code> to <code>n - 1</code> in <strong>left to right</strong> order. You are given an array <code>heights</code> of <strong>distinct</strong> integers where <code>heights[i]</code> represents the height of the <code>i<sup>th</sup></code> person.</p>

<p>A person can <strong>see</strong> another person to their right in the queue if everybody in between is <strong>shorter</strong> than both of them. More formally, the <code>i<sup>th</sup></code> person can see the <code>j<sup>th</sup></code> person if <code>i &lt; j</code> and <code>min(heights[i], heights[j]) &gt; max(heights[i+1], heights[i+2], ..., heights[j-1])</code>.</p>

<p>Return <em>an array </em><code>answer</code><em> of length </em><code>n</code><em> where </em><code>answer[i]</code><em> is the <strong>number of people</strong> the </em><code>i<sup>th</sup></code><em> person can <strong>see</strong> to their right in the queue</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/05/29/queue-plane.jpg" style="width: 600px; height: 247px;" /></p>

<pre>
<strong>Input:</strong> heights = [10,6,8,5,11,9]
<strong>Output:</strong> [3,1,2,1,1,0]
<strong>Explanation:</strong>
Person 0 can see person 1, 2, and 4.
Person 1 can see person 2.
Person 2 can see person 3 and 4.
Person 3 can see person 4.
Person 4 can see person 5.
Person 5 can see no one since nobody is to the right of them.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> heights = [5,1,2,3,10]
<strong>Output:</strong> [4,1,1,1,0]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>n == heights.length</code></li> 
 <li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li> 
 <li><code>1 &lt;= heights[i] &lt;= 10<sup>5</sup></code></li> 
 <li>All the values of <code>heights</code> are <strong>unique</strong>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Stack | Monotonic Stack</details><br>

<div>👍 2018, 👎 61<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题显然要用到 [单调栈技巧](https://labuladong.online/algo/data-structure/monotonic-stack/)：靠左的高个子可以把靠右相邻的矮个子都「挤掉」，相当于计算下一个更大元素，即 [单调栈的几种模板实现](https://labuladong.online/algo/problem-set/monotonic-stack/) 中的 `nextGreaterElement` 函数。

只不过这道题不是问你下一个更大元素是多少，而是问你当前元素和下一个更大元素之间的元素个数，直接看解法代码吧。

**详细题解**：
  - [【练习】单调栈的几种变体及经典习题](https://labuladong.online/algo/problem-set/monotonic-stack/)

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
#include <stack>
using namespace std;

class Solution {
public:
    vector<int> canSeePersonsCount(vector<int>& heights) {
        int n = heights.size();
        vector<int> res(n);
        // int[] 记录 {身高，小于等于该身高的人数} 二元组
        stack<int> stk;
        for (int i = n - 1; i >= 0; i--) {
            // 记录右侧比自己矮的人
            int count = 0;
            // 单调栈模板，计算下一个更大或相等元素（身高）
            while (!stk.empty() && heights[i] > stk.top()) {
                stk.pop();
                count++;
            }
            // 不仅可以看到比自己矮的人，如果后面存在更高的的人，也可以看到这个高人
            res[i] = stk.empty() ? count : count + 1;
            stk.push(heights[i]);
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
    def canSeePersonsCount(self, heights):
        n = len(heights)
        res = [0] * n
        # int[] 记录 {身高，小于等于该身高的人数} 二元组
        stk = []
        for i in range(n - 1, -1, -1):
            # 记录右侧比自己矮的人
            count = 0
            # 单调栈模板，计算下一个更大或相等元素（身高）
            while stk and heights[i] > stk[-1]:
                stk.pop()
                count += 1
            # 不仅可以看到比自己矮的人，如果后面存在更高的的人，也可以看到这个高人
            res[i] = count if not stk else count + 1
            stk.append(heights[i])
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        // int[] 记录 {身高，小于等于该身高的人数} 二元组
        Stack<Integer> stk = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            // 记录右侧比自己矮的人
            int count = 0;
            // 单调栈模板，计算下一个更大或相等元素（身高）
            while (!stk.isEmpty() && heights[i] > stk.peek()) {
                stk.pop();
                count++;
            }
            // 不仅可以看到比自己矮的人，如果后面存在更高的的人，也可以看到这个高人
            res[i] = stk.isEmpty() ? count : count + 1;
            stk.push(heights[i]);
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

func canSeePersonsCount(heights []int) []int {
    n := len(heights)
    res := make([]int, n)
    // int[] 记录 {身高，小于等于该身高的人数} 二元组
    stk := []int{}
    for i := n - 1; i >= 0; i-- {
        // 记录右侧比自己矮的人
        count := 0
        // 单调栈模板，计算下一个更大或相等元素（身高）
        for len(stk) > 0 && heights[i] > stk[len(stk)-1] {
            stk = stk[:len(stk)-1]
            count++
        }
        // 不仅可以看到比自己矮的人，如果后面存在更高的的人，也可以看到这个高人
        res[i] = 0
        if len(stk) > 0 {
            res[i] = count + 1
        } else {
            res[i] = count
        }
        stk = append(stk, heights[i])
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var canSeePersonsCount = function(heights) {
    let n = heights.length;
    let res = new Array(n).fill(0);
    // int[] 记录 {身高，小于等于该身高的人数} 二元组
    let stk = [];
    for (let i = n - 1; i >= 0; i--) {
        // 记录右侧比自己矮的人
        let count = 0;
        // 单调栈模板，计算下一个更大或相等元素（身高）
        while (stk.length > 0 && heights[i] > stk[stk.length - 1]) {
            stk.pop();
            count++;
        }
        // 不仅可以看到比自己矮的人，如果后面存在更高的的人，也可以看到这个高人
        res[i] = stk.length === 0 ? count : count + 1;
        stk.push(heights[i]);
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_number-of-visible-people-in-a-queue"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_number-of-visible-people-in-a-queue"></div></div>
</details><hr /><br />

</div>
</details>
</div>

