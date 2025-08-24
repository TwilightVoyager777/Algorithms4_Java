<p>Design an algorithm that collects daily price quotes for some stock and returns <strong>the span</strong> of that stock's price for the current day.</p>

<p>The <strong>span</strong> of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.</p>

<ul> 
 <li>For example, if the prices of the stock in the last four days is <code>[7,2,1,2]</code> and the price of the stock today is <code>2</code>, then the span of today is <code>4</code> because starting from today, the price of the stock was less than or equal <code>2</code> for <code>4</code> consecutive days.</li> 
 <li>Also, if the prices of the stock in the last four days is <code>[7,34,1,2]</code> and the price of the stock today is <code>8</code>, then the span of today is <code>3</code> because starting from today, the price of the stock was less than or equal <code>8</code> for <code>3</code> consecutive days.</li> 
</ul>

<p>Implement the <code>StockSpanner</code> class:</p>

<ul> 
 <li><code>StockSpanner()</code> Initializes the object of the class.</li> 
 <li><code>int next(int price)</code> Returns the <strong>span</strong> of the stock's price given that today's price is <code>price</code>.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
<strong>Output</strong>
[null, 1, 1, 1, 2, 1, 4, 6]

<strong>Explanation</strong>
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= price &lt;= 10<sup>5</sup></code></li> 
 <li>At most <code>10<sup>4</sup></code> calls will be made to <code>next</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Stack | Design | Monotonic Stack | Data Stream</details><br>

<div>👍 6949, 👎 475<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题显然要用到 [单调栈技巧](https://labuladong.online/algo/data-structure/monotonic-stack/)：当加入 `price` 时，把所有小于等于 `price` 的价格都「挤掉」，相当于计算前一个更大元素，即 [单调栈的几种模板实现](https://labuladong.online/algo/problem-set/monotonic-stack/) 中的 `prevGreaterElement` 函数。

比如已经入栈的价格序列是 `[40, 30, 20, 10]`，那么如果执行 `next(25)`，价格序列变成 `[40, 30, 25]`，20 和 10 都会被「挤掉」，算上 25 本身，函数返回 2 + 1 = 3。

**但还有个问题，这个 3 应该作为「权重」和 25 一同存储在栈中**。因为之后 25 还可能被挤掉，比如说执行 `next(26)`，价格序列就变成了 `[40, 30, 26]`，但这种情况下之前的 20 和 10 显然也应该被挤掉，函数应该返回 3 + 1 = 4。具体解法看代码吧。

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

class StockSpanner {
    // int[] 记录 {价格，小于等于该价格的天数} 二元组
    stack<pair<int, int>> stk;

public:
    int next(int price) {
        // 算上当天
        int count = 1;
        // 单调栈模板
        while (!stk.empty() && price >= stk.top().first) {
            // 挤掉价格低于 price 的记录
            pair<int, int> prev = stk.top();
            stk.pop();
            // 计算小于等于 price 的天数
            count += prev.second;
        }
        stk.push({price, count});

        return count;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class StockSpanner:
    # int[] 记录 {价格，小于等于该价格的天数} 二元组
    def __init__(self):
        self.stk = []

    def next(self, price: int) -> int:
        # 算上当天
        count = 1
        # 单调栈模板
        while self.stk and price >= self.stk[-1][0]:
            # 挤掉价格低于 price 的记录
            prev = self.stk.pop()
            # 计算小于等于 price 的天数
            count += prev[1]
        self.stk.append([price, count])

        return count
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class StockSpanner {
    // int[] 记录 {价格，小于等于该价格的天数} 二元组
    Stack<int[]> stk = new Stack<>();

    public int next(int price) {
        // 算上当天
        int count = 1;
        // 单调栈模板
        while (!stk.isEmpty() && price >= stk.peek()[0]) {
            // 挤掉价格低于 price 的记录
            int[] prev = stk.pop();
            // 计算小于等于 price 的天数
            count += prev[1];
        }
        stk.push(new int[]{price, count});

        return count;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

type StockSpanner struct {
    // int[] 记录 {价格，小于等于该价格的天数} 二元组
    stk [][2]int
}

func Constructor() StockSpanner {
    return StockSpanner{stk: make([][2]int, 0)}
}

func (this *StockSpanner) Next(price int) int {
    // 算上当天
    count := 1
    // 单调栈模板
    for len(this.stk) > 0 && price >= this.stk[len(this.stk)-1][0] {
        // 挤掉价格低于 price 的记录
        prev := this.stk[len(this.stk)-1]
        this.stk = this.stk[:len(this.stk)-1]
        // 计算小于等于 price 的天数
        count += prev[1]
    }
    this.stk = append(this.stk, [2]int{price, count})

    return count
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var StockSpanner = function() {
    // int[] 记录 {价格，小于等于该价格的天数} 二元组
    this.stk = [];
};

StockSpanner.prototype.next = function(price) {
    // 算上当天
    let count = 1;
    // 单调栈模板
    while (this.stk.length > 0 && price >= this.stk[this.stk.length - 1][0]) {
        // 挤掉价格低于 price 的记录
        let prev = this.stk.pop();
        // 计算小于等于 price 的天数
        count += prev[1];
    }
    this.stk.push([price, count]);

    return count;
};
```

</div></div>
</div></div>

</div>
</details>
</div>

