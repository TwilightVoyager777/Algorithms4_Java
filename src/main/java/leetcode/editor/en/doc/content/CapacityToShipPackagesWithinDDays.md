<p>A conveyor belt has packages that must be shipped from one port to another within <code>days</code> days.</p>

<p>The <code>i<sup>th</sup></code> package on the conveyor belt has a weight of <code>weights[i]</code>. Each day, we load the ship with packages on the conveyor belt (in the order given by <code>weights</code>). We may not load more weight than the maximum weight capacity of the ship.</p>

<p>Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within <code>days</code> days.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> weights = [1,2,3,4,5,6,7,8,9,10], days = 5
<strong>Output:</strong> 15
<strong>Explanation:</strong> A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> weights = [3,2,2,4,1,4], days = 3
<strong>Output:</strong> 6
<strong>Explanation:</strong> A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> weights = [1,2,3,1,1], days = 4
<strong>Output:</strong> 3
<strong>Explanation:</strong>
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= days &lt;= weights.length &lt;= 5 * 10<sup>4</sup></code></li> 
 <li><code>1 &lt;= weights[i] &lt;= 500</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Binary Search</details><br>

<div>👍 10453, 👎 268<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/frequency-interview/binary-search-in-action/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

正如 [二分搜索思路运用篇](https://labuladong.online/algo/frequency-interview/binary-search-in-action/) 所说，二分搜索的套路比较固定，如果遇到一个算法问题，能够确定 `x, f(x), target` 分别是什么，并写出单调函数 `f` 的代码，那么就可以运用二分搜索的思路求解。

船的运载能力就是自变量 `x`，运输天数和运载能力成反比，所以可以定义 `f(x)` 表示 `x` 的运载能力下需要的运输天数，`target` 显然就是运输天数 `D`，我们要在 `f(x) == D` 的约束下，算出船的最小载重 `x`。

![](https://labuladong.online/algo/images/binary-search-in-action/5.jpeg)

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

#include <vector>
#include <algorithm>

class Solution {
public:
    int shipWithinDays(std::vector<int>& weights, int days) {
        int left = 0;
        int right = 1;
        for (int w : weights) {
            left = std::max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // 定义：当运载能力为 x 时，需要 f(x) 天运完所有货物
    // f(x) 随着 x 的增加单调递减
    int f(std::vector<int>& weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.size(); ) {
            // 尽可能多装货物
            int cap = x;
            while (i < weights.size()) {
                if (cap < weights[i]) break;
                else cap -= weights[i];
                i++;
            }
            days++;
        }
        return days;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        left = 0
        right = 1
        for w in weights:
            left = max(left, w)
            right += w

        while left < right:
            mid = left + (right - left) // 2
            if self.f(weights, mid) <= days:
                right = mid
            else:
                left = mid + 1

        return left

    # 定义：当运载能力为 x 时，需要 f(x) 天运完所有货物
    # f(x) 随着 x 的增加单调递减
    def f(self, weights: List[int], x: int) -> int:
        days = 0
        i = 0
        while i < len(weights):
            # 尽可能多装货物
            cap = x
            while i < len(weights):
                if cap < weights[i]:
                    break
                else:
                    cap -= weights[i]
                    i += 1
            days += 1
        return days
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 1;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // 定义：当运载能力为 x 时，需要 f(x) 天运完所有货物
    // f(x) 随着 x 的增加单调递减
    int f(int[] weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.length; ) {
            // 尽可能多装货物
            int cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) break;
                else cap -= weights[i];
                i++;
            }
            days++;
        }
        return days;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func shipWithinDays(weights []int, days int) int {
    left, right := 0, 1
    for _, w := range weights {
        left = max(left, w)
        right += w
    }

    for left < right {
        mid := left + (right-left)/2
        if f(weights, mid) <= days {
            right = mid
        } else {
            left = mid + 1
        }
    }

    return left
}

// 定义：当运载能力为 x 时，需要 f(x) 天运完所有货物
// f(x) 随着 x 的增加单调递减
func f(weights []int, x int) int {
    days := 0
    for i := 0; i < len(weights); {
        // 尽可能多装货物
        cap := x
        for i < len(weights) {
            if cap < weights[i] {
                break
            }
            cap -= weights[i]
            i++
        }
        days++
    }
    return days
}

func max(x, y int) int {
    if x > y {
        return x
    }
    return y
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var shipWithinDays = function(weights, days) {
    let left = 0;
    let right = 1;
    for (let w of weights) {
        left = Math.max(left, w);
        right += w;
    }

    while (left < right) {
        let mid = left + Math.floor((right - left) / 2);
        if (f(weights, mid) <= days) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }

    return left;
    
    // 定义：当运载能力为 x 时，需要 f(x) 天运完所有货物
    // f(x) 随着 x 的增加单调递减
    function f(weights, x) {
        let days = 0;
        for (let i = 0; i < weights.length; ) {
            // 尽可能多装货物
            let cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) break;
                else cap -= weights[i];
                i++;
            }
            days++;
        }
        return days;
    }
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_capacity-to-ship-packages-within-d-days"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_capacity-to-ship-packages-within-d-days"></div></div>
</details><hr /><br />

</div>
</details>
</div>

