<p>You are given an integer array <code>prices</code> where <code>prices[i]</code> is the price of the <code>i<sup>th</sup></code> item in a shop.</p>

<p>There is a special discount for items in the shop. If you buy the <code>i<sup>th</sup></code> item, then you will receive a discount equivalent to <code>prices[j]</code> where <code>j</code> is the minimum index such that <code>j &gt; i</code> and <code>prices[j] &lt;= prices[i]</code>. Otherwise, you will not receive any discount at all.</p>

<p>Return an integer array <code>answer</code> where <code>answer[i]</code> is the final price you will pay for the <code>i<sup>th</sup></code> item of the shop, considering the special discount.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> prices = [8,4,6,2,3]
<strong>Output:</strong> [4,2,4,2,3]
<strong>Explanation:</strong> 
For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4.
For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2.
For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4.
For items 3 and 4 you will not receive any discount at all.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> prices = [1,2,3,4,5]
<strong>Output:</strong> [1,2,3,4,5]
<strong>Explanation:</strong> In this case, for all items, you will not receive any discount at all.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> prices = [10,1,1,6]
<strong>Output:</strong> [9,0,1,6]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= prices.length &lt;= 500</code></li> 
 <li><code>1 &lt;= prices[i] &lt;= 1000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Stack | Monotonic Stack</details><br>

<div>👍 2771, 👎 140<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题就用到了 [单调栈的几种模板实现](https://labuladong.online/algo/problem-set/monotonic-stack/) 中讲到的一个单调栈模板：计算下一个更小或相等的元素。我是为了运用模板，所以把解法分成了两个函数，效率可能会降低一些，你完全可以优化这个解法的形式，使之更高效。

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

class Solution {
public:
    std::vector<int> finalPrices(std::vector<int>& prices) {
        int n = prices.size();
        std::vector<int> res(n);
        // 下一个小于等于 price[i] 的价格就是优惠券折扣
        std::vector<int> nextElement = nextLessOrEqualElement(prices);
        for (int i = 0; i < n; i++) {
            // 如果存在优惠券，则减少相应的价格
            if (nextElement[i] != -1) {
                res[i] = prices[i] - nextElement[i];
            } else {
                res[i] = prices[i];
            }
        }
        return res;
    }

    // 单调栈模板：计算 nums 中每个元素的下一个更小或相等的元素
    std::vector<int> nextLessOrEqualElement(std::vector<int>& nums) {
        int n = nums.size();
        // 存放答案的数组
        std::vector<int> res(n);
        std::stack<int> s;
        // 倒着往栈里放
        for (int i = n - 1; i >= 0; i--) {
            // 删掉 nums[i] 后面较大的元素
            while (!s.empty() && s.top() > nums[i]) {
                s.pop();
            }
            // 现在栈顶就是 nums[i] 身后的更小或相等元素
            res[i] = s.empty() ? -1 : s.top();
            s.push(nums[i]);
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
    def finalPrices(self, prices: List[int]) -> List[int]:
        n = len(prices)
        res = [0] * n
        # 下一个小于等于 price[i] 的价格就是优惠券折扣
        next_element = self.nextLessOrEqualElement(prices)
        for i in range(len(prices)):
            # 如果存在优惠券，则减少相应的价格
            if next_element[i] != -1:
                res[i] = prices[i] - next_element[i]
            else:
                res[i] = prices[i]
        return res

    # 单调栈模板：计算 nums 中每个元素的下一个更小或相等的元素
    def nextLessOrEqualElement(self, nums: List[int]) -> List[int]:
        n = len(nums)
        # 存放答案的数组
        res = [-1] * n
        s = []
        # 倒着往栈里放
        for i in range(n - 1, -1, -1):
            # 删掉 nums[i] 后面较大的元素
            while s and s[-1] > nums[i]:
                s.pop()
            # 现在栈顶就是 nums[i] 身后的更小或相等元素
            res[i] = s[-1] if s else -1
            s.append(nums[i])
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        // 下一个小于等于 price[i] 的价格就是优惠券折扣
        int[] nextElement = nextLessOrEqualElement(prices);
        for (int i = 0; i < prices.length; i++) {
            // 如果存在优惠券，则减少相应的价格
            if (nextElement[i] != -1) {
                res[i] = prices[i] - nextElement[i];
            } else {
                res[i] = prices[i];
            }
        }
        return res;
    }

    // 单调栈模板：计算 nums 中每个元素的下一个更小或相等的元素
    int[] nextLessOrEqualElement(int[] nums) {
        int n = nums.length;
        // 存放答案的数组
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        // 倒着往栈里放
        for (int i = n - 1; i >= 0; i--) {
            // 删掉 nums[i] 后面较大的元素
            while (!s.isEmpty() && s.peek() > nums[i]) {
                s.pop();
            }
            // 现在栈顶就是 nums[i] 身后的更小或相等元素
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
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

func finalPrices(prices []int) []int {
    n := len(prices)
    res := make([]int, n)
    // 下一个小于等于 price[i] 的价格就是优惠券折扣
    nextElement := nextLessOrEqualElement(prices)
    for i := 0; i < len(prices); i++ {
        // 如果存在优惠券，则减少相应的价格
        if nextElement[i] != -1 {
            res[i] = prices[i] - nextElement[i]
        } else {
            res[i] = prices[i]
        }
    }
    return res
}

// 单调栈模板：计算 nums 中每个元素的下一个更小或相等的元素
func nextLessOrEqualElement(nums []int) []int {
    n := len(nums)
    // 存放答案的数组
    res := make([]int, n)
    s := []int{}
    // 倒着往栈里放
    for i := n - 1; i >= 0; i-- {
        // 删掉 nums[i] 后面较大的元素
        for len(s) > 0 && s[len(s)-1] > nums[i] {
            s = s[:len(s)-1]
        }
        // 现在栈顶就是 nums[i] 身后的更小或相等元素
        if len(s) == 0 {
            res[i] = -1
        } else {
            res[i] = s[len(s)-1]
        }
        s = append(s, nums[i])
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var finalPrices = function(prices) {
    let n = prices.length;
    let res = new Array(n);
    // 下一个小于等于 price[i] 的价格就是优惠券折扣
    let nextElement = nextLessOrEqualElement(prices);
    for (let i = 0; i < prices.length; i++) {
        // 如果存在优惠券，则减少相应的价格
        if (nextElement[i] !== -1) {
            res[i] = prices[i] - nextElement[i];
        } else {
            res[i] = prices[i];
        }
    }
    return res;
};

// 单调栈模板：计算 nums 中每个元素的下一个更小或相等的元素
var nextLessOrEqualElement = function(nums) {
    let n = nums.length;
    // 存放答案的数组
    let res = new Array(n);
    let s = [];
    // 倒着往栈里放
    for (let i = n - 1; i >= 0; i--) {
        // 删掉 nums[i] 后面较大的元素
        while (s.length > 0 && s[s.length - 1] > nums[i]) {
            s.pop();
        }
        // 现在栈顶就是 nums[i] 身后的更小或相等元素
        res[i] = s.length === 0 ? -1 : s[s.length - 1];
        s.push(nums[i]);
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_final-prices-with-a-special-discount-in-a-shop"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_final-prices-with-a-special-discount-in-a-shop"></div></div>
</details><hr /><br />

</div>
</details>
</div>

