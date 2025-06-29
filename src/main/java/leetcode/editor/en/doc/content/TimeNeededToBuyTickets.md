<p>There are <code>n</code> people in a line queuing to buy tickets, where the <code>0<sup>th</sup></code> person is at the <strong>front</strong> of the line and the <code>(n - 1)<sup>th</sup></code> person is at the <strong>back</strong> of the line.</p>

<p>You are given a <strong>0-indexed</strong> integer array <code>tickets</code> of length <code>n</code> where the number of tickets that the <code>i<sup>th</sup></code> person would like to buy is <code>tickets[i]</code>.</p>

<p>Each person takes <strong>exactly 1 second</strong> to buy a ticket. A person can only buy <strong>1 ticket at a time</strong> and has to go back to <strong>the end</strong> of the line (which happens <strong>instantaneously</strong>) in order to buy more tickets. If a person does not have any tickets left to buy, the person will <strong>leave </strong>the line.</p>

<p>Return the <strong>time taken</strong> for the person <strong>initially</strong> at position <strong>k</strong><strong> </strong>(0-indexed) to finish buying tickets.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">tickets = [2,3,2], k = 2</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">6</span></p>

<p><strong>Explanation:</strong></p>

<ul> 
 <li>The queue starts as [2,3,<u>2</u>], where the kth person is underlined.</li> 
 <li>After the person at the front has bought a ticket, the queue becomes [3,<u>2</u>,1] at 1 second.</li> 
 <li>Continuing this process, the queue becomes [<u>2</u>,1,2] at 2 seconds.</li> 
 <li>Continuing this process, the queue becomes [1,2,<u>1</u>] at 3 seconds.</li> 
 <li>Continuing this process, the queue becomes [2,<u>1</u>] at 4 seconds. Note: the person at the front left the queue.</li> 
 <li>Continuing this process, the queue becomes [<u>1</u>,1] at 5 seconds.</li> 
 <li>Continuing this process, the queue becomes [1] at 6 seconds. The kth person has bought all their tickets, so return 6.</li> 
</ul>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">tickets = [5,1,1,1], k = 0</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">8</span></p>

<p><strong>Explanation:</strong></p>

<ul> 
 <li>The queue starts as [<u>5</u>,1,1,1], where the kth person is underlined.</li> 
 <li>After the person at the front has bought a ticket, the queue becomes [1,1,1,<u>4</u>] at 1 second.</li> 
 <li>Continuing this process for 3 seconds, the queue becomes [<u>4]</u> at 4 seconds.</li> 
 <li>Continuing this process for 4 seconds, the queue becomes [] at 8 seconds. The kth person has bought all their tickets, so return 8.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>n == tickets.length</code></li> 
 <li><code>1 &lt;= n &lt;= 100</code></li> 
 <li><code>1 &lt;= tickets[i] &lt;= 100</code></li> 
 <li><code>0 &lt;= k &lt; n</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Queue | Simulation</details><br>

<div>👍 1767, 👎 159<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

既然是排队问题，你用一个队列模拟整个买票过程，然后数一数过了多少秒就行了，不过时间空间复杂度就高了。

稍微思考一下可以想到更高效的方式：

首先，第 `k` 个人离开的时间，其实就是从开始到这个人买完票之后，卖出的总票数。

那么第 `k` 个人买完票之后，总共卖了多少票呢？

排在 `k` 之前的人最多买了 `tickets[k]` 张票；而排在 `k` 之后的人最多买了 `tickets[k] - 1` 张票。为什么说「最多」呢，因为有的人可能需要的票比较少，买完就直接走了。

综上，思路就出来了，看代码理解吧。

**详细题解**：
  - [【练习】队列的经典习题](https://labuladong.online/algo/problem-set/queue/)

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
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        int res = 0;
        for (int i = 0; i < tickets.size(); i++) {
            if (i <= k) {
                // 前面的人最多买了 tickets[k] 张票
                res += min(tickets[k], tickets[i]);
            } else {
                // 后面的人最多买了 tickets[k] - 1 张票
                res += min(tickets[k] - 1, tickets[i]);
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
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        res = 0
        for i in range(len(tickets)):
            if i <= k:
                # 前面的人最多买了 tickets[k] 张票
                res += min(tickets[k], tickets[i])
            else:
                # 后面的人最多买了 tickets[k] - 1 张票
                res += min(tickets[k] - 1, tickets[i])
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                // 前面的人最多买了 tickets[k] 张票
                res += Math.min(tickets[k], tickets[i]);
            } else {
                // 后面的人最多买了 tickets[k] - 1 张票
                res += Math.min(tickets[k] - 1, tickets[i]);
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

func timeRequiredToBuy(tickets []int, k int) int {
    res := 0
    for i := 0; i < len(tickets); i++ {
        if i <= k {
            // 前面的人最多买了 tickets[k] 张票
            res += int(math.Min(float64(tickets[k]), float64(tickets[i])))
        } else {
            // 后面的人最多买了 tickets[k] - 1 张票
            res += int(math.Min(float64(tickets[k] - 1), float64(tickets[i])))
        }
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var timeRequiredToBuy = function(tickets, k) {
    let res = 0;
    for (let i = 0; i < tickets.length; i++) {
        if (i <= k) {
            // 前面的人最多买了 tickets[k] 张票
            res += Math.min(tickets[k], tickets[i]);
        } else {
            // 后面的人最多买了 tickets[k] - 1 张票
            res += Math.min(tickets[k] - 1, tickets[i]);
        }
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_time-needed-to-buy-tickets"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_time-needed-to-buy-tickets"></div></div>
</details><hr /><br />

</div>
</details>
</div>

