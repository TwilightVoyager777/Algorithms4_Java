<p>Given a parentheses string <code>s</code> containing only the characters <code>'('</code> and <code>')'</code>. A parentheses string is <strong>balanced</strong> if:</p>

<ul> 
 <li>Any left parenthesis <code>'('</code> must have a corresponding two consecutive right parenthesis <code>'))'</code>.</li> 
 <li>Left parenthesis <code>'('</code> must go before the corresponding two consecutive right parenthesis <code>'))'</code>.</li> 
</ul>

<p>In other words, we treat <code>'('</code> as an opening parenthesis and <code>'))'</code> as a closing parenthesis.</p>

<ul> 
 <li>For example, <code>"())"</code>, <code>"())(())))"</code> and <code>"(())())))"</code> are balanced, <code>")()"</code>, <code>"()))"</code> and <code>"(()))"</code> are not balanced.</li> 
</ul>

<p>You can insert the characters <code>'('</code> and <code>')'</code> at any position of the string to balance it if needed.</p>

<p>Return <em>the minimum number of insertions</em> needed to make <code>s</code> balanced.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = "(()))"
<strong>Output:</strong> 1
<strong>Explanation:</strong> The second '(' has two matching '))', but the first '(' has only ')' matching. We need to add one more ')' at the end of the string to be "(())))" which is balanced.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = "())"
<strong>Output:</strong> 0
<strong>Explanation:</strong> The string is already balanced.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = "))())("
<strong>Output:</strong> 3
<strong>Explanation:</strong> Add '(' to match the first '))', Add '))' to match the last '('.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>s</code> consists of <code>'('</code> and <code>')'</code> only.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>String | Stack | Greedy</details><br>

<div>👍 1222, 👎 286<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

你需要先做一下 [✔ ✨921. 使括号有效的最少添加](/problems/minimum-add-to-make-parentheses-valid/) 这道题，这道题进阶。

判断括号有效性的方法一般都是从左到右遍历，根据左括号和右括号的数量对比来判断是否是有效的括号串。但如果左右括号不是 1:1 配对，会出现什么问题呢？

**核心思路还是和 921 题一样，通过一个 `need` 变量记录对右括号的需求数，根据 `need` 的变化来判断是否需要插入**。

第一步，我们按照刚才的思路正确维护 `need` 变量：

```java
int minInsertions(String s) {
    // need 记录需右括号的需求量
    int res = 0, need = 0;
    for (int i = 0; i < s.length(); i++) {
        // 一个左括号对应两个右括号
        if (s.charAt(i) == '(') {
            need += 2;
        }

        if (s.charAt(i) == ')') {
            need--;
        }
    }
    return res + need;
}
```

现在想一想，当 `need` 为什么值的时候，我们可以确定需要进行插入？

**首先，类似第一题，当 `need == -1` 时，意味着我们遇到一个多余的右括号，显然需要插入一个左括号**。

比如说当 `s = ")"`，我们肯定需要插入一个左括号让 `s = "()"`，但是由于一个左括号需要两个右括号，所以对右括号的需求量变为 1。

**另外，当遇到左括号时，若对右括号的需求量为奇数，需要插入 1 个右括号**。因为一个左括号需要两个右括号嘛，右括号的需求必须是偶数，这一点也是本题的难点。

具体看代码吧。

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
    int minInsertions(string s) {
        // need 记录需右括号的需求量
        int res = 0, need = 0;

        for (int i = 0; i < s.length(); i++) {
            // 一个左括号对应两个右括号
            if (s[i] == '(') {
                need += 2;
                if (need % 2 == 1) {
                    // 插入一个右括号
                    res++;
                    need--;
                }
            }

            if (s[i] == ')') {
                need--;
                // 说明右括号太多了
                if (need == -1) {
                    // 需要插入一个左括号
                    res++;
                    // 同时，对右括号的需求变为 1
                    need = 1;
                }
            }
        }

        return res + need;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def minInsertions(self, s: str) -> int:
        # need 记录需右括号的需求量
        res = 0
        need = 0

        for i in range(len(s)):
            # 一个左括号对应两个右括号
            if s[i] == '(':
                need += 2
                if need % 2 == 1:
                    # 插入一个右括号
                    res += 1
                    need -= 1

            if s[i] == ')':
                need -= 1
                # 说明右括号太多了
                if need == -1:
                    # 需要插入一个左括号
                    res += 1
                    # 同时，对右括号的需求变为 1
                    need = 1

        return res + need
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int minInsertions(String s) {
        // need 记录需右括号的需求量
        int res = 0, need = 0;

        for (int i = 0; i < s.length(); i++) {
            // 一个左括号对应两个右括号
            if (s.charAt(i) == '(') {
                need += 2;
                if (need % 2 == 1) {
                    // 插入一个右括号
                    res++;
                    need--;
                }
            }

            if (s.charAt(i) == ')') {
                need--;
                // 说明右括号太多了
                if (need == -1) {
                    // 需要插入一个左括号
                    res++;
                    // 同时，对右括号的需求变为 1
                    need = 1;
                }
            }
        }

        return res + need;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func minInsertions(s string) int {
    // need 记录需右括号的需求量
    res, need := 0, 0

    for i := 0; i < len(s); i++ {
        // 一个左括号对应两个右括号
        if s[i] == '(' {
            need += 2
            if need % 2 == 1 {
                // 插入一个右括号
                res++
                need--
            }
        }

        if s[i] == ')' {
            need--
            // 说明右括号太多了
            if need == -1 {
                // 需要插入一个左括号
                res++
                // 同时，对右括号的需求变为 1
                need = 1
            }
        }
    }

    return res + need
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var minInsertions = function(s) {
    // need 记录需右括号的需求量
    let res = 0, need = 0;

    for (let i = 0; i < s.length; i++) {
        // 一个左括号对应两个右括号
        if (s.charAt(i) == '(') {
            need += 2;
            if (need % 2 == 1) {
                // 插入一个右括号
                res++;
                need--;
            }
        }

        if (s.charAt(i) == ')') {
            need--;
            // 说明右括号太多了
            if (need == -1) {
                // 需要插入一个左括号
                res++;
                // 同时，对右括号的需求变为 1
                need = 1;
            }
        }
    }

    return res + need;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_minimum-insertions-to-balance-a-parentheses-string"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_minimum-insertions-to-balance-a-parentheses-string"></div></div>
</details><hr /><br />

</div>
</details>
</div>

