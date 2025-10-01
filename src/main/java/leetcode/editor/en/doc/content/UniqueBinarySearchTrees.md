<p>Given an integer <code>n</code>, return <em>the number of structurally unique <strong>BST'</strong>s (binary search trees) which has exactly </em><code>n</code><em> nodes of unique values from</em> <code>1</code> <em>to</em> <code>n</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/uniquebstn3.jpg" style="width: 600px; height: 148px;" /> 
<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> 5
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 19</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Math | Dynamic Programming | Tree | Binary Search Tree | Binary Tree</details><br>

<div>👍 10831, 👎 438<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/bst-part3/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

假设给算法输入 `n = 5`，也就是说用 `{1,2,3,4,5}` 这些数字去构造 BST。

如果固定 `3` 作为根节点，左子树节点就是 `{1,2}` 的组合，右子树就是 `{4,5}` 的组合：

![](https://labuladong.online/algo/images/bst-iii/1.jpeg)

那么 `{1,2}` 和 `{4,5}` 的组合有多少种呢？只要合理定义递归函数，这些可以交给递归函数去做。

另外，这题存在重叠子问题，可以通过备忘录的方式消除冗余计算。

**详细题解**：
  - [二叉搜索树心法（构造篇）](https://labuladong.online/algo/data-structure/bst-part3/)

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
    // 备忘录
    vector<vector<int>> memo;

    int numTrees(int n) {
        // 备忘录的值初始化为 0
        memo = vector<vector<int>>(n + 1, vector<int>(n + 1, 0));
        return count(1, n);
    }

private:
    // 定义：返回 [lo, hi] 范围内构造的不同 BST 的数量
    int count(int lo, int hi) {
        if (lo >= hi) return 1;
        // 查备忘录
        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }

        int res = 0;
        for (int mid = lo; mid <= hi; mid++) {
            int left = count(lo, mid - 1);
            int right = count(mid + 1, hi);
            res += left * right;
        }
        // 将结果存入备忘录
        memo[lo][hi] = res;

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
    # 备忘录
    def __init__(self):
        self.memo = []

    def numTrees(self, n: int) -> int:
        # 备忘录的值初始化为 0
        self.memo = [[0] * (n + 1) for _ in range(n + 1)]
        return self.count(1, n)

    # 定义：返回 [lo, hi] 范围内构造的不同 BST 的数量
    def count(self, lo: int, hi: int) -> int:
        if lo >= hi:
            return 1
        # 查备忘录
        if self.memo[lo][hi] != 0:
            return self.memo[lo][hi]

        res = 0
        for mid in range(lo, hi + 1):
            left = self.count(lo, mid - 1)
            right = self.count(mid + 1, hi)
            res += left * right
        # 将结果存入备忘录
        self.memo[lo][hi] = res

        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 备忘录
    int[][] memo;

    int numTrees(int n) {
        // 备忘录的值初始化为 0
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    // 定义：返回 [lo, hi] 范围内构造的不同 BST 的数量
    int count(int lo, int hi) {
        if (lo >= hi) return 1;
        // 查备忘录
        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }

        int res = 0;
        for (int mid = lo; mid <= hi; mid++) {
            int left = count(lo, mid - 1);
            int right = count(mid + 1, hi);
            res += left * right;
        }
        // 将结果存入备忘录
        memo[lo][hi] = res;

        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 备忘录
func numTrees(n int) int {
    // 备忘录的值初始化为 0
    memo := make([][]int, n+1)
    for i := range memo {
        memo[i] = make([]int, n+1)
    }
    return count(1, n, memo)
}

// 定义：返回 [lo, hi] 范围内构造的不同 BST 的数量
func count(lo, hi int, memo [][]int) int {
    if lo >= hi {
        return 1
    }
    // 查备忘录
    if memo[lo][hi] != 0 {
        return memo[lo][hi]
    }

    res := 0
    for mid := lo; mid <= hi; mid++ {
        left := count(lo, mid-1, memo)
        right := count(mid+1, hi, memo)
        res += left * right
    }
    // 将结果存入备忘录
    memo[lo][hi] = res

    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var numTrees = function(n) {
    // 备忘录
    let memo = Array.from({length: n + 1}, () => Array(n + 1).fill(0));

    // 备忘录的值初始化为 0
    var count = function(lo, hi) {
        if (lo >= hi) return 1;
        // 查备忘录
        if (memo[lo][hi] !== 0) {
            return memo[lo][hi];
        }

        let res = 0;
        for (let mid = lo; mid <= hi; mid++) {
            let left = count(lo, mid - 1);
            let right = count(mid + 1, hi);
            res += left * right;
        }
        // 将结果存入备忘录
        memo[lo][hi] = res;

        return res;
    };

    // 定义：返回 [lo, hi] 范围内构造的不同 BST 的数量
    return count(1, n);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_unique-binary-search-trees"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_unique-binary-search-trees"></div></div>
</details><hr /><br />

</div>
</details>
</div>

