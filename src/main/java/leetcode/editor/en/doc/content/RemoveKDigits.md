<p>Given string num representing a non-negative integer <code>num</code>, and an integer <code>k</code>, return <em>the smallest possible integer after removing</em> <code>k</code> <em>digits from</em> <code>num</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> num = "1432219", k = 3
<strong>Output:</strong> "1219"
<strong>Explanation:</strong> Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> num = "10200", k = 1
<strong>Output:</strong> "200"
<strong>Explanation:</strong> Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> num = "10", k = 2
<strong>Output:</strong> "0"
<strong>Explanation:</strong> Remove all the digits from the number and it is left with nothing which is 0.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= k &lt;= num.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>num</code> consists of only digits.</li> 
 <li><code>num</code> does not have any leading zeros except for the zero itself.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>String | Stack | Greedy | Monotonic Stack</details><br>

<div>👍 10201, 👎 535<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

如果想让结果尽可能小，那么清除数字分两步：

1、先删除 `num` 中的若干数字，使得 `num` 从左到右每一位都单调递增。比如 `14329` 转化成 `129`，这需要使用到 [单调栈技巧](https://labuladong.online/algo/data-structure/monotonic-stack/)。

2、`num` 中的每一位变成单调递增的之后，如果 `k` 还大于 0（还可以继续删除）的话，则删除尾部的数字，比如 `129` 删除成 `12`。

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

#include <string>
#include <stack>
#include <algorithm>

class Solution {
public:
    std::string removeKdigits(std::string num, int k) {
        std::stack<char> stk;
        for (char c : num) {
            // 单调栈代码模板
            while (!stk.empty() && c < stk.top() && k > 0) {
                stk.pop();
                k--;
            }
            // 防止 0 作为数字的开头
            if (stk.empty() && c == '0') {
                continue;
            }
            stk.push(c);
        }

        // 此时栈中元素单调递增，若 k 还没用完的话删掉栈顶元素
        while (k > 0 && !stk.empty()) {
            stk.pop();
            k--;
        }
        // 若最后没剩下数字，就是 0
        if (stk.empty()) {
            return "0";
        }
        // 将栈中字符转化成字符串
        std::string result = "";
        while (!stk.empty()) {
            result += stk.top();
            stk.pop();
        }
        // 出栈顺序和字符串顺序是反的
        std::reverse(result.begin(), result.end());
        return result;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stk = []
        for c in num:
            # 单调栈代码模板
            while stk and k > 0 and c < stk[-1]:
                stk.pop()
                k -= 1
            # 防止 0 作为数字的开头
            if not stk and c == '0':
                continue
            stk.append(c)

        # 此时栈中元素单调递增，若 k 还没用完的话删掉栈顶元素
        final_stack = stk[:-k] if k else stk

        # 将栈中字符转化成字符串
        # 出栈顺序和字符串顺序是反的
        result = ''.join(final_stack).lstrip('0')

        # 若最后没剩下数字，就是 0
        return result if result else '0'
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<>();
        for (char c : num.toCharArray()) {
            // 单调栈代码模板
            while (!stk.isEmpty() && c < stk.peek() && k > 0) {
                stk.pop();
                k--;
            }
            // 防止 0 作为数字的开头
            if (stk.isEmpty() && c == '0') {
                continue;
            }
            stk.push(c);
        }

        // 此时栈中元素单调递增，若 k 还没用完的话删掉栈顶元素
        while (k > 0 && !stk.isEmpty()) {
            stk.pop();
            k--;
        }
        // 若最后没剩下数字，就是 0
        if (stk.isEmpty()) {
            return "0";
        }
        // 将栈中字符转化成字符串
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        // 出栈顺序和字符串顺序是反的
        return sb.reverse().toString();
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func removeKdigits(num string, k int) string {
    stk := []rune{}
    for _, c := range num {
        // 单调栈代码模板
        for len(stk) > 0 && c < stk[len(stk)-1] && k > 0 {
            stk = stk[:len(stk)-1]
            k--
        }
        // 防止 0 作为数字的开头
        if len(stk) == 0 && c == '0' {
            continue
        }
        stk = append(stk, c)
    }

    // 此时栈中元素单调递增，若 k 还没用完的话删掉栈顶元素
    for k > 0 && len(stk) > 0 {
        stk = stk[:len(stk)-1]
        k--
    }
    // 若最后没剩下数字，就是 0
    if len(stk) == 0 {
        return "0"
    }
    // 将栈中字符转化成字符串
    sb := []rune{}
    for len(stk) > 0 {
        sb = append(sb, stk[len(stk)-1])
        stk = stk[:len(stk)-1]
    }
    // 出栈顺序和字符串顺序是反的
    for i, j := 0, len(sb)-1; i < j; i, j = i+1, j-1 {
        sb[i], sb[j] = sb[j], sb[i]
    }
    return string(sb)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var removeKdigits = function(num, k) {
    let stk = [];
    for (let c of num) {
        // 单调栈代码模板
        while (stk.length > 0 && c < stk[stk.length - 1] && k > 0) {
            stk.pop();
            k--;
        }
        // 防止 0 作为数字的开头
        if (stk.length === 0 && c === '0') {
            continue;
        }
        stk.push(c);
    }

    // 此时栈中元素单调递增，若 k 还没用完的话删掉栈顶元素
    while (k > 0 && stk.length > 0) {
        stk.pop();
        k--;
    }
    // 若最后没剩下数字，就是 0
    if (stk.length === 0) {
        return "0";
    }
    // 将栈中字符转化成字符串
    let sb = '';
    while (stk.length > 0) {
        sb += stk.pop();
    }
    // 出栈顺序和字符串顺序是反的
    return sb.split('').reverse().join('');
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_remove-k-digits"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-k-digits"></div></div>
</details><hr /><br />

</div>
</details>
</div>

