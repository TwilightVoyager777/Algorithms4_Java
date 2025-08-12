<p>Koko loves to eat bananas. There are <code>n</code> piles of bananas, the <code>i<sup>th</sup></code> pile has <code>piles[i]</code> bananas. The guards have gone and will come back in <code>h</code> hours.</p>

<p>Koko can decide her bananas-per-hour eating speed of <code>k</code>. Each hour, she chooses some pile of bananas and eats <code>k</code> bananas from that pile. If the pile has less than <code>k</code> bananas, she eats all of them instead and will not eat any more bananas during this hour.</p>

<p>Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.</p>

<p>Return <em>the minimum integer</em> <code>k</code> <em>such that she can eat all the bananas within</em> <code>h</code> <em>hours</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> piles = [3,6,7,11], h = 8
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> piles = [30,11,23,4,20], h = 5
<strong>Output:</strong> 30
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> piles = [30,11,23,4,20], h = 6
<strong>Output:</strong> 23
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= piles.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>piles.length &lt;= h &lt;= 10<sup>9</sup></code></li> 
 <li><code>1 &lt;= piles[i] &lt;= 10<sup>9</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Binary Search</details><br>

<div>👍 12606, 👎 832<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/frequency-interview/binary-search-in-action/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

正如 [二分搜索思路运用篇](https://labuladong.online/algo/frequency-interview/binary-search-in-action/) 所说，二分搜索的套路比较固定，如果遇到一个算法问题，能够确定 `x, f(x), target` 分别是什么，并写出单调函数 `f` 的代码，那么就可以运用二分搜索的思路求解。

这题珂珂吃香蕉的速度 `K` 就是自变量 `x`，吃完所有香蕉所需的时间就是单调函数 `f(x)`，`target` 就是吃香蕉的时间限制 `H`。我们需要调整 `x`，使得 `f(x)` 尽可能接近 `target`，也就是说，我们需要找到最小的 `x`，使得 `f(x) <= target`。

它们的关系如下图：

![](https://labuladong.online/algo/images/binary-search-in-action/4.jpeg)

关于本题二分搜索的具体思路见详细题解。

**详细题解**：
  - [实际运用二分搜索时的思维框架](https://labuladong.online/algo/frequency-interview/binary-search-in-action/)

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
    int minEatingSpeed(vector<int>& piles, int H) {
        int left = 1;
        int right = 1000000000 + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(piles, mid) <= H) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 定义：速度为 x 时，需要 f(x) 小时吃完所有香蕉
    // f(x) 随着 x 的增加单调递减
    long f(vector<int>& piles, int x) {
        long hours = 0;
        for (int i = 0; i < piles.size(); i++) {
            hours += piles[i] / x;
            if (piles[i] % x > 0) {
                hours++;
            }
        }
        return hours;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def minEatingSpeed(self, piles: List[int], H: int) -> int:
        left = 1
        right = 1000000000 + 1

        while left < right:
            mid = left + (right - left) // 2
            if self.f(piles, mid) <= H:
                right = mid
            else:
                left = mid + 1
        return left

    # 定义：速度为 x 时，需要 f(x) 小时吃完所有香蕉
    # f(x) 随着 x 的增加单调递减
    def f(self, piles: List[int], x: int) -> int:
        hours = 0
        for pile in piles:
            hours += pile // x
            if pile % x > 0:
                hours += 1
        return hours
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        int right = 1000000000 + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(piles, mid) <= H) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 定义：速度为 x 时，需要 f(x) 小时吃完所有香蕉
    // f(x) 随着 x 的增加单调递减
    long f(int[] piles, int x) {
        long hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / x;
            if (piles[i] % x > 0) {
                hours++;
            }
        }
        return hours;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func minEatingSpeed(piles []int, H int) int {
    left := 1
    right := 1000000000 + 1

    for left < right {
        mid := left + (right-left)/2
        if f(piles, mid) <= int64(H) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

// 定义：速度为 x 时，需要 f(x) 小时吃完所有香蕉
// f(x) 随着 x 的增加单调递减
func f(piles []int, x int) int64 {
    var hours int64
    for _, pile := range piles {
        hours += int64(pile / x)
        if pile % x > 0 {
            hours++
        }
    }
    return hours
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var minEatingSpeed = function(piles, H) {
    let left = 1;
    let right = 1000000000 + 1;

    while (left < right) {
        let mid = Math.floor(left + (right - left) / 2);
        if (f(piles, mid) <= H) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    return left;
};

// 定义：速度为 x 时，需要 f(x) 小时吃完所有香蕉
// f(x) 随着 x 的增加单调递减
var f = function(piles, x) {
    let hours = 0;
    for (let i = 0; i < piles.length; i++) {
        hours += Math.floor(piles[i] / x);
        if (piles[i] % x > 0) {
            hours++;
        }
    }
    return hours;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_koko-eating-bananas"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_koko-eating-bananas"></div></div>
</details><hr /><br />

</div>
</details>
</div>

